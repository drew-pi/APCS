


public class Protagonist {

  String protagName;
  int health = 100;
  int damageLevel = 0;

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

  }

  public void normalize() {
    damageLevel = (int) (Math.random()*26);
  }

  public int attack (Monster m) {
    m.health = m.health - damageLevel;
    return damageLevel;
  }
}
