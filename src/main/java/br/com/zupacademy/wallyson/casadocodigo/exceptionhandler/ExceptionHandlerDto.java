package br.com.zupacademy.wallyson.casadocodigo.exceptionhandler;

public class ExceptionHandlerDto {

    private final String campo;
    private final String mensagem;

    public ExceptionHandlerDto(String field, String message) {
        this.campo = field;
        this.mensagem = message;
    }

    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return mensagem;
    }

}
