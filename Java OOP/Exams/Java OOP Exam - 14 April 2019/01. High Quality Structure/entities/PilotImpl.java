package entities;

import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.ArrayList;
import java.util.List;

public class PilotImpl implements Pilot {

    private static final String INVALID_PILOT = "Pilot name cannot be null or empty string.";
    private static final String INVALID_MACHINE = "Null machine cannot be added to the pilot.";

    private String name;
    private List<Machine> machines;

    public PilotImpl(String name) {
        setName(name);
        this.machines = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addMachine(Machine machine) {
        validateMachine(machine);
    }

    @Override
    public List<Machine> getMachines() {
        return this.machines;
    }

    @Override
    public String report() {

        //TODO: Implement me
        
        return "";
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_PILOT);
        }
        this.name = name;
    }

    private void validateMachine(Machine machine) {
        if (machine == null) {
            throw new NullPointerException(INVALID_MACHINE);
        }
    }
}
