package core.interfaces;

import entities.interfaces.Pilot;

public interface PilotFactory {
    Pilot createPilot(String name);
}
