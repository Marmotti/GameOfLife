package main.java.com.marmotti.gameoflife;

import main.java.com.marmotti.gameoflife.Engine.DishModel;
import main.java.com.marmotti.gameoflife.View.DishView;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seed = scanner.nextInt();
        int dimension = scanner.nextInt();

        DishView dishView = new DishView();
        DishModel dishModel = new DishModel();
        Vector<Vector<Boolean>> matrix = dishModel.generateMatrix(seed, dimension);

        dishView.printMatrix(matrix, dimension);

        matrix = dishModel.newGeneration(matrix, dimension);

        System.out.println("\n\n");
        dishView.printMatrix(matrix, dimension);
    }
}