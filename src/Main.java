public class Main {

    public static void main(String[]args) throws Exception{

        Simulation simulation1 = new Simulation();

        System.out.println("The simulation of U1 rockets.");

        System.out.println("Phase 1 started");
        long U1budget1 = simulation1.runSimulation(simulation1.loadU1("phase-1.txt"));
        System.out.println("The end of Phase 1.");

        System.out.println("Phase 2 started");
        long U1budget2 = simulation1.runSimulation(simulation1.loadU1("phase-2.txt"));
        System.out.println("The end of Phase 2.");
        long U1totalBudget = (U1budget1 + U1budget2);
        System.out.println("The U1 total budget is " + U1totalBudget + "$");
        System.out.println(" ");

        Simulation simulation2 = new Simulation();
        System.out.println("The simulation of U2 rockets.");

        System.out.println("Phase 1 started");
        long U2budget1 = simulation2.runSimulation(simulation2.loadU2("phase-1.txt"));
        System.out.println("The end of Phase 1.");

        System.out.println("Phase 2 started");
        long U2budget2 = simulation2.runSimulation(simulation2.loadU2("phase-2.txt"));
        System.out.println("The end of Phase 2.");
        long U2totalBudget = (U2budget1 + U2budget2);
        System.out.println("The U2 total budget is " + U2totalBudget + "$");
        System.out.println(" ");
    }
}
