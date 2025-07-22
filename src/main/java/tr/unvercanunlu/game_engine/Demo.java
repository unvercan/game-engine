package tr.unvercanunlu.game_engine;

import tr.unvercanunlu.game_engine.care_taker.Manager;
import tr.unvercanunlu.game_engine.care_taker.impl.CheckpointManagerImpl;
import tr.unvercanunlu.game_engine.care_taker.impl.SaveSlotManagerImpl;
import tr.unvercanunlu.game_engine.originator.Player;

public class Demo {

  public static void main(String[] args) {
    System.out.println("=== Save-Slot Manager Demo ===");

    Player player1 = new Player();

    player1.setName("Can");
    player1.setHealth(100);
    player1.setPosition(0);
    player1.setAttack(10);

    Manager saveSlotManager = new SaveSlotManagerImpl();

    player1.walk();

    player1.takeDamage(20);

    saveSlotManager.save(player1);

    player1.run();

    player1.takeDamage(30);

    System.out.println("Restoring saved state...");

    saveSlotManager.load(player1);

    System.out.println("=== Checkpoint Manager Demo ===");

    Player player2 = new Player();

    player2.setName("Unver");
    player2.setHealth(120);
    player2.setPosition(0);
    player2.setAttack(15);

    Manager checkpointManager = new CheckpointManagerImpl();

    player2.walk();

    checkpointManager.save(player2);

    player2.takeDamage(10);

    checkpointManager.save(player2);

    player2.run();

    player2.takeDamage(50);

    checkpointManager.save(player2);

    System.out.println("Undoing last checkpoint...");
    checkpointManager.load(player2);

    System.out.println("Undoing again...");
    checkpointManager.load(player2);

    System.out.println("Attempting one more undo...");
    checkpointManager.load(player2);

    System.out.println("One more undo...");
    checkpointManager.load(player2);
  }

}
