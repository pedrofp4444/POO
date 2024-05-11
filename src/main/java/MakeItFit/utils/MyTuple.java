package MakeItFit.utils;

import java.io.Serializable;

/**
 * The class MyTuple represents a tuple.
 *
 * @param <T1> The first element of the tuple
 * @param <T2> The second element of the tuple
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */
public class MyTuple<T1, T2> implements Serializable, Comparable<MyTuple> {

    private final T1 item1;
    private final T2 item2;

    /**
     * Constructs a new MyTuple with the specified parameters.
     *
     * @param item1 The first element of the tuple
     * @param item2 The second element of the tuple
     */
    public MyTuple(T1 item1, T2 item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    /**
     * Gets the first element of the tuple.
     *
     * @return the first element of the tuple
     */
    public T1 getItem1() {
        return item1;
    }

    /**
     * Gets the second element of the tuple.
     *
     * @return the second element of the tuple
     */
    public T2 getItem2() {
        return item2;
    }

    /**
     * Returns a string representation of the tuple.
     *
     * @return a string representation of the tuple
     */
    @Override
    public String toString() {
        return "(" + item1 + ", " + item2 + ")";
    }

    /**
     * Determines whether this tuple is equal to another object.
     *
     * @param o The object to compare with.
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyTuple<?, ?> tuple = (MyTuple<?, ?>) o;
        if (!item1.equals(tuple.item1)) return false;
        return item2.equals(tuple.item2);
    }

    /**
     * Compares the tuple to another tuple based on each item.
     *
     * @param other the other tuple to compare
     * @return a negative integer, zero, or a positive integer as this tuple is less than, equal to, or greater than the other tuple
     */
    @Override
    public int compareTo(MyTuple other) {
        int compareItem1 = this.item1.toString().compareTo(other.item1.toString());
        if(compareItem1 == 0){
            return this.item2.toString().compareTo(other.item2.toString());
        }
        return compareItem1;
    }

    /**
     * Creates a copy of the current MyTuple instance.
     *
     * @return A new MyTuple instance that is a copy of the current instance.
     */
    @Override
    public MyTuple clone() {
        return new MyTuple(this.item1, this.item2);
    }
}
