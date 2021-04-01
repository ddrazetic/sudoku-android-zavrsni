package hr.ferit.drazetic.sudokuapp.hr.ferit.drazetic.sudokuapp.view.sudokugrid;


import android.content.Context;
import android.graphics.Color;
import android.widget.Toast;
import hr.ferit.drazetic.sudokuapp.MainActivity;
import hr.ferit.drazetic.sudokuapp.SudokuChecker;

public class GameGrid {

    private SudokuCell[][] Sudoku = new SudokuCell[9][9];
    private Context context;
    public GameGrid( Context context ){
        this.context = context;
        for( int x = 0 ; x < 9 ; x++ ){
            for( int y = 0 ; y < 9 ; y++){
                Sudoku[x][y] = new SudokuCell(context);
            }
        }
    }
    public void setGrid( int[][] grid ){
        for( int x = 0 ; x < 9 ; x++ ){
            for( int y = 0 ; y < 9 ; y++){
                Sudoku[x][y].setInitValue(grid[x][y]);
                if( grid[x][y] != 0 ){
                    Sudoku[x][y].setNotModifiable();
                }
                if( grid[x][y] == 0 ){
                    Sudoku[x][y].setBackgroundColor(Color.rgb(200,245,245));}
                if( grid[x][y] != 0 ){
                    Sudoku[x][y].setBackgroundColor(Color.rgb(150,220,220));
                }
                if((x==4 || x==5 || x==3)){
                    if (y==0 || y==1 || y==2 || y==6 || y==7 || y==8){
                        if( grid[x][y] != 0 ){
                            Sudoku[x][y].setBackgroundColor(Color.rgb(242,173,55));}
                        if( grid[x][y] == 0 ){
                            Sudoku[x][y].setBackgroundColor(Color.rgb(243,221,184));
                        }
                    }
                }
                else if ((y==4 || y==5 || y==3)){
                    if (x==0 || x==1 || x==2 || x==6 || x==7 || x==8){
                        if( grid[x][y] != 0 ){
                            Sudoku[x][y].setBackgroundColor(Color.rgb(242,173,55));}
                        if( grid[x][y] == 0 ){
                            Sudoku[x][y].setBackgroundColor(Color.rgb(243,221,184));
                        }
                    }
                }

            }
        }
    }
    public void setGridSolved( int[][] grid ){
        for( int x = 0 ; x < 9 ; x++ ){
            for( int y = 0 ; y < 9 ; y++){
                if( grid[x][y] != 0 ){
                    Sudoku[x][y].setNotModifiable();
                    Sudoku[x][y].setBackgroundColor(Color.rgb(135,135,135));
                }
            }
        }
    }
    public SudokuCell[][] getGrid(){
        return Sudoku;
    }
    public SudokuCell getItem(int x , int y ){
        return Sudoku[x][y];
    }
    public SudokuCell getItem( int position ){
        int x = position % 9;
        int y = position / 9;
        return Sudoku[x][y];
    }
    public void setItem( int x , int y , int number ){
        Sudoku[x][y].setValue(number);
    }
    public void checkGame(){
        int [][] sudGrid = new int[9][9];
        for( int x = 0 ; x < 9 ; x++ ){
            for( int y = 0 ; y < 9 ; y++ ){
                sudGrid[x][y] = getItem(x,y).getValue();
            }
        }
        if( SudokuChecker.getInstance().checkSudoku(sudGrid)){
            setGridSolved(sudGrid);
            MainActivity.getmInstanceActivity().solvedSetText();
            Toast.makeText(context, "ČESTITAMO! Vratite se unazad da bi ste ponovno zaigrali.", Toast.LENGTH_SHORT).show();
        }
    }
}
