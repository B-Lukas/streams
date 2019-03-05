package streamsExercises;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;

public class javaStreams {

    public static List<AddressesCsv> getData() {

        File csvData = new File("zillow.csv");
        List<AddressesCsv> list = null;
        try (CSVParser parser = CSVParser.parse(csvData, UTF_8, CSVFormat.DEFAULT)) {
            list = parser.getRecords().stream().skip(1).map(AddressesCsv::AddressesCsvInit).collect(Collectors.toList());
        } catch (IOException e) {

        }
        return list;
    }

    public static Double maxLivingSpace(List<AddressesCsv> data) {
        return data.stream().mapToDouble(AddressesCsv::getLivingSpace).max().orElse(0);
    }

    public static Double avgLivingSpace(List<AddressesCsv> data) {
        return data.stream().mapToDouble(AddressesCsv::getLivingSpace).average().orElse(0);
    }

    public static Map<Integer, Integer> addressesGroupByBedswithMaxLivingSpace(List<AddressesCsv> data) {
        //noinspection OptionalGetWithoutIsPresent
        return data.stream().collect(groupingBy(AddressesCsv::getBeds, collectingAndThen(maxBy(comparingInt(AddressesCsv::getLivingSpace)), optional -> optional.get().getLivingSpace())));
    }

    public static void main(String[] args) {

        List<AddressesCsv> data = getData();
        System.out.println(maxLivingSpace(data));
        System.out.println(avgLivingSpace(data));
        System.out.print(addressesGroupByBedswithMaxLivingSpace(data));
    }
}