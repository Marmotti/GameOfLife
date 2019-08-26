package main.java.com.marmotti.gameoflife.Engine;

import java.util.Random;
import java.util.Vector;

public class DishModel {

    public Vector<Vector<Boolean>> generateMatrix(int seed, int dimension){
        Random random = new Random(seed);

        Vector<Vector<Boolean>> matrix = new Vector<>();

        for (int i = 0; i < dimension; i++){
            Vector<Boolean> r = new Vector<>();
            for (int j = 0; j < dimension; j++){
                r.add(random.nextBoolean());
            }
            matrix.add(r);
        }
        return matrix;
    }

        //TODO 2 Optimise code
        public Vector<Vector<Boolean>> newGeneration(Vector<Vector<Boolean>> matrix, int dimension){
        //Rule1
        //An alive cell survives if has two or three alive neighbours; otherwise, it dies of boredom (<2) or overpopulation (>3)
        //Rule2
        //An empty cell is reborn if it has exactly 3 neighbors
        Vector<Vector<Boolean>> newMatrix = new Vector<>();
        Vector<Vector<Boolean>> comparisonMatrix;
        Vector<Boolean> r;
        for (int i = 0; i < dimension; i++){
            comparisonMatrix = new Vector<>();
            r = new Vector<>();
            if (i == 0) comparisonMatrix.add(matrix.get(dimension - 1));
            else comparisonMatrix.add(matrix.get(i - 1));
            comparisonMatrix.add(matrix.get(i));
            if (i == dimension - 1) comparisonMatrix.add(matrix.get(0));
            else comparisonMatrix.add(matrix.get(i + 1));
            for (int j = 0; j < dimension; j++){
                int neighbourCount = 0;
                //Left border
                if(j == 0){
                    for (int k=0; k<3; k++){
                        if (comparisonMatrix.get(k).get(dimension-1)) neighbourCount++;
                        if (comparisonMatrix.get(k).get(0)) neighbourCount++;
                        if (comparisonMatrix.get(k).get(1)) neighbourCount++;
                    }
                }
                //Right border
                else if(j == dimension-1){
                    for (int k=0; k<3; k++){
                        if (comparisonMatrix.get(k).get(j-1)) neighbourCount++;
                        if (comparisonMatrix.get(k).get(j)) neighbourCount++;
                        if (comparisonMatrix.get(k).get(0)) neighbourCount++;
                    }
                }
                //Default
                else for (int k=0; k<3; k++){
                        for (int l=0; l<3; l++){
                            if (comparisonMatrix.get(k).get(j-1+l)) neighbourCount++;
                        }
                    }
                //Check if our cell was alive before
                boolean isAlive = comparisonMatrix.get(1).get(j);
                if (isAlive) neighbourCount--;
                //Check if cell died or was reborn
                if(neighbourCount < 2 && isAlive) r.add(false);
                else if (neighbourCount > 3 && isAlive) r.add(false);
                else if (neighbourCount == 3) r.add(true);
                else if (neighbourCount == 2 && isAlive) r.add(true);
                else r.add(false);
            }
            newMatrix.add(r);
        }
        return newMatrix;
    }
}
