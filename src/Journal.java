import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Journal {
    private final List<Entry> entries;

    public Journal() {
        this.entries = new ArrayList<>();
    }

    public void addEntry(Car car, LocalDateTime entryTime) {
        entries.add(new Entry(car, entryTime));
    }

    public void updateEntry(Car car, LocalDateTime exitTime) {
        for (Entry entry : entries) {
            if (entry.getCar().equals(car) && entry.getExitTime() == null) {
                entry.setExitTime(exitTime);
                break;
            }
        }
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public List<Record> getRecords() {
        return null;
    }

    public void addRecord(Car carToExit, CarState parked, LocalDateTime now) {
    }

    public static class Entry {
        private Car car;
        private LocalDateTime entryTime;
        private LocalDateTime exitTime;

        public Entry(Car car, LocalDateTime entryTime) {
            this.car = car;
            this.entryTime = entryTime;
        }

        public Car getCar() {
            return car;
        }

        public LocalDateTime getEntryTime() {
            return entryTime;
        }

        public LocalDateTime getExitTime() {
            return exitTime;
        }

        public void setExitTime(LocalDateTime exitTime) {
            this.exitTime = exitTime;
        }
    }
}
