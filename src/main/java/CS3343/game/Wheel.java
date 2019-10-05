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
    this.par = calcParity();
  }

  private int calcParity(){
    return (this.num==0)? -1: this.num%2;
  }

  public int getNum(){
    return this.num;
  }

  public boolean getPar(){
    return this.par;
  }
}
