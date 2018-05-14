import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    // metoda o nazwie loadItems, która zwróci ArrayList zawierający wszystkie Itemy z listy phase-1
    public ArrayList loadItems () throws Exception {

        //pobieram plik phase-1
        File file = new File("phase-1");
        Scanner scanner = new Scanner (file);

        //tworzę obiekt tyu ArrayList, który będzie pobierał tylko obiekty typu Item
        public ArrayList <Item> itemList = new ArrayList<>();

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
    public ArrayList loadU1 (ArrayList listaX){

        U1 u1_number1 = new U1(100000000, 10000, 18000);

    }


}
