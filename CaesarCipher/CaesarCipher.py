import string


def return_enc_key(i: str, lst: list[str], key: int) -> int:
    return (lst.index(i) + key) % 26


def main():
    lower_alphabets = list(string.ascii_lowercase)
    higher_alphabets = list(string.ascii_uppercase)
    newword = []
    key = int(input("Enter the Key: "))
    if 1 <= key <= 13:
        word = input("Enter the Word: ")
        if word.isalpha():
            for i in word:
                if i in lower_alphabets:
                    enc_key = return_enc_key(i, lower_alphabets, key)
                    newword.append(lower_alphabets[enc_key])
                elif i in higher_alphabets:
                    enc_key = return_enc_key(i, higher_alphabets, key)
                    newword.append(higher_alphabets[enc_key])
            print("Encrypted Word: " + "".join(newword))
        else:
            print("Enter a valid word")
    else:
        print("Enter a valid key")


main()
