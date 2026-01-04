package fleet;

public class Bus extends Vehicle {
    private int passengerCapacity;

    public Bus(String model, int year, double basePrice, int passengerCapacity) {
        super(model, year, basePrice);
        setPassengerCapacity(passengerCapacity);
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        if (passengerCapacity <= 0) {
            throw new IllegalArgumentException("Invalid capacity");
        }
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public double calculateInsuranceFee() {
        int age = getAge(2026);
        return basePrice * 0.08 + passengerCapacity * 20 + age * 100;
    }

    @Override
    public void performService() {
        System.out.println("Bus ID " + id + " is undergoing full technical inspection");
    }

    @Override
    public int getServiceIntervalKm() {
        return 10000;
    }

    @Override
    public String toString() {
        return "Bus{" + super.toString() +
                ", Capacity=" + passengerCapacity +
                '}';
    }
}
