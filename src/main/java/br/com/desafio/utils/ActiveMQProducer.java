package br.com.desafio.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class ActiveMQProducer {

	@Autowired
    private JmsTemplate jmsTemplate;

    private final String queueName = "filaApolice";

    public void sendMessage(String message) {
        jmsTemplate.convertAndSend(queueName, message);
    }
}
