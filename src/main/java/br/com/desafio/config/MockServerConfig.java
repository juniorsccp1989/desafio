package br.com.desafio.config;

import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MockServerConfig {
	
	@Bean
    public ClientAndServer mockServer() {
        ClientAndServer mockServer = ClientAndServer.startClientAndServer(1080);

        mockServer.when(
            HttpRequest.request()
                .withMethod("GET")
                .withPath("/desafio/product/1b2da7cc-b367-4196-8a78-9cfeec21f587")
        ).respond(
            HttpResponse.response()
                .withStatusCode(200)
                .withHeader("Content-Type", "application/json")
                .withBody("{\r\n"
                		+ "\"id\": \"1b2da7cc-b367-4196-8a78-9cfeec21f587\",\r\n"
                		+ "\"name\": \"Seguro de Vida\",\r\n"
                		+ "\"created_at\": \"2021-07-01T00:00:00Z\",\r\n"
                		+ "\"active\": true,\r\n"
                		+ "\"offers\": [\r\n"
                		+ "\"adc56d77-348c-4bf0-908f-22d402ee715c\",\r\n"
                		+ "\"bdc56d77-348c-4bf0-908f-22d402ee715c\",\r\n"
                		+ "\"cdc56d77-348c-4bf0-908f-22d402ee715c\"\r\n"
                		+ "]\r\n"
                		+ "}")
        );
        
        mockServer.when(
                HttpRequest.request()
                    .withMethod("GET")
                    .withPath("/desafio/offers/adc56d77-348c-4bf0-908f-22d402ee715c")
            ).respond(
                HttpResponse.response()
                    .withStatusCode(200)
                    .withHeader("Content-Type", "application/json")
                    .withBody("{\r\n"
                    		+ "\"id\": \"adc56d77-348c-4bf0-908f-22d402ee715c\",\r\n"
                    		+ "\"product_id\": \"1b2da7cc-b367-4196-8a78-9cfeec21f587\",\r\n"
                    		+ "\"name\": \"Seguro de Vida Familiar\",\r\n"
                    		+ "\"created_at\": \"2021-07-01T00:00:00Z\",\r\n"
                    		+ "\"active\": true,\r\n"
                    		+ "\"coverages\": {\r\n"
                    		+ "\"Incêndio\": 500000.00,\r\n"
                    		+ "\"Desastres naturais\": 600000.00,\r\n"
                    		+ "\"Responsabiliadade civil\": 80000.00,\r\n"
                    		+ "\"Roubo\": 100000.00\r\n"
                    		+ "},\r\n"
                    		+ "\"assistances\": [\r\n"
                    		+ "\"Encanador\",\r\n"
                    		+ "\"Eletricista\",\r\n"
                    		+ "\"Chaveiro 24h\",\r\n"
                    		+ "\"Assistência Funerária\"\r\n"
                    		+ "],\r\n"
                    		+ "\"monthly_premium_amount\": {\r\n"
                    		+ "\"max_amount\": 100.74,\r\n"
                    		+ "\"min_amount\": 50.00,\r\n"
                    		+ "\"suggested_amount\": 60.25\r\n"
                    		+ "}\r\n"
                    		+ "}")
            );
        return mockServer;
    }
	
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
