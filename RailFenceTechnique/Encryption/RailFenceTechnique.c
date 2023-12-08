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

int main() {
    char plain_text[1000];

    printf("Enter a plain text: ");
    fgets(plain_text, sizeof(plain_text), stdin);
    removeSpacesAndNewline(plain_text);

    int length = strlen(plain_text);
    int even_length = (length + 1) / 2;
    int odd_length = length / 2 + 1;

    char even_text[even_length + 1]; 
    char odd_text[odd_length + 1]; 

    for (int i = 0; i < length; i++) {
        if (i % 2 == 0) {
            even_text[i / 2] = plain_text[i];
        }
        else {
            odd_text[i / 2] = plain_text[i];
        }
    }
    even_text[even_length] = '\0'; 
    odd_text[odd_length] = '\0'; 

    appendCharArray(even_text, odd_text);

    printf("Encrypted Text: %s\n", even_text);

    return 0;
}
