public class Measurement {
    private int timestamp;
    private Sensor sensor;
    private MeasureType measureType;
    private int value;

    public Measurement(int timestamp, Sensor sensor, MeasureType measureType, int value) {
        this.timestamp = timestamp;
        this.sensor = sensor;
        this.measureType = measureType;
        this.value = value;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
