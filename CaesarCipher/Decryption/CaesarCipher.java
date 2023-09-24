package CaesarCipher.Decryption;
import java.util.Scanner;

public class CaesarCipher {
    public static int generate_dec_key(int num, int key) {
        return (num - key) % 26;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        String new_word = "";
        int num, dec_key;
        System.out.print("Enter a key: ");
        int key = scan.nextInt();
        scan.nextLine();
        if (1 <= key && key <= 25) {
            System.out.print("Enter Cipher Text: ");
            String word = scan.nextLine();
            for (char w : word.toUpperCase().toCharArray()) {
                for (int i = 0; i < alphabet.length; i++) {
                    if (alphabet[i] == w) {
                        num = i;
                        dec_key = generate_dec_key(num, key);
                        new_word = new_word + alphabet[dec_key];
                    }
                }
            }
            System.out.println("Plain Text: " + new_word);
        }
        scan.close();
    }
}
