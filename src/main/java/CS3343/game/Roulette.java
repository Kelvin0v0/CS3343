package CS3343.game;

public class Roulette implements Game{
  public void intro(){
    System.out.println("Intro run in Roulette")
  }

  public boolean gamePlay(){
    Wheel wheel = new Wheel();
    System.out.println(wheel.getNum());
    System.out.println(wheel.getPar());
  }

  public void result(){
    return
  }
}
