public class Rocket implements SpaceShip{

    int rocketCost;                     //koszt rakiety
    int rocketWeight;                   // waga rakiety
    int rocketMaxWeight;                //dopuszczalna waga rakiety
    double chanceOfLaunchExplosion;     //prawdopodbienstwo eksplozji przy starcie
    double chanceOfLandingCrash;        //prawdopodobiennstwo eksplozji przy ladowaniu
    int currentWeight = rocketWeight;   //aktualna waga

//domyslny konstruktor klasy
    public Rocket() {
    }

//konstruktor przeciążony
//    public Rocket (int rocketCost, int rocketWeight, int rocketMaxWeight){
//        this.rocketCost=rocketCost;
//        this.rocketWeight=rocketWeight;
//        this.rocketMaxWeight=rocketMaxWeight;
//    }

// metoda zostanie naspisana w klasach dziedziczących
    @Override
    public boolean launch() {
        return true;
    }
//metoda zostanie nadpisana w klasach dziedziczących
    @Override
    public boolean land() {
        return true;
    }
//metoda nie zostanie nadpisana
    @Override
    public boolean canCarry(Item exampleItem) {

        if (exampleItem.weight<(rocketMaxWeight-currentWeight)){
            return true;
        } else {
            return false;
        }

    }
//metoda nie zostanie nadpisana
    @Override
    public int carry(Item exampleItem) {

        currentWeight += exampleItem.weight;
        return currentWeight;
    }


}
