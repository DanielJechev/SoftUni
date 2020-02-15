package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {

    public Biologist(String name) {
        super(name, 70);
    }
    public void breath(){
        if (this.getOxygen()-5>=0){
         setOxygen(this.getOxygen()-5);
        }else {
            this.setOxygen(0);
        }
    }
}
