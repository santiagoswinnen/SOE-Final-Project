public class Sensor {
    private String sensorId;
    private Double latitude;
    private Double longitude;
    private String description;

    public Sensor(String sensorId, Double latitude, Double longitude, String description) {
        this.sensorId = sensorId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
