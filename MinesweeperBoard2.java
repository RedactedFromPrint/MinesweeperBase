
/**
 * Write a description of class Minesweeper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MinesweeperBoard2{
    Cell[] board;
    int rows;
    int columns;
    public MinesweeperBoard2(int row, int column){
        //Put the constructor here.
        this.rows = row;
        this.columns = column;
        board = new Cell[rows*columns];
        
        //These pieces are for the GUI.
        JFrame frame = new JFrame();
        frame.add(addCells());
        
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public MinesweeperBoard2(){
        this(10,10);
    }
    
    public void addBombs(int bombs) { //throws Exception{
       for (int i = 0; i < bombs; i++){
           boolean placed = false;
           while (!placed){
               int index = (int) (Math.random() * (rows*columns));
               if (board[index].getValue() == 0){
                   board[index].setBomb();
                   placed = true;
                }
            }
        }
    }

    public void addNums(){
        
    }
    
    /**This method is used for testing and will be deleted if using the GUI.
     *  It is still required for all students.
     */
    public void printBoard(){
        int index = 0;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                if (board[index].getValue() == -1){
                    System.out.print("X ");
                } else {
                    System.out.print(board[index].getValue() + " ");
                }
                index++;
            }
            System.out.println();
        }
    }
    public JPanel addCells(){
        JPanel panel = new JPanel(new GridLayout(rows,columns));
        for(int i = 0; i< rows*columns; i++){
                board[i]= new Cell();
                panel.add(board[i].getButton());
        }
        return panel;
    }

}
