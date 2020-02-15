package core.interfaces;

public  interface MachinesManager {
    String hirePilot(String name);

    String manufactureTank(String name, double attackPoints, double defensePoints);

    String manufactureFighter(String name, double attackPoints, double defensePoints);

    String engageMachine(String selectedPilotName, String selectedMachineName);

    String attackMachines(String attackingMachineName, String defendingMachineName);

    String pilotReport(String pilotName);

    String toggleFighterAggressiveMode(String fighterName);

    String toggleTankDefenseMode(String tankName);
}
