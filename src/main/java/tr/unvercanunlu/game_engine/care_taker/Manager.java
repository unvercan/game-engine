package tr.unvercanunlu.game_engine.care_taker;

import tr.unvercanunlu.game_engine.originator.Player;

public interface Manager {

  void save(Player player);

  void load(Player player);

}
