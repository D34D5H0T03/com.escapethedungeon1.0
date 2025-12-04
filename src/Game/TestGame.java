package Game;

import Game.Combat.CombatEngine;
import Model.Entities.Combatant;
import Model.Entities.Enemy.Enemy;
import Model.Entities.Enemy.EnemyType;
import Model.Entities.Player.Player;
import Model.Entities.Player.PlayerType;
import Model.Entities.Stats;
import Util.Factory;

import java.util.ArrayList;

public class TestGame {
    static void main() {
        Player player = new Player(PlayerType.MAGE, "TestPlayer");
        player.levelUp(Stats.STRENGTH);
        player.levelUp(Stats.CONSTITUTION);
        player.levelUp(Stats.CONSTITUTION);
        player.levelUp(Stats.CONSTITUTION);
        player.levelUp(Stats.CONSTITUTION);
        player.levelUp(Stats.CONSTITUTION);
        player.levelUp(Stats.CONSTITUTION);
        player.levelUp(Stats.CONSTITUTION);
        player.levelUp(Stats.STRENGTH);
        player.levelUp(Stats.STRENGTH);
        player.levelUp(Stats.STRENGTH);
        player.levelUp(Stats.STRENGTH);
        player.levelUp(Stats.STRENGTH);


        Enemy enemy1 = Factory.createEnemy(EnemyType.UNDEAD_GUARD, 4);
        Enemy enemy2 = Factory.createEnemy(EnemyType.SKELETON_SOLDIER, 4);
        Enemy enemy3 = Factory.createEnemy(EnemyType.UNDEAD_GUARD, 5);
        Enemy enemy4 = Factory.createEnemy(EnemyType.SKELETON_SOLDIER, 2);

        ArrayList<Combatant> combatParticipants = new ArrayList<>();
        combatParticipants.add(player);
        combatParticipants.add(enemy1);
        combatParticipants.add(enemy2);
        combatParticipants.add(enemy3);
        combatParticipants.add(enemy4);

        CombatEngine combatEngine = new CombatEngine();
        combatEngine.startCombat(combatParticipants);
    }
}
