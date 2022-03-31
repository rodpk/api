package br.com.rodpk.api.exceptions;

public class DataIntegrityViolationException extends RuntimeException {
    
    public DataIntegrityViolationException(String msg) {
        super(msg);
    }
}
