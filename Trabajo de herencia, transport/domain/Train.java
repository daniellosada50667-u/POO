package domain;

public class Train extends TransportService {
    private float ratePerKm = 500;
    private float distance = 0;
    private float fixedCharge = 10000;

    public Train(int newId, float newRatePerKm, float newDistance, float newFixedCharge) {
        super(newId);
        setRatePerKm(newRatePerKm);
        setDistance(newDistance);
        setFixedCharge(newFixedCharge);
    }

    public Train(int newId, float newDistance) {
        super(newId);
        setDistance(newDistance);
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

    public float getFixedCharge() {
        return fixedCharge;
    }

    public void setFixedCharge(float newFixedCharge) {
        if (newFixedCharge < 0) {
            throw new IllegalArgumentException("Fixed charge cannot be negative");
        }
        fixedCharge = newFixedCharge;
    }

    @Override
    public float calculateFare() {
        return getRatePerKm() * getDistance() + getFixedCharge();
    }
}
