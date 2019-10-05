import java.util.Random;

public class Wheel{
  private int num;
  private int par;
  private Random rand;

  public Wheel(){
    this.rand = new Random();
    spin();
  }

  public void spin(){
    this.num = rand.nextInt(37);
    this.par = calcParity(this.num);
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
