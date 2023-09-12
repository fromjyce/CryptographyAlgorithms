import java.util.Scanner;

public class CaesarCipher {
    public static int generate_enc_key(int num, int key) {
        return (num + key) % 26;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        String new_word = "";
        int num, enc_key;
        System.out.print("Enter a key: ");
        int key = scan.nextInt();
        scan.nextLine();
        if (1 <= key && key <= 25) {
            System.out.print("Enter a word: ");
            String word = scan.nextLine();
            for (char w : word.toUpperCase().toCharArray()) {
                for (int i = 0; i < alphabet.length; i++) {
                    if (alphabet[i] == w) {
                        num = i;
                        enc_key = generate_enc_key(num, key);
                        new_word = new_word + alphabet[enc_key];
                    }
                }
            }
            System.out.println("Encrypted Word: " + new_word);
        }
    }
}
