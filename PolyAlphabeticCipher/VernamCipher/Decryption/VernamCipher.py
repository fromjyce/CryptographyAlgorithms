import string



alphabets = list(string.ascii_lowercase)
random_key_index = []
cipher_text_index = []
plain_text_index = []
plain_text = []
cipher_text = input("Enter the ciphertext: ").lower()
random_key = input("Enter a random key: ").lower()
if len(cipher_text) == len(random_key):
    for j in random_key:
        if j in alphabets:
            random_key_index.append(alphabets.index(j))
    for j in cipher_text:
        if j in alphabets:
            cipher_text_index.append(alphabets.index(j))
    for i, j in zip(random_key_index, cipher_text_index):
        plain_text_index.append((i ^ j))
    for j in plain_text_index:
        plain_text.append(alphabets[j])
    print("Encrypted Word: " + "".join(plain_text).upper())
