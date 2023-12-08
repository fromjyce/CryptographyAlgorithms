def railFenceDecryption(cipherText):
    n = len(cipherText)
    half_length = n // 2
    even_chars = cipherText[:half_length]
    odd_chars = cipherText[half_length:]

    decrypted_text = []
    for i in range(half_length):
        decrypted_text.append(even_chars[i])
        decrypted_text.append(odd_chars[i])
    if n % 2 == 1:
        decrypted_text.append(even_chars[-1])

    return "".join(decrypted_text)


cipher_text = input("Enter the encrypted text: ")
decrypted_text = railFenceDecryption(cipher_text)
print("Decrypted Word:", decrypted_text.upper())
