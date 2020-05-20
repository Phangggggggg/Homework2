package muzoo.io.ooc.zork;

import java.util.ArrayList;
import java.util.Random;

public class Play {
    private String filePath;
    public Play(String  filePath){
        this.filePath =  filePath;
    }

    public Country random(){
        Player world = new Player(filePath);
        ArrayList<Country> countries = world.getKeepCountry();
        Random rand = new Random();
        Country randomCountry= countries.get(rand.nextInt(countries.size()));
        return randomCountry;
    }

//    public Country randomInfected(){
//        Player world = new Player(filePath);
//
//    }



    public static void main(String[] args) {

    }

}
