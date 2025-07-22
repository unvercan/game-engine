package tr.unvercanunlu.game_engine.care_taker.impl;

import java.util.Stack;
import tr.unvercanunlu.game_engine.care_taker.Manager;
import tr.unvercanunlu.game_engine.memento.State;
import tr.unvercanunlu.game_engine.originator.Player;

public class CheckpointManagerImpl implements Manager {

  private final Stack<State> checkpoints;

  public CheckpointManagerImpl() {
    checkpoints = new Stack<>();
  }

  @Override
  public void save(Player player) {
    State state = player.takeState();
    checkpoints.push(state);
  }

  @Override
  public void load(Player player) {
    if (checkpoints.isEmpty()) {
      System.out.println("No checkpoint found!");

      return;
    }

    State lastCheckpoint = checkpoints.pop();

    player.restore(lastCheckpoint);
  }

}
