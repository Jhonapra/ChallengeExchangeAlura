public class CreacionDelTexto {
    public String añadirInformacion(String moneda, String tipoDeMonedaDeCambio,
                                    int cantidadConvertida, String hora, String fecha, int cantidadaConvertir){
        String texto = String.format("""
                Se realizo una transaccion el dia %s a la hora %s, el tipo de cambio fue 
                %s a %s, se convirtio la cantidad de %d %s a %d %s.
                ---------------------------------------------------------------------------------------------------- 
                """, fecha, hora, moneda, tipoDeMonedaDeCambio, cantidadaConvertir, moneda, cantidadConvertida, tipoDeMonedaDeCambio);
        return texto;
    }
}
