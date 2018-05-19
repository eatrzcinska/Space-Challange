import java.util.ArrayList;

public class Main {

    public static void main(String[]args) throws Exception{

        Simulation symulacja1 = new Simulation();

        symulacja1.loadItems();


        System.out.println("Symulacja rakiety U1");

        symulacja1.runSimulation(symulacja1.loadU1());

        System.out.println("Symulacja rakiety U1 zakończona");

        System.out.println("Symulacja rakiety U2");

        symulacja1.runSimulation(symulacja1.loadU2());

        System.out.println("Symulacja rakiety U2 zakończona");


    }
}
