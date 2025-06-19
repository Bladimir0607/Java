package com.auloracursos.screenmatch.principal;

import com.auloracursos.screenmatch.Excepcion.ErrorEnCoversionDeDuracionExption;
import com.auloracursos.screenmatch.modelos.Titulo;
import com.auloracursos.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;


import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalDeBusqueda {
    public static void main(String[] args) throws IOException {
        Scanner lectura = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (true){
            System.out.println("Ingrese el nombre de la pelicula que desea buscar: ");
            var busqueda = lectura.nextLine();
            HttpResponse<String> response = null;

            if (busqueda.equalsIgnoreCase("Salir")){
                break;
            }

            try {
                // Codificar el término de búsqueda para manejar espacios y caracteres especiales
                String busquedaCodificada = URLEncoder.encode(busqueda, StandardCharsets.UTF_8);

                String direccion = "https://www.omdbapi.com/?t=" +
                        busquedaCodificada.replace(" ", "+") +
                        "&apikey=6672050d";


                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();

                response = client.send(request, HttpResponse.BodyHandlers.ofString());

                if (response.statusCode() == 200) {
                    String cuerpo = response.body();
                    if (cuerpo.contains("\"Response\":\"False\"")) {
                        System.out.println("No se encontró la película: " + busqueda);
                    } else {
                        String json = response.body();
                        System.out.println(json);

                        TituloOmdb miTituloOmsb = gson.fromJson(json, TituloOmdb.class);
                        System.out.println(miTituloOmsb);
                        Titulo miTitulo = new Titulo(miTituloOmsb);
                        System.out.println("Titulo ya convertido: " + miTitulo);
                        titulos.add(miTitulo);
                    }
                    System.out.println("Finalizo la ejecucicón del programa");

                } else {
                    System.out.println("Error en la búsqueda: código de estado " + response.statusCode());
                }

            } catch (IOException e) {
                System.out.println("Error de conexión: " + e.getMessage());
            } catch (InterruptedException e) {
                System.out.println("Error durante la búsqueda: " + e.getMessage());
            }
            catch (JsonSyntaxException e){
                System.out.println(e.getMessage());
            }
            catch (ErrorEnCoversionDeDuracionExption e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
            System.out.println(titulos);
            FileWriter escritura = new FileWriter("titulos.json");
            escritura.write(gson.toJson(titulos));
            escritura.close();
            System.out.println("Finalizo la ejecuciión del programa!!");
        }

    }
}