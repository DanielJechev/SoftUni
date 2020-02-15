package entities.interfaces;

import java.util.List;

public interface Machine {

    String getName();

    void setName(String name);

    Pilot getPilot();

    void setPilot(Pilot pilot);

    double getHealthPoints();

    void setHealthPoints(double healthPoints);

    double getAttackPoints();

    double getDefensePoints();

    List<String> getTargets();

    void attack(String target);

    String toString();
}
