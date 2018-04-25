package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.util.ArrayList;
import java.util.Objects;

public class MazeState extends AState{

    private Position position;

    public MazeState(double heuristicDistance, Position position) {
        super(heuristicDistance);
        this.position = new Position(position);
    }

    public MazeState(double heuristicDistance, ArrayList<AState> successors, Position position) {
        super(heuristicDistance, successors);
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
        return Objects.hashCode(position);
    }

    @Override
    public String toString() {
        return position.toString();
    }
}