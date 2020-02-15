package aquarium.core;

import aquarium.common.ConstantMessages;
import aquarium.common.ExceptionMessages;
import aquarium.models.aquariums.Aquarium;
import aquarium.models.decorations.Decoration;
import aquarium.models.fish.Fish;
import aquarium.repositories.DecorationRepository;
import aquarium.repositories.Repository;

import java.util.ArrayList;
import java.util.List;

public class ControllerImpl implements Controller {
    private DecorationRepository decorations;
    private List<Aquarium> aquariums;
    private List<Fish> fishList;

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums = new ArrayList<>();
        this.fishList=new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium=null;
        if (aquariumType.equals("FreshwaterAquarium")||aquariumType.equals("SaltwaterAquarium")){
            this.aquariums.add(aquarium);
        }else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_AQUARIUM_TYPE);
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AQUARIUM_TYPE,aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration=null;
        if (type.equals("Ornament")||type.equals("Plant")){
            this.decorations.add(decoration);
        }else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_DECORATION_TYPE);
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_TYPE,type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        return null;
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish=null;
        if (fishType.equals("FreshwaterFish")||fishType.equals("SaltwaterFish")){
              fishList.add(fish);
        }else if (!fishType.equals("FreshwaterFish")||!fishType.equals("SaltwaterFish")){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_FISH_TYPE);
        }


        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM,fishType,aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {



        return String.format(ConstantMessages.FISH_FED,aquariumName);
    }

    @Override
    public String calculateValue(String aquariumName) {
        return null;
    }

    @Override
    public String report() {
        return null;
    }
}
