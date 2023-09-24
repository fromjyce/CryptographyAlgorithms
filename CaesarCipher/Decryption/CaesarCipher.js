function return_dec_key(key, index) {
  const num = index - (key % 26);
  return num;
}

function read_cipher_text(key) {
  var result = "";
  const alphabets = [];
  for (let i = 65; i <= 90; i++) {
    alphabets.push(String.fromCharCode(i));
  }
  var cipher_text = prompt("Enter a cipher text: ");
  var cipher_text_upper = cipher_text.toUpperCase();
  const cipher_array = cipher_text_upper.split("");
  for (let i = 0; i < cipher_array.length; i++) {
    for (let j = 0; j < alphabets.length; j++) {
      if (cipher_array[i] === alphabets[j]) {
        const ciphers = cipher_array[i];
        var dec_key = return_dec_key(key, alphabets.indexOf(ciphers));
        result += alphabets[dec_key];
      }
    }
  }
  console.log("Plain Text: " + result);
}

function read_input() {
  var key = prompt("Enter a Key: ");
  if (1 <= key && key <= 25) {
    read_cipher_text(key);
  } else {
    console.log("Enter a Valid Key");
  }
}

read_input();
