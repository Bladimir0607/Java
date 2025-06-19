import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new  Scanner(System.in);
        ConsultaPelicula consulta = new ConsultaPelicula();
        System.out.println("Ingrese el numero de la pelicula de Star Wars que desea consultar:");
        try {
            var numeroDePelicula = Integer.valueOf(lectura.nextInt());
            Pelicula pelicula = consulta.buscarPelicula(4);
            System.out.println(pelicula);
            GeneradorDeArchivo generador = new GeneradorDeArchivo();
            generador.guardarJson(pelicula);
        }catch (NumberFormatException e){
            System.out.println("Número no encontrado" + e.getMessage());
        }
        catch (RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizado la aplicación");
        }

    }
}
