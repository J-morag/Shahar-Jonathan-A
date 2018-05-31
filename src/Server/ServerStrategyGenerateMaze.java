package Server;

import IO.MyCompressorOutputStream;
import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;

import java.io.*;

public class ServerStrategyGenerateMaze implements IServerStrategy {

    @Override
    public void applyStrategy(InputStream inputStream, OutputStream outputStream) {
        try {
            ObjectInputStream fromClient = new ObjectInputStream(inputStream);
            ObjectOutputStream toClient = new ObjectOutputStream(outputStream);
            toClient.flush();

            int[] arrFromClient = (int[])(fromClient.readObject());
            int rows = (arrFromClient)[0];
            int columns = (arrFromClient)[1];
            IMazeGenerator mazeGenerator = new MyMazeGenerator();
            Maze maze = mazeGenerator.generate(rows,columns);
            byte[] mazeByteArr = maze.toByteArray();
            MyCompressorOutputStream compressor = new MyCompressorOutputStream(toClient);
            try{
                compressor.write(mazeByteArr);
                compressor.flush();
                compressor.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }




}
