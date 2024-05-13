import java.io.FileWriter;
import java.io.IOException;

public class Main {
    //Prueba pull despues de cambiar la rama default
    public static void main(String[] args) throws IOException {
        MonedasValidas monedasValidas= new MonedasValidas();
        try {
            monedasValidas.imprimirTipoDeMonedasValidas();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        TomarInformacion tomarInformacion = new TomarInformacion();
        tomarInformacion.tomaDeLaInformacion();

        String moneda = tomarInformacion.getMoneda();
        String tipoDeMonedaDeCambio = tomarInformacion.getTipoDeMonedaDeCambio();
        int cantidadConvertida = tomarInformacion.getCantidadConvertida();
        int cantidadAconvertir = tomarInformacion.getCantidadAconvertir();

        TomarHora tomarHora = new TomarHora();
        String hora = tomarHora.determinarHora();
        String fecha = tomarHora.determinarFecha().toString();

        CreacionDelTexto creacionDelTexto =new CreacionDelTexto();

        FileWriter escritura = new FileWriter("descripcion.txt", true);
        escritura.write(creacionDelTexto.añadirInformacion(moneda, tipoDeMonedaDeCambio,
                        cantidadConvertida, hora, fecha, cantidadAconvertir));
        escritura.close();
    }
}
