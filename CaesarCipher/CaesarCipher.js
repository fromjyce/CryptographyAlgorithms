function return_enc_key(i, key, array) {
  const index = array.indexOf(i);
  const num = index + (key % 26);
  return num;
}

function read_plaintext(key) {
  var result = "";
  const alphabets = [];
  for (let i = 97; i <= 122; i++) {
    alphabets.push(String.fromCharCode(i).toUpperCase());
  }
  var plain_text = prompt("Enter a plain text: ");
  var plain_text_upper = plain_text.toUpperCase();
  const plain_array = plain_text_upper.split("");
  for (let i = 0; i < plain_array.length; i++) {
      for (let j = 0; j < alphabets.length; j++) {
        if (plain_array[i] === alphabets[j]) {
          var enc_key = return_enc_key(plain_array[i], key, alphabets);
          result += alphabets[enc_key];
        }
      }
  }
  console.log("Encrypted Text: " + result);
}

function read_input() {
  var key = prompt("Enter a Key: ");
  if (1 <= key && key <= 25) {
    read_plaintext(key);
  } else {
    console.log("Enter a Valid Key");
  }
}

read_input();
