package CS3343;

import java.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Main {
    /** sample of unit test*/
    @Test
    public void testAdd() {
        assertEquals(42, 42); //build successful
    }

    public void testAdd() {
        assertEquals(42, 41); //build unsuccessful
    }
}
