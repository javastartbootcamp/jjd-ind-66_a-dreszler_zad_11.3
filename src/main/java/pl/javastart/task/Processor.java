package pl.javastart.task;

class Processor extends Component implements Overclockable {
    protected int clockRate;
    protected double temperature;
    protected double safeTemp;
    protected static final int OVERCLOCK_INCREMENT = 100;
    private static final int OVERCLOCK_CPU_TEMP_INCREMENT = 10;

    @Override
    public void overclock() {
        System.out.println("Podkręcam procesor...");
        setTemperature(temperature + OVERCLOCK_CPU_TEMP_INCREMENT);
        setClockRate(clockRate + OVERCLOCK_INCREMENT);
    }

    public Processor(String model, String producer, String serialNumber, int clockRate, double baseTemp,
                     double safeTemp) {
        super(model, producer, serialNumber);
        setClockRate(clockRate);
        initializeTemperatures(baseTemp, safeTemp);
    }

    public void setClockRate(int clockRate) {
        checkIfClockRateIsPositive(clockRate);
        this.clockRate = clockRate;
    }

    private void initializeTemperatures(double baseTemp, double safeTemp) {
        checkIfTempIsPositive(baseTemp);
        checkIfTempIsPositive(safeTemp);
        checkIfTempIsLowerThanSafeTemp(baseTemp, safeTemp);
        this.temperature = baseTemp;
        this.safeTemp = safeTemp;
    }

    public void setTemperature(double temperature) {
        checkIfTempIsPositive(temperature);
        checkIfTempIsLowerThanSafeTemp(temperature, safeTemp);
        this.temperature = temperature;
    }

    public void setSafeTemp(double safeTemp) {
        checkIfTempIsPositive(safeTemp);
        checkIfTempIsLowerThanSafeTemp(temperature, safeTemp);
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

    @Override
    protected String getDeviceSpecs() {
        return "\nTaktowanie CPU: " + clockRate + " MHz\nTemperatura CPU: " + temperature + " C\nTemperatura bezpieczna: " +
                safeTemp + " C";
    }
}
