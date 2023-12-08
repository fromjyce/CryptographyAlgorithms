package PolyAlphabeticCipher.VernamCipher.Decryption;

import java.util.*;
public class VernamCipher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String plain_text = "";
        int[] random_text_index;
        int[] cipher_text_index;
        int[] plain_text_index;
        char[] alphabets = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
        System.out.print("Enter the cipher text: ");
        String cipher_text = scan.nextLine().trim().replaceAll(" ", "");
        System.out.print("Enter the random text: ");
        String random_text = scan.nextLine().trim().replaceAll(" ", "");
        if (cipher_text.length()==random_text.length()) {
            int length = random_text.length();
            cipher_text_index = new int[length];
            random_text_index = new int[length];
            plain_text_index = new int[length];

            for(int k = 0; k < length; k++) {
                char c = cipher_text.toUpperCase().charAt(k);
                for(int i =0; i<alphabets.length; i++) {
                    if(alphabets[i]==c) {
                        cipher_text_index[k] = i;
                        break;
                    }
                }
            }
            for(int k = 0; k < length; k++) {
                char c = random_text.toUpperCase().charAt(k);
                for(int i =0; i<alphabets.length; i++) {
                    if(alphabets[i]==c) {
                        random_text_index[k] = i;
                        break;
                    }
                }
            }
            for(int i=0; i<length; i++) {
                        plain_text_index[i] = (random_text_index[i] ^ cipher_text_index[i]);
            }
            for (int m: plain_text_index){
                plain_text = plain_text + alphabets[m];
            }
            System.out.println("Encrypted Word: " + plain_text);
        }
        scan.close();
    }
    public static int[] AddElement(int key, int[] array) {
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = key;
        return newArray;
    }
}
