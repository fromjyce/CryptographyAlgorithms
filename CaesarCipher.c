#include <stdio.h>
#include <ctype.h>
#include <string.h>
int generate_enc_key(int num,int key)
    {
        return (num+key)%26;
    }
int main() {
    int key,j,num,enc_key;
    char word[100], new_word[100] = "";
    printf("Enter the key: ");
    scanf("%d", &key);
    char loweralphabets[26];
    char upperalphabets[26];
    for (j = 0; j < 26; j++)
        {
            upperalphabets[j] = (char)toupper('A' + j);
            loweralphabets[j] = (char)tolower('A' + j);
        }
   /* for (j = 0; j < 26; j++) {
    printf("%c ", upperalphabets[j]);
    printf("%c ", loweralphabets[j]);
  } */
    if (1<=key && key<=25)
        {
            printf("Enter the word: ");
            scanf("%s", word);
            for (int i=0; i<strlen(word); i++)
                {
                    for (j = 0; j < 26; j++) {
                        if (isupper(word[i]) && word[i]==upperalphabets[j])
                            {
                                num = j;
                                enc_key = generate_enc_key(num,key);
                                strncat(new_word,&upperalphabets[enc_key], 1);
                            }
                        else if (islower(word[i]) && word[i]==loweralphabets[j]){
                            num = j;
                            enc_key = generate_enc_key(num,key);
                            strncat(new_word,&loweralphabets[enc_key], 1);
                        }
                    }
                }

            printf("Encrypted Word: %s", new_word);
        }
    return 0;
}