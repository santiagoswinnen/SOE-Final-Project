public class MeasureType {

    private String attributeId;
    private String unit;
    private String description;

    public MeasureType(String attributeId, String unit, String description) {
        this.attributeId = attributeId;
        this.unit = unit;
        this.description = description;
    }

    public String getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(String attributeId) {
        this.attributeId = attributeId;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
