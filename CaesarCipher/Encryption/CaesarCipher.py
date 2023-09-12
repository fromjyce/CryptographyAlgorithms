import string


def return_enc_key(i: str, lst: list[str], key: int) -> int:
    return (lst.index(i) + key) % 26


def main():
    alphabets = list(string.ascii_uppercase)
    newword = []
    key = int(input("Enter the Key: "))
    if 1 <= key <= 25:
        word = input("Enter the Word: ")
        for i in word.upper():
            if i  in alphabets:
                enc_key = return_enc_key(i, alphabets, key)
                newword.append(alphabets[enc_key])
        print("Encrypted Word: " + "".join(newword))
    else:
        print("Enter a valid key")


main()
