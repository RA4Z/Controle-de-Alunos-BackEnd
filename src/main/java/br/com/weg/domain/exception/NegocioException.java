package br.com.weg.domain.exception;

public class NegocioException extends RuntimeException {

    public NegocioException(String message) {
        super(message);
    }
}
