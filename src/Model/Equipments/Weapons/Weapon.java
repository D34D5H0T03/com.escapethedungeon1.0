package Model.Equipments.Weapons;

import Model.Entities.Stats;
import Util.Dice;

public class Weapon {
    private final WeaponType type;
    private final String name;
    private final Dice.DiceType primaryDice;
    private final Dice.DiceType secondaryDice;
    private final Stats scalingStat;

    public Weapon(WeaponType type){
        this.type = type;
        this.name = type.getName();
        this.primaryDice = type.getPrimaryDice();
        this.secondaryDice = type.getSecondaryDice();
        this.scalingStat = type.getScalingStat();

    }

    public WeaponType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Dice.DiceType getPrimaryDice() {
        return primaryDice;
    }

    public Dice.DiceType getSecondaryDice() {
        return secondaryDice;
    }

    public Stats getScalingStat() {
        return scalingStat;
    }

    public int calculateBaseDamage() {
        return Dice.rollDice(primaryDice) + Dice.rollDice(secondaryDice);
    }

    public String getDamageDescription() {
        return primaryDice + " + " + secondaryDice;
    }
}
