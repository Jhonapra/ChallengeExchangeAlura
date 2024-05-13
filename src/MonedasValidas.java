import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;

public class MonedasValidas {
    public void imprimirTipoDeMonedasValidas() throws IOException, InterruptedException {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/934f83935e81e35e8d3cbe45/codes");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                ====================================================================
                Bienvenido al challenge de conversion de monedas.
                
                Las monedas mas usadas para convertir son:
                -USD a COP.
                -COP a USD.
                -COP a EUR.
                Recuerde siempre escribir las monedas en mayusculas.
                --------------------------------------------------------------------
                Desea saber cuales son todos los tipos de cambio diponibles?,
                si la respuesta es si escriba el numero 1, de lo contrario digite 0.
                ====================================================================
                
                """);
        Gson gson = new Gson();
        ArrayCodes arrayCodes= gson.fromJson(json, ArrayCodes.class);
        ArrayList mirarArray = arrayCodes.getSupported_codes();
        Gson gsonConversor = new GsonBuilder().setPrettyPrinting().create();
        String jsonBonito = gsonConversor.toJson(mirarArray);
        int respuesta = scanner.nextInt();
        if (respuesta==1){
            System.out.println(jsonBonito);
        }else {
            System.out.println("Recuerde escribir todo en mayuscula, suerte");
        }
    }
}
