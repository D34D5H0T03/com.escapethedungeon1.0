package Model.Entities;

public interface Combatant {
    String getName();
    int getArmourClass();
    int getHp();
    int getMaxHP();
    void setHp(int hp);
    int getMp();
    int getMaxMP();
    void setMp(int mp);
    int getAccuracy();
    int getInitiativeBonus();
    boolean isAlive();
    void applyDamage(int amount);
    void applyHealing(int amount);
}
