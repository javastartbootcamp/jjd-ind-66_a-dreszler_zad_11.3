package pl.javastart.task;

public class Memory extends OverclockableComponent {
    private int size;
    private static final double RAM_OC_TEMP_INCREASE = 15;
    private static final int RAM_OC_INCREMENT = 100;

    public Memory(String model, String producer, String serialNumber, int clockRate, double temperature, double safeTemp, int size) {
        super(model, producer, serialNumber, clockRate, temperature, safeTemp);
        setSize(size);
    }

    @Override
    protected double getTempIncrease() {
        return RAM_OC_TEMP_INCREASE;
    }

    @Override
    protected int getOverclockIncrement() {
        return RAM_OC_INCREMENT;
    }

    private void setSize(int size) {
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
                safeTemp + "\nIlość pamięci RAM: " + size + " MB";
    }
}
