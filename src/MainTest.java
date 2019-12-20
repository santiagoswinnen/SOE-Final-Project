import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class MainTest {


    /**
     * Sensors should  be imported correctly
     */
    @Test
    public void importSensors() {
        ArrayList<Sensor> sensors = new ArrayList<>();
        Main.importSensors(sensors);
        assert(sensors.size() > 0);
    }

    /**
     * Measure types should  be imported correctly
     */
    @Test
    public void importMeasureTypes() {
        ArrayList<MeasureType> measureTypes = new ArrayList<>();
        Main.importMeasureTypes(measureTypes);
        assert(measureTypes.size() > 0);
    }

    /**
     * Invalid dates should return an empty array
     */
    @Test
    public void invalidDates() {
        ArrayList<Sensor> sensors = new ArrayList<>();
        ArrayList<MeasureType> measureTypes = new ArrayList<>();
        Main.importSensors(sensors);
        Main.importMeasureTypes(measureTypes);
        ArrayList<Measurement> m  = Main.aggregate(1, 4,5,4,3,sensors,measureTypes);
        assert(m.size() == 0);
    }

    /**
     * Valid dates should return an non empty array
     */
    @Test
    public void validDates() {
        ArrayList<Sensor> sensors = new ArrayList<>();
        ArrayList<MeasureType> measureTypes = new ArrayList<>();
        Main.importSensors(sensors);
        Main.importMeasureTypes(measureTypes);
        ArrayList<Measurement> m  = Main.aggregate(2, 4,5,6,7,sensors,measureTypes);
        assert(m.size() != 0);
    }

    /**
     * Invalid dates should return an non empty array
     */
    @Test
    public void invalidSensor() {
        ArrayList<Sensor> sensors = new ArrayList<>();
        ArrayList<MeasureType> measureTypes = new ArrayList<>();
        Main.importSensors(sensors);
        Main.importMeasureTypes(measureTypes);
        ArrayList<Measurement> m  = Main.aggregate(10, 4,5,4,3,sensors,measureTypes);
        assert(m.size() == 0);
    }
}