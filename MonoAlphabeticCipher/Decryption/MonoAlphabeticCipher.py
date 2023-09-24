import string

def generate_mapped_key_upper(key):
    mapped_dict_upper = {}
    alphabets = list(string.ascii_uppercase)
    for i in range(len(alphabets)):
        mapped_dict_upper[alphabets[i]] = key[i]
    mapped_dict_upper[" "] = " "
    return mapped_dict_upper

def generate_mapped_key_lower(key):
    mapped_dict_lower = {}
    alphabets = list(string.ascii_lowercase)
    for i in range(len(alphabets)):
        mapped_dict_lower[alphabets[i]] = key[i]
    mapped_dict_lower[" "] = " "
    return mapped_dict_lower

def generate_dec_key(cipher_text, key):
    mapped_key_upper = generate_mapped_key_upper(key)
    mapped_key_lower = generate_mapped_key_lower(key.lower())
    result = []
    for i in cipher_text:
        if i.islower():
            for original_key, mapped_key in mapped_key_lower.items():
                if i == mapped_key:
                    result.append(original_key)
        else:
            for original_key, mapped_key in mapped_key_upper.items():
                if i == mapped_key:
                    result.append(original_key)
    return "".join(result)

def check_key_validity(key):
    if len(key) == 26:
        return True
    else:
        return False

def read_input():
    cipher_text = str(input("Enter the Cipher Text: "))
    key = str(input("Enter the Key: "))
    if (check_key_validity(key)):
        plain_word = generate_dec_key(cipher_text, key)
        print("Plain Text: ", plain_word)
    else:
        print("Invalid Key")

read_input()





