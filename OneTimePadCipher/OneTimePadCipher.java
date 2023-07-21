import java.util.Scanner;

public class OneTimePadCipher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String new_word = "";
        int[] random_text_index = new int[0];
        int[] plain_text_index = new int[0];
        int[] new_word_index = new int[0];
        char[] alphabets = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        System.out.print("Enter the plain text: ");
        String plain_text = scan.nextLine();
        System.out.print("Enter the random text: ");
        String random_text = scan.nextLine();
        if (plain_text.length()==random_text.length()) {
            for(char c: plain_text.toCharArray()) {
                for(int i =0; i<alphabets.length; i++) {
                    if(alphabets[i]==c) {
                        plain_text_index = AddElement(i, plain_text_index);
                    }
                }
            }
            for(char c: random_text.toCharArray()) {
                for(int i =0; i<alphabets.length; i++) {
                    if(alphabets[i]==c) {
                        random_text_index = AddElement(i, random_text_index);
                    }
                }
            }
            for(int i=0; i<random_text.length(); i++) {
                if(random_text_index[i]+plain_text_index[i]<26)
                    {
                        int newnum = random_text_index[i]+plain_text_index[i];
                        new_word_index = AddElement(newnum, new_word_index);
                    }
                else {
                        int new_num = (random_text_index[i]+plain_text_index[i])-26;
                        new_word_index = AddElement(new_num, new_word_index);
                }
            }
            for (int m: new_word_index){
                new_word = new_word + alphabets[m];
            }
            System.out.println("Encrypted Word: " + new_word);
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
