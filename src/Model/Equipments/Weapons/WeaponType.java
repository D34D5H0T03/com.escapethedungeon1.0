package Model.Equipments.Weapons;

import Model.Entities.Stats;

public enum WeaponType {

    //||ADD DESCRIPTIONS!!!!!!||||
    IRON_SWORD("Iron Sword", 10, 8, Stats.STRENGTH),
    IRON_MACE("Iron Mace", 10, 4, Stats.STRENGTH),
    MAGICIANS_STAFF("Magician's Staff", 8, 6, Stats.DEXTERITY),
    DUAL_DAGGERS("Dual Daggers", 6, 6, Stats.DEXTERITY),
    WARDEN_SPEAR("Warden's Spear", 12, 10, Stats.DEXTERITY);

    private final String name;
    private final int primaryDamage;
    private final int secondaryDamage;
    private final Stats scalingStat;

    WeaponType(String name, int primary, int secondary, Stats scalingStat) {
        this.name = name;
        this.primaryDamage = primary;
        this.secondaryDamage = secondary;
        this.scalingStat = scalingStat;
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
}
