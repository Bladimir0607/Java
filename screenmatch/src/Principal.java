import com.auloracursos.screenmatch.calculos.CalculadoraDeTiempo;
import com.auloracursos.screenmatch.calculos.FiltroRecomendacion;
import com.auloracursos.screenmatch.modelos.Episodio;
import com.auloracursos.screenmatch.modelos.Pelicula;
import com.auloracursos.screenmatch.modelos.Serie;
import com.auloracursos.screenmatch.modelos.Titulo;

import java.util.ArrayList;

public class Principal extends Titulo {

    public Principal(String nombre, int fechaDeLanzamiento, int duracion) {
        super(nombre, fechaDeLanzamiento, duracion);
    }

    public static void main(String[] args) {
            Pelicula miPelicula = new Pelicula("Rapidos y Furiosos", 2001);
            miPelicula.setDuracion(146);
            miPelicula.setIncluidoEnElPlan(true);

            miPelicula.muestraFichaTecnica();
            miPelicula.evalua(10);
            miPelicula.evalua(10);
            miPelicula.evalua(7.8);

            System.out.println(miPelicula.getTotalDeLasEvaluaciones());
            System.out.println(miPelicula.calculaMedia());


            Serie adnDelDelito = new Serie("El ADN del delito", 2023);
            adnDelDelito.setTemporadas(1);
            adnDelDelito.setMinutosPorEpisodio(49);
            adnDelDelito.setEpisodioPorTemporada(8);
            adnDelDelito.muestraFichaTecnica();

            adnDelDelito.evalua(6.5);
            adnDelDelito.evalua(7.0);
            adnDelDelito.evalua(10.0);
            System.out.println(adnDelDelito.getTotalDeLasEvaluaciones());
            System.out.println(adnDelDelito.calculaMedia());

            Pelicula otraPelicula = new Pelicula("Matrix", 1999);
            otraPelicula.setDuracion(138);
            otraPelicula.evalua(10);
            otraPelicula.evalua(10);
            otraPelicula.evalua(10);
            System.out.println(otraPelicula.getTotalDeLasEvaluaciones());
            System.out.println(otraPelicula.calculaMedia());


            CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
            calculadora.incluye(miPelicula);
            calculadora.incluye(adnDelDelito);
            calculadora.incluye(otraPelicula);
            System.out.println("\nTiempo necesario para ver tus titulos favoritos estas vacaciones son:"
                    + calculadora.getTiempoTotal() +  " Minutos ");

            //create the new filtroRecomendacion and others
            FiltroRecomendacion filtroRecomendacion = new FiltroRecomendacion();
            filtroRecomendacion.Filtra(miPelicula);

            Episodio episodio =  new Episodio();
            episodio.setNumero(1);
            episodio.setNombre("Batalla campal");
            episodio.setSerie(adnDelDelito);
            episodio.setTotalvisualizaciones(50);
            filtroRecomendacion.Filtra(episodio);

            var peliculaDeBladimir = new Pelicula("Transformers", 2007);
            peliculaDeBladimir.setDuracion(224);


            ArrayList<Pelicula> listaDePelicula = new ArrayList<>();
            listaDePelicula.add(peliculaDeBladimir);
            listaDePelicula.add(miPelicula);
            listaDePelicula.add(otraPelicula);

            System.out.println("Tamaño de la lista : " + listaDePelicula.size());
            System.out.println("La primera pelicula es : " + listaDePelicula.get(0).getNombre());
            System.out.println(listaDePelicula.toString());
            System.out.println("toString de la pelicula: "  + listaDePelicula.get(0).toString());



        }

}
