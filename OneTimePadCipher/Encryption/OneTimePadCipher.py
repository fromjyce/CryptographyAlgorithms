# Improvedment of Vernam Cipher
import string

alphabets = list(string.ascii_lowercase)
random_key_index = []
plain_text_index = []
new_word_index = []
new_word = []
plain_text = input("Enter the plaintext: ").lower()
random_key = input("Enter a random key: ").lower()
if len(plain_text) == len(random_key):
    for j in random_key:
        if j in alphabets:
            random_key_index.append(alphabets.index(j))
    for j in plain_text:
        if j in alphabets:
            plain_text_index.append(alphabets.index(j))
    for i, j in zip(random_key_index, plain_text_index):
        new_word_index.append((i+j)%26)
    for j in new_word_index:
        new_word.append(alphabets[j])
    print("Encrypted Word: " + "".join(new_word).upper())
else:
    print("Invalid Key")
