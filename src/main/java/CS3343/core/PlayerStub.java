package CS3343.core;

//this is just until Anthony makes a real One

public class PlayerStub extends Player{
  public int getBalance(){
    return 500;
  }

  public void win(int n){
    System.out.println("Won " + n);
    return;
  }

  public void lose(int n){
    System.out.println("Lost " + n);
    return;
  }

}
