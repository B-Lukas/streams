package streamsExercises;

import org.apache.commons.csv.CSVRecord;

import java.util.Date;

public class AddressesCsv {

    public AddressesCsv(int index, int livingSpace, int beds) {
        Index = index;
        LivingSpace = livingSpace;
        Beds = beds;
    }

    int Index;
    int LivingSpace;
    int Beds;
    int Baths;
    int Zip;
    Date Year;
    int List;
    double Price;

    public int getIndex() {
        return Index;
    }

    public int getLivingSpace() {
        return LivingSpace;
    }

    public int getBeds() {
        return Beds;
    }

    public int getBaths() {
        return Baths;
    }

    public int getZip() {
        return Zip;
    }

    public Date getYear() {
        return Year;
    }

    public int getList() {
        return List;
    }

    public double getPrice() {
        return Price;
    }

    public static AddressesCsv AddressesCsvInit(CSVRecord csvRecord) {

        return new AddressesCsv(Integer.parseInt(csvRecord.get(0)), Integer.parseInt(csvRecord.get(1)), Integer.parseInt((csvRecord.get(2))));
    }

}
