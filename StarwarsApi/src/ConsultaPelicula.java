import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaPelicula {
    public Pelicula buscarPelicula(int numeroDePelicula) {
        URI direccion = URI.create("https://swapi.py4e.com/api/films/" + numeroDePelicula);

        // Crear un cliente que siga redirecciones automáticamente
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new RuntimeException("No se pudo encontrar esa pellicula");
        }
        // Comprueba si la respuesta es exitosa
        if (response.statusCode() != 200) {
            throw new RuntimeException("Error en la solicitud: " + response.statusCode() + " - " + response.body());
        }
        // Imprime la respuesta para depuración
        System.out.println("Respuesta del servidor: " + response.body());

        // Mapear la respuesta a Pelicula si el formato es válido
        return new Gson().fromJson(response.body(), Pelicula.class);
    }
}