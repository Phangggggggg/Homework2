package muzoo.io.ooc.zork;

import java.util.ArrayList;

public class Zombies {
    private int spreadingRate; // maximum rate = 10
    private int hp; // hp is 100
    private ArrayList<String> infectedCountry; // list of country that already infected
    private int attack;
    public Zombies(int spreadingRate){

        this.spreadingRate  = spreadingRate;
    }
    private void addSpreadingRate(){
        spreadingRate++;
    }
    private void decreaseHP(){
        hp--;
    }










}
