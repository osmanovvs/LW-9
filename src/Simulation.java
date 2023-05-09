import java.time.LocalDateTime;
import java.util.Random;

public class Simulation {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(20);
        Journal journal = new Journal();
        Random random = new Random();

        Car[] cars = new Car[200];
        for (int i = 0; i < 200; i++) {
            String regNumber = String.format("%03d", i);
            CarState state = random.nextBoolean() ? CarState.MOVING : CarState.PARKED;
            LocalDateTime enterTime = LocalDateTime.now().minusHours(random.nextInt(24));
            LocalDateTime exitTime = state == CarState.PARKED ? null : enterTime.plusHours(random.nextInt(24));
            cars[i] = new Car(regNumber, state, enterTime, exitTime);
            if (state == CarState.PARKED) {
                parkingLot.addCar(cars[i]);
                journal.addRecord(cars[i], CarState.PARKED, enterTime);
            }
        }

        for (int i = 0; i < 10; i++) {
            int carIndex = random.nextInt(200);
            Car car = cars[carIndex];
            if (car. getCurrentState() == CarState.PARKED) {
                parkingLot.removeCar(car);
                journal.addRecord(car, CarState.MOVING, LocalDateTime.now());
                Payment payment = new Payment(car, random.nextDouble() * 50.0, LocalDateTime.now());
                System.out.println("Машина " + car.getRegNumber() + " покинула парковку. Оплаченная сумма: " + payment.getPaymentDate());
            } else {
                parkingLot.addCar(car);
                journal.addRecord(car, CarState.PARKED, LocalDateTime.now());
                System.out.println("Машина " + car.getRegNumber() + " припарковалась на парковке.");
            }
        }

        System.out.println("Загруженность парковки: " + parkingLot.getOccupiedSpaces() + "/" + parkingLot.getCapacity());

        System.out.println("Записи в журнале: " + journal.getRecords());
    }
}
