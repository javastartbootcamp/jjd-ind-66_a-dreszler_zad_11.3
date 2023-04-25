package pl.javastart.task;

abstract class OverclockableComponent extends Component {
    protected int clockRate;
    protected double temperature;
    protected double safeTemp;

    OverclockableComponent(String model, String producer, String serialNumber, int clockRate, double temperature, double safeTemp) {
        super(model, producer, serialNumber);
        checkIfClockRateIsPositive(clockRate);
        initializeTemperatures(temperature, safeTemp);
        this.clockRate = clockRate;
    }

    public void overclock() {
        System.out.println("Podkręcam komponent " + getProducer() + " " + getModel());
        setTemperature(temperature + getTempIncrease());
        setClockRate(clockRate + getOverclockIncrement());
    }

    protected double getTempIncrease() {
        return 0;
    }

    protected int getOverclockIncrement() {
        return 0;
    }

    private void setClockRate(int clockRate) {
        checkIfClockRateIsPositive(clockRate);
        this.clockRate = clockRate;
    }

    private void setTemperature(double temperature) {
        checkIfTempIsPositive(temperature);
        checkIfTempIsLowerThanSafeTemp(temperature, safeTemp);
        this.temperature = temperature;
    }

    private void initializeTemperatures(double baseTemp, double safeTemp) {
        checkIfTempIsPositive(baseTemp);
        checkIfTempIsPositive(safeTemp);
        checkIfTempIsLowerThanSafeTemp(baseTemp, safeTemp);
        this.temperature = baseTemp;
        this.safeTemp = safeTemp;
    }

    protected void checkIfClockRateIsPositive(double clockRate) {
        if (clockRate < 0) {
            throw new IllegalArgumentException("Taktowanie komponentu nie może być ujemne!");
        }
    }

    protected void checkIfTempIsLowerThanSafeTemp(double temperature, double safeTemp) {
        if (temperature > safeTemp) {
            throw new IllegalArgumentException("Temperatura komponentu nie może przekraczać bezpiecznej temperatury!");
        }
    }

    protected void checkIfTempIsPositive(double temperature) {
        if (temperature < 0) {
            throw new IllegalArgumentException("Temperatura komponentu nie może być ujemna!");
        }
    }
}
