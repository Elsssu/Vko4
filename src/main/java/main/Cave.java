package main;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Cave implements Serializable{
    private Player player;
    private ArrayList<Monster> monsters = new ArrayList<>();
    private static final long serialVersionUID = 1033892382;
    

    public Cave(Player player){
        this.player = player;

    }
    public void addMonster(Monster monster){
        monsters.add(monster);
    }

    public void listMonsters() {
        int id = 0;
        int listLength = monsters.size();
        if(listLength == 0){
            System.out.println("Luola on tyhjä.");
        }else{
            System.out.println("Luolan hirviöt:");
            for (Monster monster : monsters) {
                id = id + 1;
                monster.printInfo(id);
            }
        }
        
    }

    public void removeMonster(int id){
        id = id - 1;
        monsters.remove(id);
    }

    public Monster getMonster(int id){
        id = id - 1;
        Monster targetMonster = monsters.get(id);
        return targetMonster;
    }

    public void saveGame(String fileName){
        try {
            ObjectOutputStream gameWriter = new ObjectOutputStream(new FileOutputStream(fileName));
            gameWriter.writeObject(monsters);
            gameWriter.close();
            System.out.println("Peli tallennettiin tiedostoon " + fileName + ".");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void loadGame(String fileName1){
        try {
            ObjectInputStream gameReader = new ObjectInputStream(new FileInputStream(fileName1));
            monsters = (ArrayList<Monster>) gameReader.readObject();
            gameReader.close();
            String playerName = player.getName();
            System.out.println("Peli ladattu tiedostosta " + fileName1 + ". Tervetuloa takaisin, " + playerName  + ".");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
