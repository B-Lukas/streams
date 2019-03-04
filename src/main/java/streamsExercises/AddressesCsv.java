package streamsExercises;

import java.util.Date;

public class AddressesCsv {

    String Index;
    double LivingSpace;
    int Beds;
    int Baths;
    int Zip;
    Date Year;

    public String getIndex() {
        return Index;<
    }

    public double getLivingSpace() {
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

    public AddressesCsv(String index, double livingSpace, int beds, int baths, int zip, Date year, int list, double price) {
        Index = index;
        LivingSpace = livingSpace;
        Beds = beds;
        Baths = baths;
        Zip = zip;
        Year = year;
        List = list;
        Price = price;
    }

    int List;
    double Price;


}
