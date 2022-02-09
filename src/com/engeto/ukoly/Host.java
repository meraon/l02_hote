package com.engeto.ukoly;

import java.time.LocalDate;

public class Host {

    public Host(String name, String surrName, LocalDate dateOfBirth) {


            this.name = name;
            this.surrName = surrName;
            this.dateOfBirth = dateOfBirth;

    }
    String name;
    String surrName;
    LocalDate dateOfBirth;

    @Override
    public String toString(){
        return name +" "+ surrName +" "+ dateOfBirth;
    }

    public void getDescription(){
        if(name.endsWith("a")){
            System.out.println("Hosť: " +name + " " +surrName + " narodená: " + dateOfBirth);
        }
        else{
            System.out.println("Hosť: " +name + " " +surrName + " narodený: " + dateOfBirth);
        }
    }
}
