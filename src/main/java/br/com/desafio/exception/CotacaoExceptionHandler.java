package br.com.desafio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CotacaoExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CotacaoException.class)
	public ResponseEntity<?> cotacaoExceptionHandle(CotacaoException ex, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse("Erro no serviço de cotação", ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}

class ErrorResponse {
	private String erro;
	private String mensagem;

	public ErrorResponse(String erro, String mensagem) {
		this.erro = erro;
		this.mensagem = mensagem;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
