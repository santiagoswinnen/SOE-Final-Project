import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Sensor> sensors = new ArrayList<>();
        ArrayList<MeasureType> measureTypes = new ArrayList<>();
        importSensors(sensors);
        importMeasureTypes(measureTypes);
        System.out.println("Welcome! Please select a sensor:");
        System.out.println("(0) Sensor 0");
        System.out.println("(1) Sensor 1");
        System.out.println("(2) Sensor 2");
        System.out.println("(3) Sensor 3");
        System.out.println("(4) Sensor 4");
        System.out.println("(5) Sensor 5");
        System.out.println("(6) Sensor 6");
        System.out.println("(7) Sensor 7");
        System.out.println("(8) Sensor 8");
        System.out.println("(9) Sensor 9");
        Scanner s = new Scanner(System.in);
        int choice= 0;
        try {
            choice = s.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
        System.out.println("Insert start date: 'dd/mm'");
        try {
            String startDate;
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
        System.out.println("Insert end date: 'dd/mm'");
        try {
            String endDate = s.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }

    private static void importSensors(ArrayList<Sensor> sensors) {
        String sensorsDataFile ="src/Sensors.csv";
        BufferedReader br;
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

    private static void importMeasureTypes(ArrayList<MeasureType> measureTypes) {
        String measureTypeDataFile ="src/AttributeType.csv";
        BufferedReader br;
        String line;
        String splitLineBy = ";";

        try {
            br = new BufferedReader(new FileReader(measureTypeDataFile));
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] row = line.split(splitLineBy);
                MeasureType newMeasureType = new MeasureType(row[0], row[1], row[2]);
                measureTypes.add(newMeasureType);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private Double getMean(String placeFilter, String timeFilter) {

        ArrayList<Measurement> measurements = new ArrayList<>();
        ArrayList<Sensor> sensors = new ArrayList<>();
        ArrayList<Sensor> measureTypes = new ArrayList<>();

        String sensorsDataFile ="src/data_10sensors_1year.csv";
        BufferedReader br;
        String line;
        String splitLineBy = ";";

        try {
            br = new BufferedReader(new FileReader(sensorsDataFile));
            while ((line = br.readLine()) != null) {
                String[] row = line.split(splitLineBy);

//                Timestamp;SensorID;AttributeID;Value;
            }
        } catch (Exception e) {

        }

        return 0.0;
    }
}
