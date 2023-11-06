import java.util.Scanner;

public class PhraseSolver {
    private Player player1;
    private Player player2;
    private Board board;
    private boolean solved;

    public PhraseSolver() {
        player1 = new Player();
        player2 = new Player();
        board = new Board();
        solved = false;
    }

    public void play() {
        Scanner input = new Scanner(System.in);
        Player currentPlayer = player1;

        while (!solved) {
            System.out.println("\n" + currentPlayer.getName() + "'s Turn!");
            System.out.println("\nEnter your guess: ");
            String guess = input.nextLine();

            boolean correct = board.guessLetter(guess);
            boolean win = board.isSolved(guess);

            if (win || isFullGuess()) {
                determineWinner();
                break;
            } else {
                updatePlayerStats(currentPlayer, correct);
                displayGameStatus(currentPlayer, board.getSolvedPhrase());
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }
        }
    }

    private boolean isFullGuess() {
        String solution = board.getPhrase().replaceAll(" ", "");
        String guessedPhrase = board.getSolvedPhrase().replaceAll(" ", "");
        return guessedPhrase.equals(solution);
    }

    private void determineWinner() {
        if (player1.getPoints() > player2.getPoints()) {
            System.out.println("\nCongratulations, " + player1.getName() + " wins!");
        } else if (player2.getPoints() > player1.getPoints()) {
            System.out.println("\nCongratulations, " + player2.getName() + " wins!");
        } else {
            System.out.println("\nIt's a tie!");
        }
        displayPoints();
        solved = true; // Set the game as solved
    }

    private void updatePlayerStats(Player player, boolean correct) {
        if (correct) {
            player.setPoints(player.getPoints() + 1.0);
        }
    }

    private void displayGameStatus(Player player, String solvedPhrase) {
        System.out.println("\nAmount of letters you've guessed: " + solvedPhrase);
        System.out.println(player.getName() + "'s Points: " + player.getPoints());
    }

    private void displayPoints() {
        System.out.println(player1.getName() + "'s Points: " + player1.getPoints());
        System.out.println(player2.getName() + "'s Points: " + player2.getPoints());
    }
}
