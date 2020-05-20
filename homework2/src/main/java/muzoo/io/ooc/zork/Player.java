package muzoo.io.ooc.zork;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Player {

    String filePath;
    HashMap<String, List<String>> countryNeighbourMap = new HashMap<>();
    ArrayList<Country> keepCountry = new ArrayList<>();
    ArrayList<SeaAndOcean> keepSeaOcean = new ArrayList<>();


    public Player(String filePath){
        this.filePath = filePath;
    }

    public void createEveryCountry(){
        try
        {// FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(filePath);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;
            while((line = bufferedReader.readLine()) != null) {
                String[] lst = line.split(":");
                String country = lst[0].trim();
                String neighbour = lst[1].trim();
                String[] eachNeighbour = neighbour.split(",");
                countryNeighbourMap.put(country, Arrays.asList(eachNeighbour));
            }
            bufferedReader.close();

        }
        catch(IOException ex) {
            System.out.println("Unable to open file '" + filePath + "'");
        }

    }

    public HashMap<String, List<String>> getCountryNeighbourMap() {
        createEveryCountry();
        return countryNeighbourMap;
    }

    public void createCountryObject(){
        createEveryCountry();
        for (HashMap.Entry<String,List<String>> entry:countryNeighbourMap.entrySet()) {
            Country country = new Country(entry.getKey(),entry.getValue());
            keepCountry.add(country);
        }

    }

    public void createSeaOceanObject(){
        createEveryCountry();
        for (HashMap.Entry<String,List<String>> entry:countryNeighbourMap.entrySet()) {
            if (entry.getKey().contains("Ocean") || entry.getKey().contains("Sea")){
                SeaAndOcean sea = new SeaAndOcean(entry.getKey(),entry.getValue());
                keepSeaOcean.add(sea);
            }

        }

    }

    public ArrayList<Country> getKeepCountry() {
        createCountryObject();
        return keepCountry;
    }

    public ArrayList<SeaAndOcean> getKeepSeaOcean() {
        createSeaOceanObject();
        return keepSeaOcean;
    }




    public Country random(){
        Player world = new Player(filePath);
        ArrayList<Country> countries = world.getKeepCountry();
        Random rand = new Random();
        Country randomCountry= countries.get(rand.nextInt(countries.size()));
        return randomCountry;
    }




    public static void main(String[] args) {
        Player try1 = new Player("/Users/phang/Desktop/Zork/List.txt");
        System.out.println(try1.random().getNameCountry());
        System.out.println(try1.getKeepSeaOcean());
    }
}
