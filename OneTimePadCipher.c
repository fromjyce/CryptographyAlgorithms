// Improvedment of Vernam Cipher
#include <stdio.h>
#include <string.h>
#include <ctype.h>

int main() {
    int num;
    char alphabets[26], plain_text[100], random_key[100];
    printf("Enter a plain text: ");
    scanf("%s", plain_text);
    printf("Enter a random key: ");
    scanf("%s", random_key);
    int length = strlen(plain_text);
    int plain_text_arr[length];
    int random_key_arr[length];
    int new_word_arr[length];
    char new_word[100] = "";
    for (int j = 0; j < 26; j++) {
        alphabets[j] = (char) tolower('A' + j);
    }

    if (strlen(plain_text) == strlen(random_key)) {
        for (int i = 0; i < strlen(plain_text); i++) {
            for (int k = 0; k < 26; k++) {
                if (plain_text[i] == alphabets[k]) {
                    plain_text_arr[i] = k;
                }
            }
        }
        for (int i = 0; i < strlen(random_key); i++) {
            for (int k = 0; k < 26; k++) {
                if (random_key[i] == alphabets[k]) {
                    random_key_arr[i] = k;
                }
            }
        }
        for (int i=0; i<length; i++) {
            if (random_key_arr[i]+plain_text_arr[i]<26)
                {
                    new_word_arr[i] = random_key_arr[i]+plain_text_arr[i];
                }
            else
                {
                    new_word_arr[i] = (random_key_arr[i]+plain_text_arr[i])-26;
                }
        }
        for (int i=0; i<length; i++)
            {
                strncat(new_word,&alphabets[new_word_arr[i]], 1);
            }
        printf("Encrypted Word: %s", new_word);
    }
    
    return 0;
}
