package br.com.zupacademy.wallyson.casadocodigo.exceptionhandler;

public class BadRequestDto {

    private final String campo;
    private final String mensagem;

    public BadRequestDto(String field, String message) {
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
