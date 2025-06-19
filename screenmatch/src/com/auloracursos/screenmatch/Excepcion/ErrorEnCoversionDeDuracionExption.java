package com.auloracursos.screenmatch.Excepcion;

public class ErrorEnCoversionDeDuracionExption extends RuntimeException {
    private String mensaje;

    public ErrorEnCoversionDeDuracionExption(String mensaje ) {
        this.mensaje = mensaje;
    }
    @Override
    public String getMessage() {
        return mensaje;
    }
}
