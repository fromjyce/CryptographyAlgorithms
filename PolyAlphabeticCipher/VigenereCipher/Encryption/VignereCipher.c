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

void finalize_random(char plain[], char random[]) {
    int i = strlen(random) % strlen(random);
    char result[100];
    strcpy(result, random);
    while (strlen(plain) > strlen(result)) {
        result[strlen(result)] = random[i];
        result[strlen(result) + 1] = '\0';
        i = (i + 1) % strlen(random);
    }
    strcpy(random, result); // Copy the modified key back to the original 'random' array.
}

int main() {
    char alphabets[26];
    char plain_text[100];
    char random_key[100];

    printf("Enter a plain text: ");
    scanf(" %[^\n]", plain_text);

    printf("Enter a random key: ");
    scanf(" %[^\n]", random_key);

    removeSpaces(plain_text);
    removeSpaces(random_key);
    finalize_random(plain_text, random_key);

    int length = strlen(plain_text);
    int plain_text_arr[length];
    int random_key_arr[length];
    int new_word_arr[length];

    for (int j = 0; j < 26; j++) {
        alphabets[j] = (char)toupper('A' + j);
    }

    for (int i = 0; i < strlen(plain_text); i++) {
        for (int k = 0; k < 26; k++) {
            if (toupper(plain_text[i]) == alphabets[k]) {
                plain_text_arr[i] = k;
                break; // Found the character, no need to continue searching.
            }
        }
    }

    for (int i = 0; i < strlen(random_key); i++) {
        for (int k = 0; k < 26; k++) {
            if (toupper(random_key[i]) == alphabets[k]) {
                random_key_arr[i] = k;
                break; // Found the character, no need to continue searching.
            }
        }
    }

    for (int i = 0; i < length; i++) {
        new_word_arr[i] = (random_key_arr[i] + plain_text_arr[i]) % 26;
    }

    printf("Encrypted Word: ");
    for (int i = 0; i < length; i++) {
        printf("%c", alphabets[new_word_arr[i]]);
    }
    printf("\n");

    return 0;
}
