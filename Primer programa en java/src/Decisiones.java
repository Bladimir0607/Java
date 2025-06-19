public class Decisiones {

    public static void main(String[] args) {
        int fechaDelanzamiento = 1999;
        boolean incluidoEnElplan = true;
        double notaDeLaPelicula = 8.2;
        String tipoPlan ="plus";

        // codigo que prueba los operadores relacionados
        if (fechaDelanzamiento >= 2022) {
            System.out.println("Pelicula más populares");
        } else {
            System.out.println("Pelicula Retro que aún vale la pena ver");
        }

        if (incluidoEnElplan && tipoPlan.equals("plus") ) {
            System.out.println("Disfrute de la pelicula");
        } else {
            System.out.println("Pelicula no disponible para su plan actual");
        }
    }
}
