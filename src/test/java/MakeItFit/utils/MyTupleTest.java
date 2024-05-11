package MakeItFit.utils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The tests for the EmailValidator class.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */
public class MyTupleTest {

        /**
        * Tests the MyTuple essential methods.
        */
        @Test
        public void testMyTuple() {
            MyTuple<Integer, String> tuple = new MyTuple<>(1, "test");
            assertNotNull(tuple);
            assertEquals(tuple.getItem1(), 1);
            assertEquals(tuple.getItem2(), "test");
            assertEquals(tuple.toString(), "(1, test)");
        }

        /**
        * Tests the MyTuple essential methods.
        */
        @Test
        public void testEquals(){
            MyTuple<Integer, String> tuple1 = new MyTuple<>(1, "test");
            MyTuple<Integer, String> tuple2 = new MyTuple<>(1, "test");
            MyTuple<Integer, String> tuple3 = new MyTuple<>(2, "test");
            MyTuple<Integer, String> tuple4 = new MyTuple<>(1, "test2");
            MyTuple<Integer, String> tuple5 = new MyTuple<>(2, "test2");
            MyTuple<Integer, String> tuple6 = new MyTuple<>(1, "test");
            assertEquals(tuple1, tuple2);
            assertNotEquals(tuple1, tuple3);
            assertNotEquals(tuple1, tuple4);
            assertNotEquals(tuple1, tuple5);
            assertEquals(tuple1, tuple6);
        }

        /**
        * Tests the MyTuple essential methods.
        */
        @Test
        public void testGetItem1(){
            MyTuple<Integer, String> tuple = new MyTuple<>(1, "test");
            assertEquals(tuple.getItem1(), 1);
        }

    /**
     * Tests the MyTuple essential methods.
     */
    @Test
    public void testGetItem2(){
        MyTuple<Integer, String> tuple = new MyTuple<>(1, "test");
        assertEquals(tuple.getItem2(), "test");
    }
}
