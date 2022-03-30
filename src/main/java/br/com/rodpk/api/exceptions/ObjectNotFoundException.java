package br.com.rodpk.api.exceptions;

public class ObjectNotFoundException extends RuntimeException {
    
    public ObjectNotFoundException(String msg) {
        super(msg);
    }
}
