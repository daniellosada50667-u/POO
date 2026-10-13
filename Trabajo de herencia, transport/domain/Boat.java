package domain;

public class Boat extends Taxi {
    private float boardingFee = 5000;

    public Boat(int newId, float newBaseFare, float newRatePerKm, float newDistance, float newBoardingFee) {
        super(newId, newBaseFare, newRatePerKm, newDistance);
        setBoardingFee(newBoardingFee);
    }

    public Boat(int newId, float newDistance) {
        super(newId, 15000, 1500, newDistance);
    }

    public float getBoardingFee() {
        return boardingFee;
    }

    public void setBoardingFee(float newBoardingFee) {
        if (newBoardingFee < 0) {
            throw new IllegalArgumentException("Boarding fee cannot be negative");
        }
        boardingFee = newBoardingFee;
    }

    @Override
    public float calculateFare() {
        return getBaseFare() + getRatePerKm() * getDistance() + getBoardingFee();
    }
}
