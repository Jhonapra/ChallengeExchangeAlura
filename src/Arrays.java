import java.util.HashMap;

public class Arrays {
    private HashMap conversion_rates;

    public HashMap getConversion_rates() {
        return conversion_rates;
    }

    public void setConversion_rates(HashMap conversion_rates) {
        this.conversion_rates = conversion_rates;
    }

    @Override
    public String toString() {
        return "conversion_rates=" + conversion_rates;
    }
}
