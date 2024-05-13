import java.io.IOException;

public class Main {
    public static void main(String[] args) {
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
        //Prueba de que se puede hacer pull
    }
}
