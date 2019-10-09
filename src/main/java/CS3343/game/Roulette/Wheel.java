package CS3343.game.Roulette;
import java.util.Random;

public class Wheel{
  private int num;
  private int par;
  private static Wheel singleWheel = null;
  private final static Random rand = new Random();

  private Wheel(){
    spin();
  }

  public void setWheel(int num){
    if(num>=0 && num<=36){
      this.num = num;
      this.par = calcParity(num);
    }
  }

  public void spin(){
    this.num = rand.nextInt(37);
    this.par = calcParity(this.num);
  }

  public static Wheel getWheel(){
    if (singleWheel == null){
        singleWheel = new Wheel();
    }
    return singleWheel;
  }

  public int calcParity(int num){ //this used to be private but don't know how to test
    return (num==0)? -1: num%2; //even is 0, odd is 1, 0 returns -1
  }

  public int getNum(){
    return this.num;
  }

  public int getPar(){
    return this.par;
  }
}
