package br.com.zupacademy.wallyson.casadocodigo.exceptionhandler;

public class ExceptionHandlerResponse {

    private final String field;
    private final String message;

    public ExceptionHandlerResponse(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }

}
