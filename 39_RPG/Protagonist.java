


public class Protagonist {

  String protagName;
  int health = 100;
  int damageLevel = 0;
  boolean moveNormalize = true;

  public Protagonist (String name) {
    protagName = name;
  }

  public String getName() {
    return protagName;
  }

  public boolean isAlive() {
    return health > 0;
  }

  public void specialize() {
    damageLevel = (int) ((Math.random()*50)+50);
    moveNormalize = false;
  }

  public void normalize() {
    damageLevel = (int) ((Math.random()*26)+5);
    moveNormalize = true;
  }

  public int attack (Monster m) {
    m.health = m.health - damageLevel;
    return damageLevel;
  }
}
