package main;

import java.io.Serializable;

public class Monster implements Serializable{
    private String type;
    private int health;
    private static final long serialVersionUID = 1238933382;
    
    public Monster() {
        this.type = null;
        this.health = 30;
    }

    public Monster (String type, int health){
        this.type = type;
        this.health = health;
    }

    public void printInfo(int number) {
        System.out.println(number++ + ": " + type + " / " + health + "HP");
    }
    public String getType(){
        return type;
    }

    public int getHealth(){
        return health;
    }
    
    public String takeDamage(int dmg){
        health = health - dmg;
        String stillKicking = "juu";
        if( health <= 0){
            System.out.println(type + " on kuollut!");
            stillKicking = "ei";
        }else{
            System.out.println("Hirviöllä on " + health + " elämää jäljellä.");
        } 
        return stillKicking;
    }
}   

