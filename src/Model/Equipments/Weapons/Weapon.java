package Model.Equipments.Weapons;

import Model.Entities.Stats;

public class Weapon {
    private final WeaponType type;
    private final String name;
    private final int primaryDamage;
    private final int secondaryDamage;
    private final Stats scalingStat;

    public Weapon(WeaponType type){
        this.type = type;
        this.name = type.getName();
        this.primaryDamage = type.getPrimaryDamage();
        this.secondaryDamage = type.getSecondaryDamage();
        this.scalingStat = type.getScalingStat();

    }

    public WeaponType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getPrimaryDamage() {
        return primaryDamage;
    }

    public int getSecondaryDamage() {
        return secondaryDamage;
    }

    public Stats getScalingStat() {
        return scalingStat;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", primaryDamage=" + primaryDamage +
                ", secondaryDamage=" + secondaryDamage +
                ", scalingStat=" + scalingStat +
                '}';
    }
}
