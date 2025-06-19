package com.auloracursos.screenmatch.calculos;

public class FiltroRecomendacion {

   public void Filtra(Clasificacion clasificacion){
        if (clasificacion.getClasificacion() >= 4 ) {
            System.out.println("Muy popular en este momento");
        }else if (clasificacion.getClasificacion() >= 2){
            System.out.println("Es popular en este momento");
        }else{
            System.out.println("Colocalo en tu lista para verlo después");
        }
    }
}
