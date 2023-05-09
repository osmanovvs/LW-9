import java.time.LocalDateTime;

public class Record {
    public final LocalDateTime entryTime;
    private final LocalDateTime exitTime;
    private final String regNumber;
    private final double paymentAmount;

    public Record(LocalDateTime entryTime, LocalDateTime exitTime, String regNumber, double paymentAmount) {
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.regNumber = regNumber;
        this.paymentAmount = paymentAmount;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }
}
