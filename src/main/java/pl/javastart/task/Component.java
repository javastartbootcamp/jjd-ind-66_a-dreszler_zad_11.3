package pl.javastart.task;

abstract class Component {
    private String model;
    private String producer;
    private String serialNumber;

    public Component(String model, String producer, String serialNumber) {
        setModel(model);
        setProducer(producer);
        setSerialNumber(serialNumber);
    }

    String getModel() {
        return model;
    }

    String getProducer() {
        return producer;
    }

    String getSerialNumber() {
        return serialNumber;
    }

    void setModel(String model) {
        checkIfModelIsNull(model);
        this.model = model;
    }

    void setProducer(String producer) {
        checkIfProducerIsNull(producer);
        this.producer = producer;
    }

    void setSerialNumber(String serialNumber) {
        checkIfSerialNumberIsNull(serialNumber);
        this.serialNumber = serialNumber;
    }

    private void checkIfModelIsNull(String model) {
        if (model == null) {
            throw new IllegalArgumentException("Model nie może być nullem!");
        }
    }

    private void checkIfProducerIsNull(String producer) {
        if (producer == null) {
            throw new IllegalArgumentException("Producent nie może być nullem!");
        }
    }

    private void checkIfSerialNumberIsNull(String serialNumber) {
        if (serialNumber == null) {
            throw new IllegalArgumentException("Numer seryjny nie może być nullem!");
        }
    }

    protected String getDeviceSpecs() {
        return "";
    }

    public String toString() {
        return "================\nProducent: " + producer + "\nModel: " + model + "\nNr seryjny: " + serialNumber +
                getDeviceSpecs() + "\n================";
    }
}