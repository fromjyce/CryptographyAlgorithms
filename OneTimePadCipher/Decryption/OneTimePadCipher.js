function index_array(array, alpharray) {
  const return_array = [];
  for (let i = 0; i < array.length; i++) {
    for (let j = 0; j < alpharray.length; j++) {
      if (array[i] === alpharray[j]) {
        return_array.push(j);
        break;
      }
    }
  }
  return return_array;
}

function OneTimePadCipher(cipher, random) {
  var result = "";
  const alphabets = [];
  for (let i = 65; i <= 90; i++) {
    alphabets.push(String.fromCharCode(i));
  }
  var cipher_index_array = index_array(cipher, alphabets);
  var random_index_array = index_array(random, alphabets);
  const denc_key_index = [];
  for (let i = 0; i < cipher.length; i++) {
    denc_key_index[i] = (cipher_index_array[i] - random_index_array[i]) % 26;
  }
  for (let i = 0; i < cipher.length; i++) {
    result += alphabets[denc_key_index[i]];
  }
  return "Plain Text: " + result;
}

function read_input() {
  var cipher_text = prompt("Enter the cipher text: ").toUpperCase().split("");
  var random_key = prompt("Enter the random key: ").toUpperCase().split("");
  if (cipher_text.length === random_key.length) {
    console.log(OneTimePadCipher(cipher_text, random_key));
  } else {
    console.log("Enter a valid cipher text and random key pair");
  }
}

read_input();
