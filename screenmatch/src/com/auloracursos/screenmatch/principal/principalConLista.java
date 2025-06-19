package com.auloracursos.screenmatch.principal;

import com.auloracursos.screenmatch.modelos.Pelicula;
import com.auloracursos.screenmatch.modelos.Serie;
import com.auloracursos.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class principalConLista {
    public static void main(String[] args){

        Pelicula miPelicula = new Pelicula("Rapidos y Furiosos", 2001);
        miPelicula.evalua(10);
        Pelicula otraPelicula = new Pelicula("Matrix", 1999);
        otraPelicula.evalua(10);
        var peliculaDeBladimir = new Pelicula("Transformers", 2007);
        peliculaDeBladimir.evalua(10);
        Serie adnDelDelito = new Serie("El ADN del delito", 2023);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(adnDelDelito);
        lista.add(peliculaDeBladimir);

        for (Titulo item: lista){
            System.out.println(item.getNombre());
            if (item instanceof Pelicula pelicula && pelicula.getClasificacion() > 3){
                System.out.println(pelicula.getClasificacion());
            }

        }

        ArrayList<String> listaDeArtistas = new ArrayList<>();
        listaDeArtistas.add("Anuel AA");
        listaDeArtistas.add("Bryant Myers");
        listaDeArtistas.add("Arcángel");
        System.out.println(listaDeArtistas);

        Collections.sort(listaDeArtistas);
        System.out.println("Lista de artistas ordenada: " + listaDeArtistas);

        Collections.sort(lista);
        System.out.println("Lista de Titulos ordenados: " + lista);

        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println("Lista ordenada por fecha : " + lista);

    }
}
