package main;

import java.util.Scanner;
public class App 
{
    public static void main( String[] args )
    {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Syötä pelaajan nimi:");
        String name = sc.nextLine();
        Player player = new Player(name);
        Cave cave = new Cave(player);
        
        boolean exit = false;
        while(!exit) {
            System.out.println("1) Lisää luolaan hirviö");
            System.out.println("2) Listaa hirviöt");
            System.out.println("3) Hyökkää hirviöön");
            System.out.println("4) Tallenna peli");
            System.out.println("5) Lataa peli");
            System.out.println("0) Lopeta peli");

            if(sc.hasNext()) {
                int i = 0;
                String stringInput = sc.nextLine();
                i = Integer.parseInt(stringInput);

                switch(i) {
                     case 1:
                        System.out.println("Anna hirviön tyyppi:");
                        String type = sc.nextLine();
                        System.out.println("Anna hirviön elämän määrä numerona:");
                        String healthString =sc.nextLine();
                        int health = Integer.parseInt(healthString);

                        Monster newMonster = new Monster(type, health);
                        cave.addMonster(newMonster);
                    
                
                        break;

                    case 2:
                        cave.listMonsters();
                        break;

                    case 3:
                        System.out.println("Valitse hirviö johon hyökätä:");
                        cave.listMonsters();
                        String idString = sc.nextLine();
                        int id = Integer.parseInt(idString);
                        Monster targetMonster = cave.getMonster(id);
                        String stillKicking = player.attack(targetMonster);
                        String dead = "ei";
                        if( stillKicking.equals(dead)){
                            cave.removeMonster(id);
                        }
                        break;

                    case 4:
                        System.out.println("Anna tiedoston nimi, johon peli tallentaa:");
                        String fileName = sc.nextLine();
                        cave.saveGame(fileName);
                        break;

                    case 5:
                        System.out.println("Anna tiedoston nimi, josta peli ladataan:");
                        String fileName1 = sc.nextLine();
                        cave.loadGame(fileName1);
                        break;

                    case 0:
                        System.out.println("Peli päättyy. Kiitos pelaamisesta!");
                        exit = true;
                        break;
                    
                    default:
                        System.out.println("Syöte oli väärä");
                        break;
                }
            }
        }
        sc.close();
    }
}
