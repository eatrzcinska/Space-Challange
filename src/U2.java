public class U2 extends Rocket {

    public U2 () {
        this.rocketCost = 120000000;
        this.rocketWeight = 18000;
        this.rocketMaxWeight = 29000;
    }

    //konstruktor przeciążony
//    public U2(int rocketCost, int rocketWeight, int rocketMaxWeight) {
//        super(rocketCost, rocketWeight, rocketMaxWeight);
//    }

    public boolean launch(){

        //prawdopodobienstwo wybuchu
        chanceOfLaunchExplosion =  0.04 * ((currentWeight - rocketWeight)/(rocketMaxWeight - rocketWeight));

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
        chanceOfLandingCrash =  0.08 * ((currentWeight - rocketWeight)/(rocketMaxWeight - rocketWeight));

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
