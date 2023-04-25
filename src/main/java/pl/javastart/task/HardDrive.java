package pl.javastart.task;

public class HardDrive extends Component {
    private int size;

    public HardDrive(String model, String producer, String serialNumber, int size) {
        super(model, producer, serialNumber);
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
        return "\nPamięć: " + size + " GB";
    }
}
