package main.java.com.marmotti.gameoflife.View;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Vector;

public class DishView {

    public void showEntry1() {System.out.println("Welcome to game of life!\n" + "First of all set the dimension of your dish: ");}
    public void showEntry2() {System.out.println("Now give me your seed. It is a number which I will use to generate the dish: ");}
    public void showPrepareStart() {System.out.println("Press Enter to start the simulation!");}
    public void showGeneration(int generation) {System.out.println("Generation: " + generation);}
    public void showAlive(int alive) {System.out.println("Alive: " + alive);}

    public void showStats(int iteration, int aliveCells){
        System.out.println();
    }

    private void printMatrix(Vector<Vector<Boolean>> matrix, int dimension) {
        drawHorizontalLine(dimension);
        //Print Dish
        for (int i = 0; i < dimension; i++) {
            Vector<Boolean> r = matrix.get(i);
            System.out.print("|");
            for (int j = 0; j < dimension; j++) {
                System.out.print((r.get(j) ? "0" : " "));
            }
            System.out.println("|");
        }
        drawHorizontalLine(dimension);
    }

    private void clearScreenRobot(){
        try {
            Robot bot = new Robot();
            bot.mouseMove(63, 780);
            bot.mousePress(InputEvent.BUTTON1_MASK);
            Thread.sleep(1000);
            bot.mouseRelease(InputEvent.BUTTON1_MASK);
        }
        catch (Exception ignored){}
    }

    private void shoveScreen(int dimension){
        try {
            Thread.sleep(1000);
            for(int i=0;i<dimension;i++){
                System.out.println();
            }
        }
        catch (Exception ignored){}
    }

    private void drawHorizontalLine(int dimension){
        System.out.print("+");
        for(int i = 0; i<dimension; i++){
            System.out.print("-");
        }
        System.out.println("+");
    }

    public void drawAnimation(Vector<Vector<Boolean>> matrix, int dimension){
//        clearScreenRobot();
        printMatrix(matrix, dimension);
        shoveScreen(dimension);
    }
}
