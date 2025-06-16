package main;

import java.io.Serializable;

public class Player implements Serializable{
    private String name;
    private static final long serialVersionUID = 123892382;

    public Player(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public String attack(Monster target){
        System.out.println(name + " hyökkää " + target.getType() + " hirviöön!");
        String stillKicking = target.takeDamage(10);
        return stillKicking;
    }
}
