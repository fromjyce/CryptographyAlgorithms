#include <stdio.h>
#include <string.h>

struct Dictionary {
    char key[30];
    char value[30];
};

int main() {

    struct Dictionary dict[10];

    // Adding values to the dictionary
    strcpy(dict[0].key, "apple");
    strcpy(dict[0].value, "a fruit");
    strcpy(dict[1].key, "car");
    strcpy(dict[1].value, "a vehicle");

    // Retrieving values from the dictionary
    printf("%s is %sn", dict[0].key, dict[0].value);
    printf("%s is %sn", dict[1].key, dict[1].value);

    return 0;

}