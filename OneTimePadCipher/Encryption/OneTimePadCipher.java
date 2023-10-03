import java.util.Scanner;

public class OneTimePadCipher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String new_word = "";
        int[] random_text_index;
        int[] plain_text_index;
        int[] new_word_index;
        char[] alphabets = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
        System.out.print("Enter the plain text: ");
        String plain_text = scan.nextLine().trim().replaceAll(" ", "");
        System.out.print("Enter the random text: ");
        String random_text = scan.nextLine().trim().replaceAll(" ", "");
        if (plain_text.length()==random_text.length()) {
            int length = random_text.length();
            plain_text_index = new int[length];
            random_text_index = new int[length];
            new_word_index = new int[length];

            for(int k = 0; k < length; k++) {
                char c = plain_text.toUpperCase().charAt(k);
                for(int i =0; i<alphabets.length; i++) {
                    if(alphabets[i]==c) {
                        plain_text_index[k] = i;
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
                        new_word_index[i] = (random_text_index[i]+plain_text_index[i])%26;
            }
            for (int m: new_word_index){
                new_word = new_word + alphabets[m];
            }
            System.out.println("Encrypted Word: " + new_word);
        }
        else {
            System.out.print("Invalid Lengths");
        }
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
