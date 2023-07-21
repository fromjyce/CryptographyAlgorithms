function return_enc_key(i, key, array) {
  const index = array.indexOf(i);
  const num = index + (key % 26);
  return num;
}

function read_plaintext(key) {
  var result = "";
  const lowercaseAlphabets = [];
  const uppercaseAlphabets = [];
  for (let i = 97; i <= 122; i++) {
    lowercaseAlphabets.push(String.fromCharCode(i));
    uppercaseAlphabets.push(String.fromCharCode(i).toUpperCase());
  }
  var plain_text = prompt("Enter a plain text: ");
  const plain_array = plain_text.split("");
  for (let i = 0; i < plain_array.length; i++) {
    if (plain_array[i] === plain_array[i].toUpperCase()) {
      for (let j = 0; j < uppercaseAlphabets.length; j++) {
        if (plain_array[i] === uppercaseAlphabets[j]) {
          var enc_key = return_enc_key(plain_array[i], key, uppercaseAlphabets);
          result += uppercaseAlphabets[enc_key];
        }
      }
    } else {
      for (let j = 0; j < lowercaseAlphabets.length; j++) {
        if (plain_array[i] === lowercaseAlphabets[j]) {
          var enc_key = return_enc_key(plain_array[i], key, lowercaseAlphabets);
          result += lowercaseAlphabets[enc_key];
        }
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
