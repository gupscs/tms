package br.silveira.tms.view.orderMng;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.silveira.tms.converter.ExcelConverter;
import br.silveira.tms.converter.SearchViewConverters;
import br.silveira.tms.excel.ExcelTransportOrderLayout;
import br.silveira.tms.excel.dto.ExcelTransportOrderDto;
import br.silveira.tms.svc.transportOrder.ctr.TransportOrderCtr;
import br.silveira.tms.svc.transportOrder.dto.TransportOrderDto;
import br.silveira.tms.view.CommonView;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class OrderMngView extends CommonView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final Logger log = LoggerFactory.getLogger(OrderMngView.class);

	@Getter
	@Setter
	private OrderMngSearchView searchView;

	@Getter
	private List<TransportOrderDto> transportOrdersHeader;
	
	@Getter
	@Setter
	private List<ExcelTransportOrderDto> excelTransportOrderDto;

	private UploadedFile transpOrderUploadfile;

	@Autowired
	private TransportOrderCtr transportOrderCtr;
	
	public UploadedFile getTranspOrderUploadfile() {
		return transpOrderUploadfile;
	}

	public void setTranspOrderUploadfile(UploadedFile transpOrderUploadfile) {
		this.transpOrderUploadfile = transpOrderUploadfile;
		transpOrderUpload();
	}

	@PostConstruct
	public void init() {
		searchView = new OrderMngSearchView();
	}
	
	public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }


	public void search() {
		System.out.println(String.format("ETD: %s | TO: %s", searchView.getEtd(), searchView.getListTO()));
		transportOrdersHeader = transportOrderCtr.findTransportOrderHeader(SearchViewConverters.convertToTransOrderSearchDto(searchView));
	}

	public void transpOrderUpload() {
		File file = new File(transpOrderUploadfile.getFileName());
		try (OutputStream out = new FileOutputStream(file)){
			out.write(transpOrderUploadfile.getContent());
			excelTransportOrderDto = ExcelTransportOrderLayout.readExcel(new XSSFWorkbook(file));
		} catch (IOException e) {
			String err = getMessage("error.upload.excel.notread");
			log.error(err, e);
			errorMessage("msg-order-mng-upload-order-dialog","error.upload.excel.notread");
		} catch (InvalidFormatException e) {
			String err = getMessage("error.upload.excel.wrongformat");
			log.error(err, e);
			errorMessage("msg-order-mng-upload-order-dialog","error.upload.excel.wrongformat");
		}

	}

	public void listTransportOrderSave() {
		if(Optional.of(excelTransportOrderDto).isEmpty()) {
			warnMessage("msg-order-mng-upload-order-dialog", "warn.upload.excel.emptylist");
			return;
		}
		
		
		try {
			List<TransportOrderDto> listDto = ExcelConverter.excelTransportOrderDtoConverter(excelTransportOrderDto);
			List<String[]> listErr = new ArrayList<String[]>();
			
			for (TransportOrderDto transportOrderDto : listDto) {
				try {
					transportOrderCtr.saveTransportOrder(transportOrderDto);
				}catch(Exception e ) {
					String err = getMessage("error.transport-order.save");
					log.error(err, e);
					listErr.add(new String[] {transportOrderDto.getToNo(), err + " : "+e.getMessage()});
				}
			}
			
			resultAfterSaving(listErr);
			
			
		}catch(Exception e) {
			String err = getMessage("error.transport-order.save");
			log.error(err, e);
			errorMessage("msg-order-mng-upload-order-dialog","error.transport-order.save");
		}
	}

	private void resultAfterSaving(List<String[]> listErr) {
		if(listErr.isEmpty()) {
			infoMessage("msg-order-mng-upload-order-dialog", "info.transport-order.savesucess");
		}else {
			List<ExcelTransportOrderDto> excelError = new ArrayList<ExcelTransportOrderDto>();
			for (String[] errTo : listErr) {
				for (ExcelTransportOrderDto excelDto : excelTransportOrderDto) {
					if(excelDto.getToNo().equalsIgnoreCase(errTo[0])) {
						excelDto.setStatusProcess(errTo[1]);
						excelError.add(excelDto);
					}
				}
			}
			excelTransportOrderDto = excelError;
			errorMessage("msg-order-mng-upload-order-dialog","error.transport-order.saveresult");
		}
	}
	

}
