package com.auloracursos.screenmatch.modelos;

import com.auloracursos.screenmatch.Excepcion.ErrorEnCoversionDeDuracionExption;



public class Titulo implements Comparable<Titulo>{
        private String nombre;
        private int fechaDeLanzamiento;
        private int duracion;
        private boolean incluidoEnElPlan;

        private double sumaDeLasEvaluaciones;

        private int totalDeLasEvaluaciones;


        public Titulo (String nombre, int fechaDeLanzamiento) {
            this.nombre = nombre;
            this.fechaDeLanzamiento = fechaDeLanzamiento;
        }

        public Titulo(TituloOmdb miTituloOmsb) {
            this.nombre = miTituloOmsb.Title();
            this.fechaDeLanzamiento = Integer.parseInt(miTituloOmsb.Year());
            if (miTituloOmsb.runtime().contains("N/A") || miTituloOmsb.runtime().contains("mins")){
                throw new ErrorEnCoversionDeDuracionExption("Duracion no disponible, " +
                        "porque contiene un N/A");
            }
            this.duracion = Integer.parseInt(
                    miTituloOmsb.runtime().substring(0,3).replace(" ", ""));
        }

    public Titulo(String nombre, int fechaDeLanzamiento, int duracion) {
    }


    //Getter
        public String getNombre() {
            return nombre;
        }

        public int getFechaDeLanzamiento() {
            return fechaDeLanzamiento;
        }

        public int getDuracion() {
            return duracion;
        }

        public boolean IncluidoEnElPlan() {
            return incluidoEnElPlan;
        }

        public double getSumaDeLasEvaluaciones() {
            return sumaDeLasEvaluaciones;
        }

        //setter
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setFechaDeLanzamiento(int fechaDeLanzamiento) {
            this.fechaDeLanzamiento = fechaDeLanzamiento;
        }

        public void setDuracion(int duracion) {
            this.duracion = duracion;
        }

        public void setIncluidoEnElPlan(boolean incluidoEnElPlan) {
            this.incluidoEnElPlan = incluidoEnElPlan;
        }

        public void setSumaDeLasEvaluaciones(double sumaDeLasEvaluaciones) {
            this.sumaDeLasEvaluaciones = sumaDeLasEvaluaciones;
        }

        public void setTotalDeLasEvaluaciones(int totalDeLasEvaluaciones) {
            this.totalDeLasEvaluaciones = totalDeLasEvaluaciones;
        }

        //ficha tecnica
        public void muestraFichaTecnica(){
            System.out.println("\nEL nombre de la pelicula es: "+ getNombre());
            System.out.println("Su fecha de lanzamiento es: "+ getFechaDeLanzamiento());
            System.out.println("Duracion en minutos es: "+ getDuracion());
        }

    //Class public
    public  int getTotalDeLasEvaluaciones(){
        return totalDeLasEvaluaciones;
    }

    public void evalua(double nota) {
        sumaDeLasEvaluaciones += nota;
        totalDeLasEvaluaciones++;
    }

    public   double calculaMedia() {
        return sumaDeLasEvaluaciones / totalDeLasEvaluaciones;
    }

    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombre().compareTo(otroTitulo.getNombre());
    }

    @Override
    public String toString() {
        return "(nombre=" + nombre +
                ",fechaDeLanzamiento= " + fechaDeLanzamiento +
                ", duracionEnMinuto= " + duracion+")";
    }
}