package com.auloracursos.screenmatch.modelos;

public class Serie extends Titulo{
    int temporadas;
    int episodioPorTemporada;
    int minutosPorEpisodio;

    public Serie (String nombre, int fechaDeLanzamiento) {
        super(nombre, fechaDeLanzamiento);
    }

    // Getter and Setter


    @Override
    public int getDuracion() {
        return temporadas * episodioPorTemporada * minutosPorEpisodio;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getEpisodioPorTemporada() {
        return episodioPorTemporada;
    }

    public void setEpisodioPorTemporada(int episodioPorTemporada) {
        this.episodioPorTemporada = episodioPorTemporada;
    }

    public int getMinutosEpisodio() {
        return minutosPorEpisodio;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    @Override
    public String toString() {
        return "Serie: " + this.getNombre() + " (" + getFechaDeLanzamiento() + ")";
}


}

