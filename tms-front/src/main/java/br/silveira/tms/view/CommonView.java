package br.silveira.tms.view;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.silveira.tms.dto.UserDto;

public class CommonView {
	
	private String locale = "pt_br";
	
	private UserDto userDto = new UserDto();

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	
	public String getMessage(String messageKey) {
		FacesContext context = FacesContext.getCurrentInstance();
		return context.getApplication().getResourceBundle(context, "msg").getString(messageKey);
	}
	
	public void errorMessage(String forMessage, String messageKey) {
		String title = getMessage("label.error");
		String msg = getMessage(messageKey);
		FacesContext.getCurrentInstance().addMessage(forMessage, new FacesMessage(FacesMessage.SEVERITY_ERROR, title, msg));
	}
	
	public void warnMessage(String forMessage, String messageKey) {
		String title = getMessage("label.warn");
		String msg = getMessage(messageKey);
		FacesContext.getCurrentInstance().addMessage(forMessage, new FacesMessage(FacesMessage.SEVERITY_WARN, title, msg));
	}
	
	public void infoMessage(String forMessage, String messageKey) {
		String title = getMessage("label.info");
		String msg = getMessage(messageKey);
		FacesContext.getCurrentInstance().addMessage(forMessage, new FacesMessage(FacesMessage.SEVERITY_INFO, title, msg));
	}
	
	
	
	
	
	
	

}
