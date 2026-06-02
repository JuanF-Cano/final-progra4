package servicios;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DogApiService {

    public void obtenerRazas() {

        try {

            HttpClient cliente =
                    HttpClient.newHttpClient();

            HttpRequest solicitud =
                    HttpRequest.newBuilder()
                            .uri(
                                    URI.create(
                                            "https://dog.ceo/api/breeds/list/all"
                                    )
                            )
                            .build();

            HttpResponse<String> respuesta =
                    cliente.send(
                            solicitud,
                            HttpResponse.BodyHandlers.ofString()
                    );

            System.out.println(respuesta.body());

        } catch (IOException | InterruptedException e) {

            System.out.println("Error al consumir API");

            System.out.println(e.getMessage());
        }
    }

    public void buscarRaza(String raza) {

        try {

            HttpClient cliente =
                    HttpClient.newHttpClient();

            HttpRequest solicitud =
                    HttpRequest.newBuilder()
                            .uri(
                                    URI.create(
                                            "https://dog.ceo/api/breeds/list/all"
                                    )
                            )
                            .build();

            HttpResponse<String> respuesta =
                    cliente.send(
                            solicitud,
                            HttpResponse.BodyHandlers.ofString()
                    );

            String json = respuesta.body();

            if (json.toLowerCase().contains(raza.toLowerCase())) {

                System.out.println("\nRaza encontrada:");
                System.out.println(raza);

            } else {

                System.out.println("\nLa raza no existe.");

            }

        } catch (IOException | InterruptedException e) {

            System.out.println("Error al consultar raza");

            System.out.println(e.getMessage());
        }
    }
}