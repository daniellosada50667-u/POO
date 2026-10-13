package domain;

public class Airplane extends TransportService {
    private float baseFare = 180000;
    private float ratePerKg = 3000;
    private float luggageWeight = 0;

    public Airplane(int newId, float newBaseFare, float newRatePerKg, float newLuggageWeight) {
        super(newId);
        setBaseFare(newBaseFare);
        setRatePerKg(newRatePerKg);
        setLuggageWeight(newLuggageWeight);
    }

    public Airplane(int newId, float newLuggageWeight) {
        super(newId);
        setLuggageWeight(newLuggageWeight);
    }

    public float getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(float newBaseFare) {
        if (newBaseFare < 0) {
            throw new IllegalArgumentException("Base fare cannot be negative");
        }
        baseFare = newBaseFare;
    }

    public float getRatePerKg() {
        return ratePerKg;
    }

    public void setRatePerKg(float newRatePerKg) {
        if (newRatePerKg < 0) {
            throw new IllegalArgumentException("Rate per kg cannot be negative");
        }
        ratePerKg = newRatePerKg;
    }

    public float getLuggageWeight() {
        return luggageWeight;
    }

    public void setLuggageWeight(float newLuggageWeight) {
        if (newLuggageWeight < 0) {
            throw new IllegalArgumentException("Luggage weight cannot be negative");
        }
        luggageWeight = newLuggageWeight;
    }

    @Override
    public float calculateFare() {
        return getBaseFare() + getRatePerKg() * getLuggageWeight();
    }
}
