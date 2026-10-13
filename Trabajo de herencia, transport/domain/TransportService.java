package domain;

public abstract class TransportService {
    private int id;

    public TransportService(int newId) {
        setId(newId);
    }

    public abstract float calculateFare();

    public int getId() {
        return id;
    }

    public void setId(int newId) {
        if (newId <= 0) {
            throw new IllegalArgumentException("ID must be greater than 0");
        }
        id = newId;
    }
}
