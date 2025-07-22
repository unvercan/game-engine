package tr.unvercanunlu.game_engine.care_taker.impl;

import tr.unvercanunlu.game_engine.care_taker.Manager;
import tr.unvercanunlu.game_engine.memento.State;
import tr.unvercanunlu.game_engine.originator.Player;

public class SaveSlotManagerImpl implements Manager {

  private State savedState;

  @Override
  public void save(Player player) {
    savedState = player.takeState();
  }

  @Override
  public void load(Player player) {
    if (savedState == null) {
      System.out.println("No saved game found!");

      return;
    }

    player.restore(savedState);
  }

}
