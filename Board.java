import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Board {
    private String solvedPhrase;
    private String phrase;
    private int currentLetterValue;

    public Board() {
        solvedPhrase = "";
        phrase = loadPhrase();
        currentLetterValue = 0;
    }

    public String getPhrase() {
        return phrase;
    }

    public String getSolvedPhrase() {
        return solvedPhrase;
    }

    public void setLetterValue() {
        int randomInt = (int) ((Math.random() * 10) + 1) * 100;
        currentLetterValue = randomInt;
    }

    public boolean isSolved(String guess) {
        if (phrase.equals(guess)) {
            return true;
        }
        return false;
    }

    private String loadPhrase() {
        String tempPhrase = "";

        int numOfLines = 0;
        try {
            Scanner sc = new Scanner(new File("C:\\Users\\P3\\Downloads\\2.5.5-main\\2.5.5-main\\phrases.txt"));
            while (sc.hasNextLine()) {
                tempPhrase = sc.nextLine().trim();
                numOfLines++;
            }
        } catch (IOException e) {
            System.err.println("Error reading or parsing phrases.txt");
            e.printStackTrace();
        }

        int randomInt = (int) ((Math.random() * numOfLines) + 1);

        try {
            int count = 0;
            Scanner sc = new Scanner(new File("C:\\Users\\P3\\Downloads\\2.5.5-main\\2.5.5-main\\phrases.txt"));
            while (sc.hasNextLine()) {
                count++;
                String temp = sc.nextLine().trim();
                if (count == randomInt) {
                    tempPhrase = temp;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading or parsing phrases.txt");
            e.printStackTrace();
        }

        for (int i = 0; i < tempPhrase.length(); i++) {
            if (tempPhrase.substring(i, i + 1).equals(" ")) {
                solvedPhrase += "  ";
            } else {
                solvedPhrase += "_ ";
            }
        }

        return tempPhrase;
    }

    public boolean guessLetter(String guess) {
        boolean foundLetter = false;
        String newSolvedPhrase = "";

        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.substring(i, i + 1).equals(guess)) {
                newSolvedPhrase += guess + " ";
                foundLetter = true;
            } else {
                newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " ";
            }
        }
        solvedPhrase = newSolvedPhrase;
        return foundLetter;
    }
}
