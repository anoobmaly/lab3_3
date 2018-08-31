import java.util.Scanner;

public class game {
    private static ox Ox;
    private static Scanner kb = new Scanner(System.in);
    private static int col;
    private static int row;

    public static void main(String[] aeiou){
        Ox = new ox();
        while (true){
            printTable();
            input();
            if (Ox.checkWin(col,row)){
                printTable();
                printWin();
                printScore("x win : " + Ox.getScoreX(), "o win : ", Ox.getScoreO(), "Draw : ", Ox.getScoreDraw());
                Ox.reset();
                continue;
            }
            if(Ox.isDraw()){
                printTable();
                printScore("Draw", "x win : ", Ox.getScoreX(), "o win : ", Ox.getScoreO());
                printDraw("Draw : ", Ox.getScoreDraw());
                Ox.reset();
                continue;
            }
            Ox.switchPlayer();

        }
    }

    private static void printDraw(String s, int scoreDraw) {
        System.out.println(s + scoreDraw);
    }

    private static void printWin() {
        System.out.println(Ox.getCurrentPlayer() + " " + "Win");
    }

    private static void printScore(String s, String s2, int scoreO, String s3, int scoreDraw) {
        System.out.println(s);
        printDraw(s2, scoreO);
        printDraw(s3, scoreDraw);
    }

    private static void input() {
        boolean canPut = true;
        do {
            System.out.print(Ox.getCurrentPlayer() + " Col :");
            col = kb.nextInt();
            System.out.print(Ox.getCurrentPlayer() + " Row :");
            row = kb.nextInt();
            canPut = Ox.put(col, row);
            if (!canPut) {
                System.out.println("Please input number between 0-2");
            }

        } while (!canPut);
    }

    private static void printTable() {
        System.out.print(Ox.getTableString());
    }
}
