package main.java.com.marmotti.gameoflife;

import main.java.com.marmotti.gameoflife.Engine.DishModel;
import main.java.com.marmotti.gameoflife.View.DishView;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dimension = scanner.nextInt();
        int seed = scanner.nextInt();
        int numberOfIterations = scanner.nextInt();

        DishView dishView = new DishView();
        DishModel dishModel = new DishModel();
        Vector<Vector<Boolean>> matrix = dishModel.generateMatrix(seed, dimension);

        for (int i=0; i<numberOfIterations; i++){
            matrix = dishModel.newGeneration(matrix, dimension);
        }

        dishView.printMatrix(matrix, dimension);
    }
}