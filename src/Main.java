import java.util.Scanner;
public class Main {
    private static Card [][] cards = new Card[4][4];


    public static void main(String[] args) {




        cards[0][0] = new Card('E');
        cards[0][1] = new Card('A');
        cards[0][2] = new Card('B');
        cards[0][3] = new Card('F');
        cards[1][0] = new Card('G');
        cards[1][1] = new Card('A');
        cards[1][2] = new Card('D');
        cards[1][3] = new Card('H');
        cards[2][0] = new Card('F');
        cards[2][1] = new Card('C');
        cards[2][2] = new Card('D');
        cards[2][3] = new Card('H');
        cards[3][0] = new Card('E');
        cards[3][1] = new Card('G');
        cards[3][2] = new Card('B');
        cards[3][3] = new Card('C');

        while (isGameFinished() == false){
            GameBoard();
            makePrediction();

        }
        System.out.println("Congratulations! You have successfully completed the game.");





    }
    public static void makePrediction(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("First Prediction (Enter values for i and j with a space in between.) : ");
        int i1 = scanner.nextInt();
        int j1 = scanner.nextInt();
        cards[i1][j1].setPrediction(true);
        GameBoard();

        System.out.print("Second Prediction (Enter values for i and j with a space in between.) : ");
        int i2 = scanner.nextInt();
        int j2 = scanner.nextInt();

        if (cards[i1][j1].getValue() == cards[i2][j2].getValue()){
            System.out.println("Congrulations True Prediction...");
            cards[i2][j2].setPrediction(true);
        }
        else {
            System.out.println("False Prediction...");
            cards[i1][j1].setPrediction(false);
        }


    }
    public static boolean isGameFinished(){
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                if(cards[i][j].isPrediction() == false){
                    return false;
                }
            }

        }
        return true;
    }
    public static void GameBoard() {
        for (int i = 0; i < 4; i++) {
            System.out.println("____________________");
            for (int j = 0; j < 4; j++) {
                if (cards[i][j].isPrediction()) {
                    System.out.print(" |" + cards[i][j].getValue() + " |");
                } else {
                    System.out.print(" | | ");
                }
            }
            System.out.println("");
        }
        System.out.println("____________________");
    }
}
