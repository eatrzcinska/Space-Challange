public class U1 extends Rocket {

// Constructor
    public U1 () {
        rocketCost = 100000000;
        rocketWeight = 10000;
        rocketMaxWeight = 18000;
        currentWeight = rocketWeight;
    }

// I am overriding launch method
    public boolean launch(){

        // Chance of launch explosion according to formula
       chanceOfLaunchExplosion =  0.5 * ((currentWeight - rocketWeight)/(rocketMaxWeight - rocketWeight));

        // I am generating a random double value grater than or equal 0.0 and less than 1.0
        double number = Math.random();

        // I am checking if the rocket is crashed
        if(number > chanceOfLaunchExplosion){
            return true;
        } else {
            return false;
        }
    }

    // I am overriding launch method
    public boolean land(){

        // Chance of landing crash according to formula
        chanceOfLandingCrash =  0.01 * ((currentWeight - rocketWeight)/(rocketMaxWeight - rocketWeight));

        // I am generating a random double value grater than or equal 0.0 and less than 1.0
        double number = Math.random();

        // I am checking if the rocket is crashed
        if(number > chanceOfLandingCrash){
            return true;
        } else {
            return false;
        }
    }
}
