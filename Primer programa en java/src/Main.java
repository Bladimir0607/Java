public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido(a) a Screen Match");
        System.out.println("Pelicula: Matrix");

        int fechaDelanzamiento = 1999;
        boolean incluidoEnElplan = true;
        double notaDeLaPelicula = 8.2;

        double media = (8.2 + 6.0 + 9.0)/ 3;
        System.out.println(media);


        String sinopsis = "Matrix es una paradoja\n"
                + "La mejor pelicula del fin del milenio\n"
                + "Fue lanzada en: " + fechaDelanzamiento;
        System.out.println(sinopsis);

        int clasificacion = (int) (media / 2);
        System.out.println(clasificacion);

    }
}

