public class Measurement {
    private String timestamp;
    private Sensor sensor;
    private MeasureType measureType;
    private Double value;

    public Measurement(String timestamp, Sensor sensor, MeasureType measureType, Double value) {
        this.timestamp = timestamp;
        this.sensor = sensor;
        this.measureType = measureType;
        this.value = value;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public MeasureType getMeasureType() {
        return measureType;
    }

    public void setMeasureType(MeasureType measureType) {
        this.measureType = measureType;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
