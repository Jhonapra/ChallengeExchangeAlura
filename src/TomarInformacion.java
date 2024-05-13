import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Scanner;

public class TomarInformacion {
    private String moneda;
    private String tipoDeMonedaDeCambio;
    private int cantidadConvertida;
    private int cantidadAconvertir;

    public int getCantidadAconvertir() {
        return cantidadAconvertir;
    }

    public String getMoneda() {
        return moneda;
    }

    public String getTipoDeMonedaDeCambio() {
        return tipoDeMonedaDeCambio;
    }

    public int getCantidadConvertida() {
        return cantidadConvertida;
    }

    public void tomaDeLaInformacion() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cual es tu tipo de moneda?");
        String miMoneda = scanner.next();
        moneda = miMoneda;
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
            tipoDeMonedaDeCambio = monedaDeCambio;
            System.out.println("Escribe la cantidad de dinero que tienes para convertir");
            double cantidadDeDinero = scanner.nextDouble();
            cantidadAconvertir = (int)cantidadDeDinero;
            double cantidadDeCambio = (double) ObtenerConversion.get(monedaDeCambio);
            double conversor = cantidadDeCambio*cantidadDeDinero;
            int valorEntero = (int)conversor;
            cantidadConvertida = valorEntero;
            System.out.println("La cantidad convertida es: "+valorEntero+" "+monedaDeCambio);
            System.out.println("Gracias por utilizar el programa, feliz dia.");



        } catch (Exception e) {
            System.out.println("Surgio un error, recuerda leer bien y seguir las instrucciones, reinicia el programa e intentalo de nuevo.");
            FileWriter fileWriter = new FileWriter("descripcion.txt", true);
            fileWriter.write("**Transaccion no valida**...");
            fileWriter.close();

        }

    }
}
