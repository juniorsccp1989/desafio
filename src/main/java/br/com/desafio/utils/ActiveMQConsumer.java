package br.com.desafio.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import br.com.desafio.service.impl.CotacaoServiceImpl;

@Service
public class ActiveMQConsumer {
	
	private static final Logger logger = LoggerFactory.getLogger(CotacaoServiceImpl.class);

    @JmsListener(destination = "filaApolice")
    public void receiveMessage(String message) {
       logger.info("Mensagem recebida: " + message);
    }
}
