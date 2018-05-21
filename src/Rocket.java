public class Rocket implements SpaceShip{

    int rocketCost;
    int rocketWeight;
    int rocketMaxWeight;
    int currentWeight;
    double chanceOfLaunchExplosion;     //Chance of launch explosion
    double chanceOfLandingCrash;        //Chance od landing crash


// Constructor
    public Rocket() {
        rocketCost = 0;
        rocketWeight = 0;
        rocketMaxWeight = 0;
        currentWeight = 0;
        chanceOfLandingCrash = 0.0;
        chanceOfLaunchExplosion =0.0;
    }

// this method will be overridden in U1 and U2 classes
    @Override
    public boolean launch() {
        return true;
    }

// this method will be overridden in U1 and U2 classes
    @Override
    public boolean land() {
        return true;
    }

// this method will not be overridden in U1 and U2 classes
    @Override
    public boolean canCarry(Item exampleItem) {
        if (exampleItem.weight<=(rocketMaxWeight-currentWeight)){
            return true;
        } else {
            return false;
        }
    }

// this method will be overridden in U1 and U2 classes
    @Override
    public void carry(Item exampleItem) {
        currentWeight += exampleItem.weight;
    }

}
