#include <stdio.h>
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
    char input[100];
    printf("Enter a string with spaces: ");
    fgets(input, sizeof(input), stdin);

    // Remove spaces from the input string
    removeSpaces(input);

    printf("String after removing spaces: %s\n", input);
    return 0;
}
