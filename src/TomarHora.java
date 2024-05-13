import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TomarHora {

    public String determinarHora(){
        LocalTime ahora = LocalTime.now();
        String horaFormateada = ahora.format(DateTimeFormatter.ofPattern("HH:mm"));
        return horaFormateada;
    }
    public LocalDate determinarFecha(){
        LocalDate hoy = LocalDate.now();
        return hoy;
    }

}
