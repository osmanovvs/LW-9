import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Payment {
    public Car car;
    private double hourlyRate;
    private LocalDateTime paymentDate;

    public Payment(Car car, double hourlyRate, LocalDateTime paymentDate) {
        this.car = car;
        this.hourlyRate = hourlyRate;
        this.paymentDate = paymentDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double calculatePayment() {
        LocalDateTime exitTime = car.getExitTime();
        if (exitTime == null) {
            exitTime = LocalDateTime.now();
        }
        LocalDateTime entryTime = car.getEntryTime();
        long hours = ChronoUnit.HOURS.between(entryTime, exitTime);
        if (hours < 1) {
            hours = 1;
        }
        double payment = hourlyRate * hours;
        return payment;
    }
}
