// Improvement of Vernam Cipher
#include <stdio.h>
#include <string.h>
#include <ctype.h>

void removeSpaces(char *str) {
    char *dest = str;
    char *src = str;
    
    while (*src != '\0') {
        if (!isspace(*src)) {
            *dest = *src;
            dest++;
        }
        src++;
    }
    
    *dest = '\0';
}

int main() {
    int num;
    char alphabets[26], cipher_text[100], random_key[100];
    printf("Enter a cipher text: ");
    scanf(" %[^\n]", cipher_text);
    printf("Enter a random key: ");
    scanf(" %[^\n]", random_key);
    removeSpaces(cipher_text);
    removeSpaces(random_key);
    int length = strlen(cipher_text);
    int cipher_text_arr[length];
    int random_key_arr[length];
    int plain_text_arr[length];
    char plain_text[100] = "";
    for (int j = 0; j < 26; j++) {
        alphabets[j] = (char)toupper('A' + j);
    }
    if (strlen(cipher_text) == strlen(random_key)) {
        for (int i = 0; i < strlen(cipher_text); i++) {
            for (int k = 0; k < 26; k++) {
                if (toupper(cipher_text[i]) == alphabets[k]) {
                    cipher_text_arr[i] = k;
                }
            }
        }
        for (int i = 0; i < strlen(random_key); i++) {
            for (int k = 0; k < 26; k++) {
                if (toupper(random_key[i]) == alphabets[k]) {
                    random_key_arr[i] = k;
                }
            }
        }
        for (int i=0; i<length; i++) {
            plain_text_arr[i] = (random_key_arr[i]^cipher_text_arr[i])%26;   
        }
        for (int i = 0; i < length; i++) {
            plain_text[i] = alphabets[plain_text_arr[i]];
            }
        printf("Encrypted Word: %s", plain_text);
    }
    
    return 0;
}
