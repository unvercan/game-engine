package tr.unvercanunlu.game_engine.originator;

import lombok.Data;
import tr.unvercanunlu.game_engine.memento.State;

@Data
public class Player implements Action {

  private String name;
  private int health;
  private int position;
  private int attack;

  @Override
  public void walk() {
    position++;

    System.out.println(
        String.format("'%s' walked: position=%d".formatted(name, position))
    );
  }

  @Override
  public void run() {
    position += 3;

    System.out.println(
        String.format("'%s' run: position=%d".formatted(name, position))
    );
  }

  @Override
  public void attack() {
    System.out.println(
        String.format("'%s' attacked".formatted(name))
    );
  }

  @Override
  public void takeDamage(int damage) {
    health -= damage;

    System.out.println(
        String.format("'%s' took %d damage: health=%d".formatted(name, damage, health))
    );
  }

  @Override
  public void restore(State state) {
    health = state.health();
    position = state.position();

    System.out.println(
        String.format("State restored: state=%s".formatted(state.toString()))
    );
  }

  @Override
  public State takeState() {
    State state = new State(health, position);

    System.out.println(
        String.format("State prepared: state=%s".formatted(state.toString()))
    );

    return state;
  }

}
