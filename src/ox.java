import java.util.Scanner;
import java.util.*;

public class ox {
    private String table [][] = {
            {" " ,"0" ,"1" ,"2"  },
            {"0" ,"-" ,"-" ,"-"  },
            {"1" ,"-" ,"-" ,"-"  },
            {"2" ,"-" ,"-" ,"-"  },
    };
    private String player;
    private int turnCount;
    private int scoreX;
    private int scoreO;
    private int scoreDraw;

    public ox() {
        player = "x";
        turnCount = 0;
        scoreX = 0;
        scoreO = 0;
        scoreDraw = 0;
    }

    public void main(String[] aeiou){

    }


    public String getCurrentPlayer() {

        return player;
    }

    public String getTableString() {
        String result = "";
        for(int row = 0;row < table.length;row++){
            for(int col = 0;col < table.length;col++){
                result += table[row][col];

            }
            result += "\n";
        }
        return result;
    }

    public boolean put(int col, int row) {
        try {
            if (!table[row + 1][col + 1].equals("-")) {
                return false;
            }
            table[row + 1][col + 1] = getCurrentPlayer();
        }catch(ArrayIndexOutOfBoundsException e) {
            return false;
        }
            turnCount++;
        if (checkWin(col,row)){
            if (player.equals("x")){
                scoreX++;
            }else if(player.equals("o")){
                scoreO++;
            }
        }
        if (isDraw()){
            scoreDraw++;
        }
            return true;
        }


    public void switchPlayer() {
        if(player == "x"){
            player = "o";
        }else{
            player = "x";
        }
    }

    public String get(int col, int row) {

        if(col > 2 || col < 0 || row > 2 || row < 0){
            return  null;
        }
        return table[row+1][col+1];
    }

    public boolean checkWin(int col, int row) {
        /* checkColWin */
        boolean colWin = true;
        for (int i = 0; i < 3 ; i++){
            if(!table[i+1][col+1].equals(player)){
                colWin = false;
            }
        }
        if(colWin){
            return true;
        }
        /* checkrowWin */
        boolean rowWin = true;
        for (int i = 0; i < 3 ; i++){
            if(!table[row+1][i+1].equals(player)){
                rowWin = false;
            }
        }
        if(rowWin){
            return true;
        }
        /* checkESWin */
        boolean esWin = true;
        for (int i = 0; i < 3 ; i++){
            if(!table[i+1][i+1].equals(player)){
                esWin = false;
            }
        }
        if(esWin){
            return true;
        }

        /* checkESWin */
        boolean ssWin = true;
        for (int i = 0; i < 3 ; i++){
            if(!table[i+1][3-i].equals(player)){
                ssWin = false;
            }
        }
        if(ssWin){
            return true;
        }

        return  false;
    }

    public void reset() {
        for (int i = 0 ; i < 3 ; i++){
            for (int j = 0 ; j < 3 ; j++){
                table[i+1][j+1] = "-";
            }
        }
        player = "x";
        turnCount = 0;
    }

    public int getTurnCount() {
        return  turnCount;
    }

    public boolean isDraw() {
        if(turnCount < 9){
            return false;
        }

        return true;
    }

    public int getScoreX() {
        return scoreX;
    }

    public int getScoreO() {
        return scoreO;
    }

    public int getScoreDraw() {
        return scoreDraw;
    }
}
