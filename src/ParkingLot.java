import java.time.LocalDateTime;
import java.util.ArrayList;

public class ParkingLot {
    private final int capacity;
    private int occupiedSpaces;
    private final ArrayList<Car> parkedCars;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.occupiedSpaces = 0;
        this.parkedCars = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getOccupiedSpaces() {
        return occupiedSpaces;
    }

    public int getFreeSpaces() {
        return capacity - occupiedSpaces;
    }

    public ArrayList<Car> getParkedCars() {
        return parkedCars;
    }

    public boolean addCar(Car car) {
        if (occupiedSpaces < capacity) {
            car.setCurrentState(CarState.PARKED);
            car.setEntryTime(LocalDateTime.now());
            parkedCars.add(car);
            occupiedSpaces++;
            return true;
        } else {
            return false;
        }
    }

    public boolean removeCar(Car car) {
        boolean removed = parkedCars.remove(car);
        if (removed) {
            car.setCurrentState(CarState.MOVING);
            car.setExitTime(LocalDateTime.now());
            occupiedSpaces--;
        }
        return removed;
    }
}
