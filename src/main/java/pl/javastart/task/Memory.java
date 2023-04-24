package pl.javastart.task;

class Memory extends Processor implements Overclockable {
    private int size;
    private static final int OVERCLOCK_RAM_TEMP_INCREMENT = 15;

    @Override
    public void overclock() {
        System.out.println("Podkręcam pamięć RAM...");
        setTemperature(temperature + OVERCLOCK_RAM_TEMP_INCREMENT);
        setClockRate(clockRate + OVERCLOCK_INCREMENT);
    }

    public Memory(String model, String producer, String serialNumber, int clockRate, double baseTemp, double safeTemp,
                  int size) {
        super(model, producer, serialNumber, clockRate, baseTemp, safeTemp);
        setSize(size);
    }

    public void setSize(int size) {
        checkIfSizeIsPositive(size);
        this.size = size;
    }

    private void checkIfSizeIsPositive(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Ilość pamięci nie może być ujemna!");
        }
    }

    @Override
    protected String getDeviceSpecs() {
        return "\nTaktowanie RAM: " + clockRate + "\nTemperatura RAM: " + temperature + "\nTemperatura bezpieczna: " +
                safeTemp + "\nIlość pamięci RAM: " + size;
    }
}
