/*
 * Activity 2.5.2
 * Vyas| Sathvik
 *  
 */
import java.util.Scanner;
  
public class PhraseSolver
{
  /* your code here - attributes */
  private Player player1; 
  private Player player2; 
  private Board board; 
  private boolean solved; 

  /* your code here - constructor(s) */ 
  public PhraseSolver() {
    player1 = new Player(); 
    player2 = new Player(); 
    board = new Board(); 
    solved = false; 
  }

  public void play()
  {
    boolean solved = false;
    Player currentPlayer = player1;

    Scanner input = new Scanner(System.in);
    
    boolean correct = true;
    boolean win = false;
    while (!solved) 
    {
      System.out.println(""); 
      System.out.println(currentPlayer.getName()+"'s Turn!"); 
      System.out.println("Enter your guess");
      String guess = input.nextLine(); 
      /* your code here - game logic */
      correct = board.guessLetter(guess); 
      win = board.isSolved(guess);
      if (win == true) {
        if (player1.getPoints()>player2.getPoints()){
        System.out.println("Congradulations, you win "+ player1.getName()+"!");
        System.out.println(player1.getName()+"'s Points: "  + player1.getPoints());
        System.out.println(player2.getName()+"'s Points: "  + player2.getPoints());
        break;
        }
        else if (player2.getPoints()>player1.getPoints()){
        System.out.println("Congradulations, you win "+ player2.getName()+"!");
        System.out.println(player1.getName()+"'s Points: "  + player1.getPoints());
        System.out.println(player2.getName()+"'s Points: "  + player2.getPoints());
        break;
        }
        else {
          System.out.println ("Tie!");
        }
      }
      else{
        if (correct == true) {
          currentPlayer.setPoints(1.0);
        }
      System.out.println("Amount of letters you've guessed: " + board.getSolvedPhrase());
      System.out.println(currentPlayer.getName()+"'s Points: "  + currentPlayer.getPoints());
      }

      if (currentPlayer == player1 && !correct){
        currentPlayer = player2;
        
      }
      else if (!correct){
        currentPlayer = player1;
      }
      
    } 
  }
}
  
