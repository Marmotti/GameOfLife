package main.java.com.marmotti.gameoflife.View;

import java.util.Vector;

public class DishView {

    public void printMatrix(Vector<Vector<Boolean>> matrix, int dimension) {
        for (int i = 0; i < dimension; i++) {
            Vector<Boolean> r = matrix.get(i);
            for (int j = 0; j < dimension; j++) {
                System.out.print((r.get(j) ? "O" : " "));
            }
            System.out.println();
        }
    }

    //TODO 1 Create a beautiful frame

}
