

public class Monster {

  int health = 100;
  int damageLevel = 0;

  public boolean isAlive() {
    return health > 0;
  }

  public int attack (Protagonist p) {

    if (p.moveNormalize) {
      damageLevel = (int) ((Math.random()*26)+5);
      p.health = p.health - damageLevel;
    }
    else {
      damageLevel = (int) ((Math.random()*50)+50);
      p.health = p.health - damageLevel;
    }
    return damageLevel;
  }
}
