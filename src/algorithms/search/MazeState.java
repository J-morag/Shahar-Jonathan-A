package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Represents a state in a maze.
 */
public class MazeState extends AState{

    private Position position;

    public MazeState(double cost, Position position) {
        super(cost);
        this.position = new Position(position);
    }

    @Override
    public boolean equals(Object otherState) {
        return otherState != null &&
                otherState instanceof AState &&
                this.position.equals(((MazeState)otherState).position) ;
    }

    @Override
    public int hashCode() {
        return position.hashCode();
    }

    @Override
    public String toString() {
        return position.toString();
    }

    public Position getPosition() {
        return position;
    }
}
