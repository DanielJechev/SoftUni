package core;

import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;

import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.Map;

public class MachinesManagerImpl implements MachinesManager {

    public MachinesManagerImpl(PilotFactory pilotFactory, MachineFactory machineFactory, Map<String, Pilot> pilots, Map<String, Machine> machines) {
     //TODO: Implement me

    }


    @Override
    public String hirePilot(String name) {
        return null;
    }

    @Override
    public String manufactureTank(String name, double attackPoints, double defensePoints) {
        return null;
    }

    @Override
    public String manufactureFighter(String name, double attackPoints, double defensePoints) {
        return null;
    }

    @Override
    public String engageMachine(String selectedPilotName, String selectedMachineName) {
        return null;
    }

    @Override
    public String attackMachines(String attackingMachineName, String defendingMachineName) {
        return null;
    }

    @Override
    public String pilotReport(String pilotName) {
        return null;
    }

    @Override
    public String toggleFighterAggressiveMode(String fighterName) {
        return null;
    }

    @Override
    public String toggleTankDefenseMode(String tankName) {
        return null;
    }
}
