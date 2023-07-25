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

function OneTimePadCipher(plain, random) {
  var result = "";
  const alphabets = [];
  for (let i = 65; i <= 90; i++) {
    alphabets.push(String.fromCharCode(i));
  }
  var plain_index_array = index_array(plain, alphabets);
  var random_index_array = index_array(random, alphabets);
  const enc_key_index = [];
  for (let i = 0; i < plain.length; i++) {
    enc_key_index[i] = (plain_index_array[i] ^ random_index_array[i]);
  }
  for (let i = 0; i < plain.length; i++) {
    result += alphabets[enc_key_index[i]];
  }
  return "Encrypted Word: " + result;
}

function read_input() {
  var plain_text = prompt("Enter the plain text: ").toUpperCase().split("");
  var random_key = prompt("Enter the random key: ").toUpperCase().split("");
  if (plain_text.length === random_key.length) {
    console.log(OneTimePadCipher(plain_text, random_key));
  } else {
    console.log("Enter a valid plain text and random key pair");
  }
}

read_input();
