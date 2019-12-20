import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
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

        int startDateDay= 0;
        int startDateMonth= 0;
        System.out.println("Insert start date");
        System.out.println("Day:");
        try {
            startDateDay = s.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
        System.out.println("Month:");
        try {
            startDateMonth = s.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input");
        }

        int endDateDay= 0;
        int endDateMonth= 0;
        System.out.println("Insert end date");
        System.out.println("Day:");
        try {
            endDateDay = s.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
        System.out.println("Month:");
        try {
            endDateMonth = s.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input");
        }

        ArrayList<Measurement> measurements = aggregate(choice, startDateDay, endDateDay, startDateMonth, endDateMonth, sensors, measureTypes);
    }

     static void importSensors(ArrayList<Sensor> sensors) {
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

     static void importMeasureTypes(ArrayList<MeasureType> measureTypes) {
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

    static ArrayList<Measurement> aggregate(int placeFilter, int startDay, int endDay, int  startMonth, int endMonth, ArrayList<Sensor> sensors, ArrayList<MeasureType> measureTypes) {

        ArrayList<Measurement> measurements = new ArrayList<>();

        String sensorsDataFile ="src/data_10sensors_1year.csv";
        BufferedReader br;
        String line;
        String splitLineBy = ";";
        String sensorName = new StringBuilder("Sensor").append(placeFilter).toString();

        int counter = 0;

        try {
            br = new BufferedReader(new FileReader(sensorsDataFile));
            br.readLine();
            br.readLine();
            while ((line = br.readLine()) != null) {
                counter++;
                StringBuilder fixedLine = new StringBuilder();
                for(int i=3; i < line.length(); i=i +2)  {
                    fixedLine.append(line.charAt(i));
                }
                line =  fixedLine.toString();
                boolean eligible = true;
                String[] row = line.split(splitLineBy);
                StringBuilder month = new StringBuilder();
                month.append(row[0].charAt(5));
                month.append(row[0].charAt(6));
                StringBuilder day = new StringBuilder();
                day.append(row[0].charAt(8));
                day.append(row[0].charAt(9));
                if(Integer.parseInt(month.toString()) <  startMonth ||  Integer.parseInt(month.toString()) >  endMonth) {
                    eligible = false;
                } else if (Integer.parseInt(month.toString()) ==  startMonth) {
                    if(Integer.parseInt(day.toString()) <  startDay) {
                        eligible = false;
                    }
                } else if (Integer.parseInt(month.toString()) ==  endMonth) {
                    if(Integer.parseInt(day.toString()) >  endDay) {
                        eligible = false;
                    }
                }

                if(!row[1].equals(sensorName)) {
                    eligible = false;
                }

                Sensor sensor = null;
                boolean finished = false;
                Iterator<Sensor> it = sensors.iterator();
                while(it.hasNext()  && !finished) {
                    Sensor current = it.next();
                    if(current.getSensorId().equals(row[1])) {
                        sensor = current;
                        finished = true;
                    }
                }

                MeasureType measureType = null;
                finished = false;
                Iterator<MeasureType> iter = measureTypes.iterator();
                while(iter.hasNext()  && !finished) {
                    MeasureType current = iter.next();
                    if(current.getAttributeId().equals(row[2])) {
                        measureType = current;
                        finished = true;
                    }
                }

                if(eligible) {
                    measurements.add(new Measurement(row[0], sensor, measureType, Double.parseDouble(row[3])));
                }
                br.readLine();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Iterator<Measurement> iterator = measurements.iterator();
        double so2Sum = 0.0;
        double no2Sum = 0.0 ;
        double pm10Sum = 0.0;
        double o3Sum =  0.0;
        double so2Count = 0.0;
        double no2Count = 0.0 ;
        double pm10Count = 0.0;
        double o3Count = 0.0;

        String  no2Unit = "";
        String  o3Unit = "";
        String  pm10Unit = "";
        String  so2Unit = "";

        while(iterator.hasNext()) {
            Measurement m  =  iterator.next();
            if(m.getMeasureType().getAttributeId().equals("SO2")) {
                so2Sum += m.getValue();
                so2Count += 1.0;
                so2Unit = m.getMeasureType().getUnit();
            }
            if(m.getMeasureType().getAttributeId().equals("NO2")) {
                no2Sum += m.getValue();
                no2Count += 1.0;
                no2Unit = m.getMeasureType().getUnit();
            }
            if(m.getMeasureType().getAttributeId().equals("PM10")) {
                pm10Sum += m.getValue();
                pm10Count += 1.0;
                pm10Unit = m.getMeasureType().getUnit();
            }
            if(m.getMeasureType().getAttributeId().equals("O3")) {
                o3Sum += m.getValue();
                o3Count += 1.0;
                o3Unit = m.getMeasureType().getUnit();
            }
        }
        System.out.print("O3 average value: ");
        System.out.print(o3Sum/o3Count);
        System.out.print(" ");
        System.out.println(o3Unit);

        System.out.print("SO2 average value: ");
        System.out.print(so2Sum/so2Count);
        System.out.print(" ");
        System.out.println(so2Unit);


        System.out.print("NO2 average value: ");
        System.out.print(no2Sum/no2Count);
        System.out.print(" ");
        System.out.println(no2Unit);

        System.out.print("PM10 average value: ");
        System.out.print(pm10Sum/pm10Count);
        System.out.print(" ");
        System.out.println(pm10Unit);


        return measurements;
    }
}
