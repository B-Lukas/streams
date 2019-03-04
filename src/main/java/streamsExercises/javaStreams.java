package streamsExercises;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;

public class javaStreams {

    public static List<CSVRecord> getData() {

        File csvData = new File("zillow.csv");
        List<CSVRecord> list = null;
        try {
            CSVParser parser = CSVParser.parse(csvData, UTF_8, CSVFormat.DEFAULT.withHeader("Index", "Living Space (sq ft)", "Beds", "Baths", "Zip", "Year", "List Price ($)"));
            list = parser.getRecords().stream().skip(1).collect(Collectors.toList());

        } catch (IOException e) {
        }

        return list;
    }

    public static double maxLivingSpace(List<CSVRecord> data, ToDoubleFunction toDoubleFunction) {
        return data.stream().mapToDouble(toDoubleFunction).max().orElse(0);
    }

    public static void main(String[] args) {

        List<CSVRecord> data = getData();

        System.out.println(data);
        System.out.println(maxLivingSpace(data, AddressesCsv::getLivingSpace));

    }
}