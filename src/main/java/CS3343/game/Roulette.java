package CS3343.game;

public class Roulette implements Game{
  public void intro(){
    System.out.println("Intro run in Roulette");
  }

  public void gamePlay(){
    Wheel wheel = Wheel.getWheel();
    System.out.println(wheel.getNum());
    System.out.println(wheel.getPar());
  }
}
