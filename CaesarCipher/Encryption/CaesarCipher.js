function return_enc_key(key, index) {
  const num = index + (key % 26);
  return num;
}

function read_plaintext(key) {
  var result = "";
  const alphabets = [];
  for (let i = 65; i <= 90; i++) {
    alphabets.push(String.fromCharCode(i));
  }
  var plain_text = prompt("Enter a plain text: ");
  var plain_text_upper = plain_text.toUpperCase();
  const plain_array = plain_text_upper.split("");
  for (let i = 0; i < plain_array.length; i++) {
    for (let j = 0; j < alphabets.length; j++) {
      if (plain_array[i] === alphabets[j]) {
        const plains = plain_array[i];
        var enc_key = return_enc_key(key, alphabets.indexOf(plains));
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
