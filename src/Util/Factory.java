package Util;

import Model.Ability.Castable;
import Model.Ability.Spell.Spell;
import Model.Entities.Boss.HumanoidBoss.HumanoidBoss;
import Model.Entities.Boss.HumanoidBoss.HumanoidBossType;
import Model.Entities.Boss.NonHumanoidBoss.NonHumanoidBoss;
import Model.Entities.Boss.NonHumanoidBoss.NonHumanoidBossType;
import Model.Entities.Enemy.Enemy;
import Model.Entities.Enemy.EnemyType;
import Model.Entities.Player.Player;
import Model.Entities.Player.PlayerType;
import Model.Equipments.Armours.Armour;
import Model.Equipments.Armours.ArmourType;
import Model.Equipments.Weapons.Weapon;
import Model.Equipments.Weapons.WeaponType;
import Model.Item.RestorativeItems.RestorativeItem;
import Model.Item.RestorativeItems.RestorativeItemType;
import Model.Ability.Spell.OffensiveSpell.OffensiveSpell;
import Model.Ability.Spell.OffensiveSpell.OffensiveSpellType;
import Model.Ability.Spell.RestorativeSpell.RestorativeSpell;
import Model.Ability.Spell.RestorativeSpell.RestorativeSpellType;

public class Factory {

    public static Player createPlayer(PlayerType type, String name) {
        return new Player(type, name);
    }

    public static Enemy createEnemy(EnemyType type, int level) {
        return new Enemy(type, level);
    }

    public static Weapon createWeapon(WeaponType type) {
        return new Weapon(type);
    }

    public static Armour createArmour(ArmourType type) {
        return new Armour(type);
    }

    public static RestorativeItem createRestorativeItem(RestorativeItemType type) {
        return new RestorativeItem(type);
    }

    public static OffensiveSpell createOffensiveSpell(OffensiveSpellType type) {
        return new OffensiveSpell(type);
    }

    public static RestorativeSpell createRestorativeSpell(RestorativeSpellType type) {
        return new RestorativeSpell(type);
    }

    public static Spell createSpell(Castable castable) {
        if (castable instanceof OffensiveSpellType offensiveType) {
            return new OffensiveSpell(offensiveType);
        } else if (castable instanceof RestorativeSpellType restorativeType) {
            return new RestorativeSpell(restorativeType);
        }
        return null;
    }

    public static HumanoidBoss createHumanoidBoss(HumanoidBossType type) {
        return new HumanoidBoss(type);
    }

    public static NonHumanoidBoss createNonHumanoidBoss(NonHumanoidBossType type) {
        return new NonHumanoidBoss(type);
    }
}