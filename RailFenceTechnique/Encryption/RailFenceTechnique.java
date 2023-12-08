
import java.util.*;

public class RailFenceTechnique {

    static String OddEvenSeparation(String plain_text) {
        String new_word = " ";
        for (int i = 0; i < plain_text.length(); i++) {
            if (i%2==0) {
                new_word += plain_text.charAt(i);
            }
        }

        for (int i = 0; i< plain_text.length(); i++) { 
            if (i%2!=0) {
                new_word += plain_text.charAt(i);
            }
        }

        return new_word;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the Plain Text: ");
        String plain_text = scan.nextLine();
        String new_word = " ";
        new_word = OddEvenSeparation(plain_text);
        System.out.println("Encrypted Word: " + new_word);
        scan.close();
    }
}
