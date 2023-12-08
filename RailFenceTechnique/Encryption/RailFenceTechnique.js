function RailFenceTechnique(plainText) {
  const formattedPlainText = plainText.replace(/\s/g, "").toLowerCase();
  const newWordEven = [];
  const newWordOdd = [];
  for (let i = 0; i < formattedPlainText.length; i++) {
    if (i % 2 === 0) {
      newWordEven.push(formattedPlainText[i]);
    } else {
      newWordOdd.push(formattedPlainText[i]);
    }
  }
  const encryptedWord = newWordEven.concat(newWordOdd).join("");
  return "Encrypted Word: " + encryptedWord;
}

function read_input() {
  var plain_text = prompt("Enter the plain text: ").split("");
  console.log(RailFenceTechnique(plain_text.join("")));
}

read_input();
