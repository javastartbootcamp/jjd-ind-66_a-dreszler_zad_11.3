package pl.javastart.task;

public class Processor extends OverclockableComponent {
    private static final double CPU_OC_TEMP_INCREASE = 10;
    private static final int CPU_OC_INCREMENT = 100;

    public Processor(String model, String producer, String serialNumber, int clockRate, double temperature, double safeTemp) {
        super(model, producer, serialNumber, clockRate, temperature, safeTemp);
    }

    @Override
    protected double getTempIncrease() {
        return CPU_OC_TEMP_INCREASE;
    }

    @Override
    protected int getOverclockIncrement() {
        return CPU_OC_INCREMENT;
    }

    @Override
    protected String getDeviceSpecs() {
        return "\nTaktowanie CPU: " + clockRate + " MHz\nTemperatura CPU: " + temperature + " C\nTemperatura bezpieczna: " +
                safeTemp + " C";
    }
}
