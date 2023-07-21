import java.util.Scanner;
import java.io.*;
import java.lang.*;
import java.util.*;
public class CaesarCipher {
    public static int generate_enc_key(int num, int key) {
        return (num+key)%26;
    }
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        char[] loweralphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] upperalphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
        String new_word = "";
        int num,enc_key;
        System.out.print("Enter a key: ");
        int key = scan.nextInt();
        scan.nextLine();
        if (1<=key && key<=25){
            System.out.print("Enter a word: ");
            String word = scan.nextLine();
            for(char w: word.toCharArray()) {
                if (Character.isUpperCase(w)) {
                    for(int i = 0; i < upperalphabet.length; i++) {
                        if(upperalphabet[i] == w) {
                            num = i;
                            enc_key = generate_enc_key(num, key);
                            new_word = new_word + upperalphabet[enc_key];
                        }
                    }
                }
                else {
                    for(int i = 0; i < loweralphabet.length; i++) {
                        if(loweralphabet[i] == w) {
                            num = i;
                            enc_key = generate_enc_key(num,key);
                            new_word = new_word + loweralphabet[enc_key];
                        }
                    }
                }
            }
        System.out.println("Encrypted Word: " + new_word);
        }
    }
}
