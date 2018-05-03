package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.mazeGenerators.Position;
import algorithms.mazeGenerators.SimpleMazeGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JUnitTestingBestFirstSearch {

    SimpleMazeGenerator smg = new SimpleMazeGenerator();
    MyMazeGenerator mmg = new MyMazeGenerator();
    Maze maze = mmg.generate(1000, 1000);
    SearchableMaze searchableMaze = new SearchableMaze(maze);
    BestFirstSearch best = new BestFirstSearch();

    @Test
    void getName() {
        BestFirstSearch best = new BestFirstSearch();
        assertEquals("BestFirstSearch", best.getName());
    }

    @Test
    void getNumberOfNodesEvaluated() {
        BestFirstSearch best = new BestFirstSearch();
        best.solve(searchableMaze);
        assertTrue(best.getNumberOfNodesEvaluated() > 0);
    }

    @Test
    void solveSearchableNull() {
        BestFirstSearch best = new BestFirstSearch();
        ISearchable searchProblem = null;
        assertEquals(null, best.solve(searchProblem));
    }

    @Test
    void NoSolutionInSolve() {
        Maze badMaze = new Maze(new int[][]{
                {1, 0, 0, 1, 1, 0, 0},
                {1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0}}, new Position(0, 1), new Position(3, 5));

        SearchableMaze badSearchableMaze = new SearchableMaze(badMaze);
        assertEquals(null, best.solve(badSearchableMaze));
    }

    @Test
    void solveRunningTime() {
        long time = System.currentTimeMillis();
        best.solve(searchableMaze);
        time = System.currentTimeMillis() - time ;
        assertTrue(time<20000);
    }

//    @Test
//    void sameSolutionLength() {
//        MyMazeGenerator mmg = new MyMazeGenerator();
//        BestFirstSearch best = new BestFirstSearch();
//        BreadthFirstSearch bfs = new BreadthFirstSearch();
//        for (int i = 0; i < 10 ; i++) {
//            Maze maze = mmg.generate(1000, 1000);
//            ISearchable searchProblem = new SearchableMaze(maze);
//            Solution bestSolution = best.solve(searchProblem);
//            Solution bfsSolution = bfs.solve(searchProblem);
//            System.out.println(bestSolution.getSolutionPath().size());
//            System.out.println(bfsSolution.getSolutionPath().size());
//            assertEquals(bestSolution.getSolutionPath().size(), bfsSolution.getSolutionPath().size());
//        }
//    }
}