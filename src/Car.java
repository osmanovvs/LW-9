import java.time.LocalDateTime;

public class Car {
    private final String regNumber;
    private CarState currentState;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;

    public Car(String regNumber, CarState currentState, LocalDateTime entryTime, LocalDateTime exitTime) {
        this.regNumber = regNumber;
        this.currentState = currentState;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public CarState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(CarState state) {
        currentState = state;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }
}
