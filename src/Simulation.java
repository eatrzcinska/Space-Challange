import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    // metoda o nazwie loadItems, która zwróci ArrayList zawierający wszystkie Itemy z listy phase-1
    public ArrayList loadItems () throws Exception {

        //pobieram plik phase-1
        File file = new File("phase-1.txt");
        Scanner scanner = new Scanner (file);

        //tworzę obiekt tyu ArrayList, który będzie pobierał tylko obiekty typu Item
        ArrayList <Item> itemList = new ArrayList<>();

        //pętla w której tworzę po kolei obiety z każdej linijki pliku
        while (scanner.hasNextLine()){

            String line = scanner.nextLine();

            String [] tablica = line.split("=");


            Item nextItem = new Item (tablica[0], Integer.parseInt(tablica[1]));

            itemList.add(nextItem);
        }
        return itemList;
    }

    //metoda
    public ArrayList loadU1 () throws Exception {

        ArrayList <Item> loadU1Items = loadItems();

        ArrayList <U1> rocketU1List = new ArrayList<>();

        while (loadU1Items.size()!=0){

            U1 rocketU1 = new U1 ();
            while(loadU1Items.get(0).weight + rocketU1.currentWeight<rocketU1.rocketMaxWeight){
                rocketU1.currentWeight+=loadU1Items.get(0).weight;
                loadU1Items.remove(0);
            }
            rocketU1List.add(rocketU1);
        }

        return rocketU1List;

    }

    //metoda
    public ArrayList loadU2 () throws Exception {

        ArrayList <Item> loadU2Items = loadItems();

        ArrayList <U2> rocketU2List = new ArrayList<>();

        while (loadU2Items.size()!=0){

            U2 rocketU2 = new U2 ();
            while(loadU2Items.get(0).weight + rocketU2.currentWeight<rocketU2.rocketMaxWeight){
                rocketU2.currentWeight+=loadU2Items.get(0).weight;
                loadU2Items.remove(0);
            }
            rocketU2List.add(rocketU2);
        }

        return rocketU2List;

    }


    //metoda
    public int runSimulation (ArrayList <Rocket> rocket){
        int totalBudget=0;

        for (int i = 0; i<rocket.size() ; i++){
            if (rocket.get(i).launch()){
                System.out.println("Rakieta nr " + i + " szczęśliwie wystartowała");
                totalBudget += rocket.get(0).rocketCost;
                if(rocket.get(i).land()){
                    System.out.println("Rakieta nr " + i + " szczęśliwie wylądowała");
                }else{
                    System.out.println("Rakieta nr "+ i + " rozbiła się przy lądowaniu");
                    i--;
                }
            }else{
                System.out.println("Rakieta nr " + i + " rozbiła się podczas startu");
                totalBudget += rocket.get(i).rocketCost;
                i--;
            }
        }
        System.out.println("Misja zakończona");
        System.out.println("Całkowity budżet wynosi " + totalBudget +"$");
        return totalBudget;

    }


}
