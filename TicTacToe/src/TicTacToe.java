import java.util.*;

public class TicTacToe {
    private static char[][] gameBoard = {
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
    };

    private static ArrayList<Integer> playerPositions = new ArrayList<>();
    private static ArrayList<Integer> cpuPositions = new ArrayList<>();
    private static boolean resultFound = false;

    public static void main(String[] args) {
        printGameBoard();
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("enter your placement (1-9)");
            int playerPos = scan.nextInt();
            if (resultFound || playerPositions.size() + cpuPositions.size() == 9)
                break;
            while (playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)) {
                System.out.println("position taken..player enter one more number");
                playerPos = scan.nextInt();
            }
            placePiece(playerPos, "player");
            Random rand = new Random();
            if (resultFound || playerPositions.size() + cpuPositions.size() == 9)
                break;
            int cpuPos = rand.nextInt(9) + 1;
            while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
                System.out.println("position taken..cpu generate one more number");
                cpuPos = rand.nextInt(9) + 1;
            }
            placePiece(cpuPos, "cpu");
            printGameBoard();
            System.out.println(checkWinner());
            if (resultFound || playerPositions.size() + cpuPositions.size() == 9)
                break;
        }
    }

    private static void printGameBoard() {
        for (char[] row : gameBoard) {
            for (char col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    private static void placePiece(int pos, String user) {
        char symbol;
        if (user.equals("player")) {
            symbol = 'X';
            playerPositions.add(pos);
        } else if (user.equals("cpu")) {
            symbol = 'O';
            cpuPositions.add(pos);
        } else
            symbol = ' ';

        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
        }
    }

    private static String checkWinner() {
        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> midRow = Arrays.asList(4, 5, 6);
        List<Integer> botRow = Arrays.asList(7, 8, 9);
        List<Integer> leftCol = Arrays.asList(1, 4, 7);
        List<Integer> midCol = Arrays.asList(2, 5, 8);
        List<Integer> rightCol = Arrays.asList(3, 6, 9);
        List<Integer> cross1 = Arrays.asList(1, 5, 9);
        List<Integer> cross2 = Arrays.asList(3, 5, 7);
        List<List<Integer>> winning = new ArrayList<List<Integer>>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        for (List<Integer> l : winning) {
            if (playerPositions.containsAll(l)) {
                resultFound = true;
                return "Congratulations you won!";
            } else if (cpuPositions.containsAll(l)) {
                resultFound = true;
                return "CPU wins!!";
            } else if (playerPositions.size() + cpuPositions.size() == 9) {
                resultFound = true;
                return "CAT";
            }
        }
        return "";
    }
}