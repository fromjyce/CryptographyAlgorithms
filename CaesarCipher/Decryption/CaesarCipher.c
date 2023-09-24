#include <stdio.h>
#include <ctype.h>
#include <string.h>
int generate_dec_key(int num,int key)
    {
        return (num-key)%26;
    }
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
    int key,j,num,dec_key;
    char word[100], new_word[100] = "";
    printf("Enter the key: ");
    scanf("%d", &key);
    char alphabets[26];
    for (j = 0; j < 26; j++)
        {
            alphabets[j] = (char)toupper('A' + j);
        }
    if (1<=key && key<=25)
        {
            printf("Enter the Cipher Text: ");
            scanf("%s", word);
            removeSpaces(word);
            for (int i=0; i<strlen(word); i++)
                {
                    for (j = 0; j < 26; j++) {
                        if (toupper(word[i])==alphabets[j])
                            {
                                num = j;
                                dec_key = generate_dec_key(num,key);
                                strncat(new_word,&alphabets[dec_key], 1);
                            }
                    }
                }

            printf("Plain Text: %s", new_word);
        }
    return 0;
}
