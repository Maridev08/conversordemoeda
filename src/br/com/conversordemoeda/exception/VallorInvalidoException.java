package br.com.conversordemoeda.exception;

public class VallorInvalidoException extends RuntimeException {
   private String mensagem;


    public VallorInvalidoException(String mensagem) {
        super(mensagem);
    }


}
