plain_text = input("Enter the plain text: ").replace(" ", "")
new_word_even = []
new_word_odd = []
for i in range(0, len(plain_text)):
    if i % 2 == 0:
        new_word_even.append(plain_text[i])
    else:
        new_word_odd.append(plain_text[i])

new_word_even.extend(new_word_odd)
print("Encrypted Word: " + "".join(new_word_even))
