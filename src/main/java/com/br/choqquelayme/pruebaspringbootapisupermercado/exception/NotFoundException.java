package com.br.choqquelayme.pruebaspringbootapisupermercado.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String msje) {
        super(msje);
    }
}
