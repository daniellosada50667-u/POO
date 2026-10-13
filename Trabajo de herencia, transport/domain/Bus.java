package domain;

public class Bus extends TransportService {
    private float farePerPassenger = 3000;
    private int passengers = 0;

    public Bus(int newId, float newFarePerPassenger, int newPassengers) {
        super(newId);
        setFarePerPassenger(newFarePerPassenger);
        setPassengers(newPassengers);
    }

    public Bus(int newId, int newPassengers) {
        super(newId);
        setPassengers(newPassengers);
    }

    public float getFarePerPassenger() {
        return farePerPassenger;
    }

    public void setFarePerPassenger(float newFarePerPassenger) {
        if (newFarePerPassenger < 0) {
            throw new IllegalArgumentException("Fare per passenger cannot be negative");
        }
        farePerPassenger = newFarePerPassenger;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int newPassengers) {
        if (newPassengers <= 0) {
            throw new IllegalArgumentException("Passengers must be greater than 0");
        }
        passengers = newPassengers;
    }

    @Override
    public float calculateFare() {
        return getFarePerPassenger() * getPassengers();
    }
}
