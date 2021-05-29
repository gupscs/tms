package br.silveira.tms;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InitialProcedureStartup {
	
	private static final Logger log = LogManager.getLogger(InitialProcedureStartup.class);

	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() throws IOException {
	    log.info("Iniciando configuração da aplicação");
	    
	    log.info("Configuração da aplicação Finalizado");
	}


	
}
