package entities;

import entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {

    private static final double DEFAULT_HEALTH_POINTS_TANK = 100;
    private static final double ATTACK_POINTS_MODIFIER_TANK = 40.0;
    private static final double DEFFENCE_POINTS_MODIFIER_TANK = 30.0;

    private boolean defenseMode;

    protected TankImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, DEFAULT_HEALTH_POINTS_TANK);
        this.defenseMode = true;
        toggleDefenseMode();
    }

    @Override
    public boolean getDefenseMode() {
        return this.defenseMode;
    }

    @Override
    public void toggleDefenseMode() {
        if (this.defenseMode){

            super.setAttackPoints(super.getAttackPoints()-ATTACK_POINTS_MODIFIER_TANK);
            super.setDefensePoints(super.getDefensePoints()+DEFFENCE_POINTS_MODIFIER_TANK);
        }else {

            super.setAttackPoints(super.getAttackPoints()+ATTACK_POINTS_MODIFIER_TANK);
            super.setDefensePoints(super.getDefensePoints()-DEFFENCE_POINTS_MODIFIER_TANK);
        }
    }
}
