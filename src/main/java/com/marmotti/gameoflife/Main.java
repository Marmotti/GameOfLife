package main.java.com.marmotti.gameoflife;

import main.java.com.marmotti.gameoflife.Engine.DishModel;
import main.java.com.marmotti.gameoflife.View.DishView;

import java.util.*;

public class Main {
    
    public static void main(String[] args) {

        //Setup and start
        DishView dishView = new DishView();
        DishModel dishModel = new DishModel();
        Scanner scanner = new Scanner(System.in);
        int seed;
        int dimension;
        int generation = 0;
        int alive;

        dishView.showEntry1();
        dimension = scanner.nextInt();
        dishView.showEntry2();
        seed = scanner.nextInt();
        dishView.showPrepareStart();
        try{
            System.in.read();
        }
        catch (Exception ignored){};

        //Generation
        Vector<Vector<Boolean>> matrix = dishModel.generateMatrix(seed, dimension);
        alive = dishModel.getAliveCells();
        while (true){
            dishView.showGeneration(generation);
            dishView.showAlive(alive);
            dishView.drawAnimation(matrix, dimension);
            matrix = dishModel.newGeneration(matrix, dimension);
            generation++;
            alive = dishModel.getAliveCells();
        }
    }
}