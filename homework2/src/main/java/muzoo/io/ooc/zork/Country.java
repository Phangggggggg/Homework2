package muzoo.io.ooc.zork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Country {
    private HashMap<String,Integer> countryWithSR = new HashMap<>();
    private boolean labExist = false;
    private ArrayList<String> originInfectedCountry = new ArrayList<>();
    private boolean invaded = false;
    private List<String> lstNeighbours = new ArrayList<>();
    private String nameCountry;

    public Country(String nameCountry, List<String> lstNeighbours){
        this.nameCountry = nameCountry;
        this.lstNeighbours = lstNeighbours;
    }


    public void setLabExist() {
        labExist = true;
    }
    public String getNameCountry(){
        return nameCountry;
    }

    public List<String> getLstNeighbours(){
        return lstNeighbours;
    }

    public void setInvaded(){
        invaded = true;
    }





}
