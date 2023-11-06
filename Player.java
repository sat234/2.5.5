/*
 * Activity 2.5.2
 */
import java.util.Scanner; 

public class Player
{
 private String name = ""; 
 private double points;

 // constructor 
 public Player() {
  System.out.println("Enter your name: "); 
  Scanner sc = new Scanner(System.in); 
  String playerName = sc.nextLine(); 

  name = playerName; 
  points = 0; 
  System.out.println("Your name is " + playername); 
 }

 public Player(String userName) {
  name = userName; 
  points = 0; 
 }
 
 // getter 
 public String getName()
 {
   return name;
 }

 public double getPoints()
 {
   return points;
 }
 
 // setter 
 public void setName(String x)
 {
   name = x;
 }
  public void setPoints(double i)
  {
    points+=i;
  }  
    
} 

