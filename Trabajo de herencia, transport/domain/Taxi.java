package domain;

public class Taxi extends TransportService {
    private float baseFare = 4500;
    private float ratePerKm = 1590;
    private float distance = 0;
    private float minimumFare = 8000;

    public Taxi(int newId, float newBaseFare, float newRatePerKm, float newDistance) {
        super(newId);
        setBaseFare(newBaseFare);
        setRatePerKm(newRatePerKm);
        setDistance(newDistance);
    }

    public Taxi(int newId, float newDistance) {
        super(newId);
        setDistance(newDistance);
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

    public float getRatePerKm() {
        return ratePerKm;
    }

    public void setRatePerKm(float newRatePerKm) {
        if (newRatePerKm < 0) {
            throw new IllegalArgumentException("Rate per km cannot be negative");
        }
        ratePerKm = newRatePerKm;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float newDistance) {
        if (newDistance < 0) {
            throw new IllegalArgumentException("Distance cannot be negative");
        }
        distance = newDistance;
    }

    public float getMinimumFare() {
        return minimumFare;
    }

    public void setMinimumFare(float newMinimumFare) {
        if (newMinimumFare < 0) {
            throw new IllegalArgumentException("Minimum fare cannot be negative");
        }
        minimumFare = newMinimumFare;
    }

    @Override
    public float calculateFare() {
        float fare = getBaseFare() + getRatePerKm() * getDistance();
        if (fare < getMinimumFare()) {
            return getMinimumFare();
        }
        return fare;
    }
}
