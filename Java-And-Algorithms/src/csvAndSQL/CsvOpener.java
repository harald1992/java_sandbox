package csvAndSQL;

import java.io.*;
import java.util.*;

public class CsvOpener {

    public static void csvOpenerStart() {
        bufferedReaderReadCsv();

        scannerReadCsv();

        // openCsv wordt ook vaak gebruikt, die gaat ook om met quotes etc
    }

    private static void bufferedReaderReadCsv() {
        List<List<String>> records = new ArrayList<>();
        String currentDirectory = System.getProperty("user.dir");
        System.out.println(currentDirectory);
        try (BufferedReader br = new BufferedReader(new FileReader("src/csvAndSQL/workers.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // System.out.println(records);
    }

    private static void scannerReadCsv() {
        List<HashMap<String, Object>> list = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("src/csvAndSQL/workers.csv"))) {
            scanner.useDelimiter(",");   // sets the delimiter pattern
            String[] headers = {};

            if (scanner.hasNextLine()) {
                headers = scanner.nextLine().split(","); // Skip header line and fill header names
            }

            while (scanner.hasNext())  // returns a boolean value
            {
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                HashMap<String, Object> person = new HashMap<>();

                for (int i = 0; i < headers.length; i++) {
                    person.put(headers[i], fields[i]);
                }
                list.add(person);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (HashMap<String, Object> person: list) {
            System.out.println(person);
        }

    }

}


