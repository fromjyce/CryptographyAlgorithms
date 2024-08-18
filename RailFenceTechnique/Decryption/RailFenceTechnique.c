#include <stdio.h>
#include <string.h>

void appendCharArray(char destination[], const char source[]) {
    int destLen = strlen(destination);
    int i;

    for (i = 0; source[i] != '\0'; i++) {
        destination[destLen + i] = source[i];
    }
}

void removeSpacesAndNewline(char* str) {
    int count = 0;
    for (int i = 0; str[i]; i++) {
        if (str[i] != ' ' && str[i] != '\n') {
            str[count++] = str[i];
        }
    }
    str[count] = '\0';
}

void railFenceDecryption(char cipherText[], char decryptedText[]) {
    int length = strlen(cipherText);
    int even_length = (length + 1) / 2;
    int odd_length = length / 2;

    char even_text[even_length + 1]; 
    char odd_text[odd_length + 1]; 

    for (int i = 0; i < even_length; i++) {
        even_text[i] = cipherText[i];
    }
    even_text[even_length] = '\0';

    for (int i = 0; i < odd_length; i++) {
        odd_text[i] = cipherText[even_length + i];
    }
    odd_text[odd_length] = '\0';

    for (int i = 0, j = 0, k = 0; i < length; i++) {
        if (i % 2 == 0) {
            decryptedText[i] = even_text[j++];
        }
        else {
            decryptedText[i] = odd_text[k++];
        }
    }
    decryptedText[length] = '\0';
}

int main() {
    char cipher_text[1000];
    char decrypted_text[1000];

    printf("Enter the encrypted text: ");
    fgets(cipher_text, sizeof(cipher_text), stdin);
    removeSpacesAndNewline(cipher_text);

    railFenceDecryption(cipher_text, decrypted_text);

    printf("Decrypted Text: %s\n", decrypted_text);

    return 0;
}
