package com.auloracursos.screenmatch.calculos;
import com.auloracursos.screenmatch.modelos.Titulo;

public class CalculadoraDeTiempo {
    private int tiempoTotal;

    //Create the Getter


    public int getTiempoTotal() {
        return tiempoTotal;
    }

    //Create the void
    public void incluye(Titulo titulo) {
        //Polimorfismo
        this.tiempoTotal += titulo.getDuracion();
        System.out.println("Agregando duración en minutos de " + titulo);
    }
}
