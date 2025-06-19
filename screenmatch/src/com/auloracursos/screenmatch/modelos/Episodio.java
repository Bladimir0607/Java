package com.auloracursos.screenmatch.modelos;

import com.auloracursos.screenmatch.calculos.Clasificacion;

public class Episodio implements Clasificacion {
    private int numero;
    private String nombre;
    private Serie serie;
    private int totalvisualizaciones;

    //Create the Setter and Getter

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public int getTotalvisualizaciones() {
        return totalvisualizaciones;
    }

    public void setTotalvisualizaciones(int totalvisualizaciones) {
        this.totalvisualizaciones = totalvisualizaciones;
    }

    @Override
    public int getClasificacion() {
        if (totalvisualizaciones > 100){
            return 4;
        }else {
            return 2;
        }
    }
}
