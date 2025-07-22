package tr.unvercanunlu.game_engine.originator;

import tr.unvercanunlu.game_engine.memento.State;

public interface Action {

  void walk();

  void run();

  void attack();

  void takeDamage(int damage);

  void restore(State state);

  State takeState();

}
