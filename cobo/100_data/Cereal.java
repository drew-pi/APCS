public class Cereal{
  private String name;
  private String type;
  private int cal;
  private int prot;
  private int fat;
  private int sodium;
  private int fiber;
  private int carb;
  private int sugar;
  private int potas;
  private int vita;
  private int shelf;
  private double weight;
  private int cups;
  private double rating;

  public cereal(){
    //I am not putting everything into the params
    name = "";
    type = "";
    cal = 0;
    prot = 0;
    fat = 0;
    sodium = 0;
    fiber = 0;
    carb = 0;
    sugar = 0;
    potas = 0;
    vita = 0;
    shelf = 0;
    weight = 0.0;
    cups = 0;
    rating = 0.0;

  }

  public String name(){
    return name;
  }

  public String type(){
    return type;
  }

  public int cal(){
    return cal;
  }
  public int prot(){
    return prot;
  }
  public int fat(){
    return fat;
  }
  public int sodium(){
    return sodium;
  }
  public int fiber(){
    return fiber;
  }
  public int carb(){
    return carb;
  }
  public int sugar(){
    return sugar;
  }
  public int potas(){
    return potas;
  }
  public int vita(){
    return vita;
  }
  public int shelf(){
    return shelf;
  }
  public int cups(){
    return cups;
  }

  public double weight(){
    return weight;
  }
  public double rating(){
    return rating;
  }
  public String toString(){
    String ret = "";
    //ret = "name = " + name + '\ntype = ' + type + '\ncal = ' + cal + '\nprot = ' + prot + '\nfat = '+ fat +'\nsodium = '+ sodium +'\nfiber = '+ fiber +'\ncarb = '+ carb +'\nsugar = '+ sugar +'\npotas = '  + potas+'\nvita = '+ vita+'\nshelf =' + shelf+'\nweight =' + weight+'\ncups =' + cups+'\nrating = '+ rating;
    return ret;


  }

  public static void main(String[] FKNSHI){
    Cereal please = new Cereal();
    System.out.println(please.weight());
    System.out.println(please.sugar());
    System.out.println(please.sodium());
    System.out.println(please.rating());
    System.out.println(cereal);
  }
}
