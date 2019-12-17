import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Sensor> sensors = new ArrayList<>();
        importSensors(sensors);
        System.out.println(sensors);
    }

    public static void importSensors(ArrayList<Sensor> sensors) {
        String sensorsDataFile ="src/Sensors.csv";
        BufferedReader br = null;
        String line;
        String splitLineBy = ";";

        try {
            br = new BufferedReader(new FileReader(sensorsDataFile));
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] row = line.split(splitLineBy);
                Sensor newSenor = new Sensor(row[0], Double.parseDouble(row[1]), Double.parseDouble(row[2]), "");
                sensors.add(newSenor);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void importMeasureTypes(ArrayList<MeasureType> sensors) {
        String measureTypeDataFile ="src/AttributeType.csv";
        BufferedReader br = null;
        String line;
        String splitLineBy = ";";

        try {
            br = new BufferedReader(new FileReader(measureTypeDataFile));
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] row = line.split(splitLineBy);
//                MeasureType newSenor = new MeasureType(row[0], Double.parseDouble(row[1]), Double.parseDouble(row[2]));
//                sensors.add(newSenor);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private Double getMean(String placeFilter, String timeFilter) {

        ArrayList<Measurement> measurements = new ArrayList<>();
        ArrayList<Sensor> sensors = new ArrayList<>();
        ArrayList<Sensor> measureTypes = new ArrayList<>();

        String sensorsDataFile ="./Sensors.csv";
        BufferedReader br;
        String line;
        String splitLineBy = ",";

        try {
            br = new BufferedReader(new FileReader(sensorsDataFile));
            while ((line = br.readLine()) != null) {
                String[] row = line.split(splitLineBy);

//                Timestamp;SensorID;AttributeID;Value;
            }
        } catch (Exception e) {

        }

        return 0;
    }
}
