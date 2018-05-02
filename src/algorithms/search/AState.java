package algorithms.search;

import java.util.ArrayList;
import java.util.Objects;

public abstract class AState implements Comparable{

    protected double cost;
    protected AState parent;

    public AState(double cost){
        this.cost = cost;
        this.parent = null;
    }

    public double getCost() {
        return cost;
    }

    public AState getParent() {
        return parent;
    }


    /**
     * uses the cost value to compare two states.
     * @param other - the AState to compare to
     * @return - 0:= both objects are of equal cost. positive integer:= this.cost > other.cost
     *          negative integer:= this.cost < other.cost
     * @throws NullPointerException - if the specified object is null
     * @throws ClassCastException - if the specified object's type prevents it from being compared to this object.
     */
    @Override
    public int compareTo(Object other) {
        if (other == null) throw new NullPointerException();
        if(!(other instanceof AState)) throw new ClassCastException();

        if(this.cost == ((AState)other).cost) return 0;
        else return this.cost > ((AState)other).cost ? 1 : -1 ;
    }

    @Override
    public abstract boolean equals(Object otherState);

    @Override
    public abstract int hashCode() ;

    @Override
    public abstract String toString() ;
}
