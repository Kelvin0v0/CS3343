
import CS3343.game.*;
import CS3343.game.Roulette.*;
import org.junit.jupiter.api.Test;
import org.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestWheel {

    private Wheel wheel;
    /*
    @Before
    public void init(){
      wheel = Wheel.getWheel();
    }
    */
    @Test
    public void testSpin() {
        Wheel wheel = Wheel.getWheel();
        boolean flag = true;
        int num;
        for(int i = 0;i<100;i++){
          wheel.spin();
          num = wheel.getNum();
          if (num<0 || num >36){
            flag = false;
            break;
          }
        }
        assertEquals(true, flag);
    }

    @Test
    public void testParityZero() {
        Wheel wheel = Wheel.getWheel();
        assertEquals(-1,wheel.calcParity(0));
    }

    @Test
    public void testParityEven(){
      Wheel wheel = Wheel.getWheel();
      assertEquals(0,wheel.calcParity(36));
    }


    @Test
    public void testParityOdd(){
      Wheel wheel = Wheel.getWheel();
      assertEquals(1,wheel.calcParity(17));
    }


    @Test
    public void testParityMatchEven(){
      Wheel wheel = Wheel.getWheel();
      wheel.setWheel(2);
      assertEquals(0,wheel.getPar());  
    }

    @Test
    public void testParityMatchOdd(){
      Wheel wheel = Wheel.getWheel();
      wheel.setWheel(3);
      assertEquals(1,wheel.getPar());  
    }

    @Test
    public void testParityMatchZero(){
      Wheel wheel = Wheel.getWheel();
      wheel.setWheel(0);
      assertEquals(-1,wheel.getPar());  
    }
    
}
