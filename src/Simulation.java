import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    // this method loads all items from a text file and returns an ArrayList of Items
    public ArrayList loadItems (String nameOfFile) throws Exception {

        // loading a file
        File file = new File(nameOfFile);
        Scanner scanner = new Scanner (file);

        // creating an ArrayList object
        ArrayList <Item> itemList = new ArrayList<>();

        // creating Item objects from loaded file and putting them into ArrayList
        while (scanner.hasNextLine()){

            String line = scanner.nextLine();

            String [] list = line.split("=");

            Item nextItem = new Item (list[0], Integer.parseInt(list[1]));

            itemList.add(nextItem);
        }
        return itemList;
    }

    // this method takes the ArrayList of Items returned from loadItems and starts creating U1 rockets
    public ArrayList loadU1 (String nameOfFile) throws Exception {

        ArrayList <Item> loadU1Items = loadItems(nameOfFile);

        ArrayList <U1> rocketU1List = new ArrayList<>();

        while (loadU1Items.size()!=0){
            U1 rocketU1 = new U1 ();

            while (loadU1Items.size()!= 0 && rocketU1.canCarry(loadU1Items.get(0))){
                rocketU1.carry(loadU1Items.get(0));
                loadU1Items.remove(0);
            }

            rocketU1List.add(rocketU1);
        }
        return rocketU1List;
    }

    // this method takes the ArrayList of Items returned from loadItems and starts creating U2 rockets
    public ArrayList loadU2 (String nameOfFile) throws Exception {

        ArrayList <Item> loadU2Items = loadItems(nameOfFile);

        ArrayList <U2> rocketU2List = new ArrayList<>();

        while (loadU2Items.size()!=0){

            U2 rocketU2 = new U2 ();

            while(loadU2Items.size()!=0 && (rocketU2.canCarry(loadU2Items.get(0)))){
                rocketU2.carry(loadU2Items.get(0));
                loadU2Items.remove(0);
            }
            rocketU2List.add(rocketU2);
        }
        return rocketU2List;
    }

    // this method takes an ArrayList of Rockets and calls launch and land methods for each of the rockets in the ArrayList then return partial budget required to send all rockets in a phase

    public long runSimulation (ArrayList <Rocket> rocket){

        long totalBudget=0;

        for (int i = 0; i<rocket.size() ; i++){
            if (rocket.get(i).launch()){
                System.out.println("The rocket number " + (i+1) + " started.");
                totalBudget += rocket.get(i).rocketCost;
                if(rocket.get(i).land()){
                    System.out.println("The rocket number " + (i+1) + " landed.");
                }else{
                    System.out.println("The rocket number "+ (i+1) + " crashed when it was landing.");
                    i--;
                }
            }else{
                System.out.println("The rocket number " + (i+1) + " exploded when it was launching.");
                totalBudget += rocket.get(i).rocketCost;
                i--;
            }
        }
        
        return totalBudget;
    }
}
