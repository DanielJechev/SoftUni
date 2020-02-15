package spaceStation.core;

import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.BaseAstronaut;
import spaceStation.models.planets.Planet;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;
import spaceStation.repositories.Repository;

import static spaceStation.common.ConstantMessages.REPORT_ASTRONAUT_INFO;

public class ControllerImpl implements Controller {
private Repository<Astronaut> astronautRepository;
private Repository<Planet> planetRepository ;


    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository=new PlanetRepository();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut = null;
        if (!type.equals("Biologist")||!type.equals("Geodesist")||!type.equals("Meteorologist")){
  throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
        }
        this.astronautRepository.add(astronaut);
        return String.format(ConstantMessages.ASTRONAUT_ADDED,type,astronautName) ;
    }


    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet=null;
        this.planetRepository.add(planet);
        return String.format(ConstantMessages.PLANET_ADDED,planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
if (astronautName==null){
    throw new IllegalArgumentException(String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST, astronautName));
}

        return String.format(String.format(ConstantMessages.ASTRONAUT_RETIRED,astronautName));
    }


    @Override
    public String explorePlanet(String planetName) {
        return null;
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(ConstantMessages.REPORT_PLANET_EXPLORED, 0));
        sb.append(System.lineSeparator());
        sb.append(REPORT_ASTRONAUT_INFO);

        this.astronautRepository.getModels().forEach(e->sb.append(System.lineSeparator()).append(e.toString()));

        return sb.toString();
    }
}
