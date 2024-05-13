import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Scanner;

public class TomarInformacion {
    public void tomaDeLaInformacion(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cual es tu tipo de moneda?");
        String miMoneda = scanner.next();
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/934f83935e81e35e8d3cbe45/latest/" +miMoneda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            String json=response.body();
            Arrays arrays = gson.fromJson(json, Arrays.class);
            HashMap ObtenerConversion =arrays.getConversion_rates();

            System.out.println("Escribe el tipo de moneda al que deseas convertir la tuya");
            String monedaDeCambio = scanner.next();
            System.out.println("Escribe la cantidad de dinero que tienes para convertir");
            double cantidadDeDinero = scanner.nextDouble();
            double cantidadDeCambio = (double) ObtenerConversion.get(monedaDeCambio);
            double conversor = cantidadDeCambio*cantidadDeDinero;
            int valorEntero = (int)conversor;
            System.out.println("La cantidad convertida es: "+valorEntero+" "+monedaDeCambio);
            System.out.println("Espero que el programa haya funcionado satisfactoriamente, regrese cuando lo desee");



        } catch (Exception e) {
            throw new RuntimeException("Surgio un error.");
        }

    }
}
