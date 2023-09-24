import string


def return_dec_key(i: str, lst: list[str], key: int) -> int:
    return (lst.index(i) - key) % 26


def main():
    alphabets = list(string.ascii_uppercase)
    newword = []
    key = int(input("Enter the Key: "))
    if 1 <= key <= 25:
        word = input("Enter the Cipher Text: ").upper()
        for i in word:
            if i  in alphabets:
                dec_key = return_dec_key(i, alphabets, key)
                newword.append(alphabets[dec_key])
        print("Plaintext: " + "".join(newword))
    else:
        print("Enter a valid key")


main()
