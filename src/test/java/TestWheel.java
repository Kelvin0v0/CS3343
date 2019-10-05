
import CS3343.game.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestWheel {
    /** sample of unit test */

    @Test
    public void testSpin() {
        Wheel wheel = new Wheel();
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
        Wheel wheel = new Wheel();
        assertEquals(-1,wheel.calcParity(0));
    }

    @Test
    public void testParityEven(){
      Wheel wheel = new Wheel();
      assertEquals(0,wheel.calcParity(36));
    }


    @Test
    public void testParityOdd(){
      Wheel wheel = new Wheel();
      assertEquals(1,wheel.calcParity(17));
    }


    @Test
    public void testParityMatch(){
      Wheel wheel = new Wheel();
      if(wheel.getNum() == 0){
        assertEquals(-1,wheel.getPar());
      }else{
        assertEquals(wheel.getNum()%2,wheel.getPar());
      }
    }
}
