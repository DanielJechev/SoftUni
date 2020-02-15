package entities;

import entities.interfaces.Fighter;

public class FighterImpl extends BaseMachine implements Fighter {

    private static final double DEFAULT_HEALTH_POINTS_FIGHTER = 200.0;
    private static final double ATTACK_POINTS_MODIFIER_FIGHTER = 50.0;
    private static final double DEFFENCE_POINTS_MODIFIER_FIGHTER = 25.0;

    private boolean aggressiveMode;

    public FighterImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, DEFAULT_HEALTH_POINTS_FIGHTER);
        this.aggressiveMode = true;
        toggleAggressiveMode();
    }

    @Override
    public boolean getAggressiveMode() {
        return this.aggressiveMode;
    }

    @Override
    public void toggleAggressiveMode() {

        if (this.aggressiveMode) {
            super.setAttackPoints(super.getAttackPoints()+ATTACK_POINTS_MODIFIER_FIGHTER);
            super.setDefensePoints(super.getDefensePoints()-DEFFENCE_POINTS_MODIFIER_FIGHTER);
        } else {
            super.setAttackPoints(super.getAttackPoints()-ATTACK_POINTS_MODIFIER_FIGHTER);
            super.setDefensePoints(super.getDefensePoints()+DEFFENCE_POINTS_MODIFIER_FIGHTER);
        }

    }
}
