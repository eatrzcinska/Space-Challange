public class U1 extends Rocket {

    public U1 () {
        this.rocketCost = 100000000;
        this.rocketWeight = 10000;
        this.rocketMaxWeight = 18000;
    }

    // konstruktor przeciążony
//    public U1(int rocketCost, int rocketWeight, int rocketMaxWeight) {
//        super(rocketCost, rocketWeight, rocketMaxWeight);
//  }

    public boolean launch(){

        //prawdopodobienstwo wybuchu
        chanceOfLaunchExplosion =  0.05 * ((currentWeight - rocketWeight)/(rocketMaxWeight - rocketWeight));

        //generuję losową liczbę w zakresie <0;1)
        double number = Math.random();

        // wykorzystuję dystrybuantę
        if(number > chanceOfLaunchExplosion){
            return true;
        } else {
            return false;
        }
    }

    public boolean land(){

        //prawdopodobienstwo wybuchu
        chanceOfLandingCrash =  0.01 * ((currentWeight - rocketWeight)/(rocketMaxWeight - rocketWeight));

        //generuję losową liczbę w zakresie <0;1)
        double number = Math.random();

        // wykorzystuję dystrybuantę
        if(number > chanceOfLandingCrash){
            return true;
        } else {
            return false;
        }
    }
}
