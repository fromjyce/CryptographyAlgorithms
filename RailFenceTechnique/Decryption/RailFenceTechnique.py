def separation_odd_even(cipher_text):
    new_word_even = []
    new_word_odd = []
    for i in range(0, len(cipher_text)):
        if i % 2 == 0:
            new_word_even.append(cipher_text[i])
        else:
            new_word_odd.append(cipher_text[i])
    new_word_even.extend(new_word_odd)
    return new_word_even


cipher_text = input("Enter the cipher text: ").replace(" ", "").lower()
new_word_list = []
new_word_list = separation_odd_even(cipher_text)
new_word_list = separation_odd_even(''.join(new_word_list))


print("Decrypted Word: " + "".join(new_word_list).upper())
