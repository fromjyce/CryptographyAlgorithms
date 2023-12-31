def ReturnEncKey(num: Int, key: Int) : Int = {
	return (num+key)%26;
}

def ReadPlainText(key : Int) : Unit = {
	val stringBuilder = StringBuilder()
	val alphabets = ('A' to 'Z').zipWithIndex
	print("Enter the plaintext: ");
	var word = scala.io.StdIn.readLine();
	for (char <- word.toUpperCase.toList) {
		for ((alph, index) <- alphabets) {
			if (alph==char) {
				var enc_key = ReturnEncKey(index, key)
				var enc_char = alphabets(enc_key)._1
				stringBuilder.append(enc_char)
			}
		}
	}
	val resultString: String = stringBuilder.toString
	print(s"Encrypted Text: $resultString")
}

@main def main(): Unit =
	print("Enter Key: ")
	var key = scala.io.StdIn.readInt();
	//print(key);
	if (1<=key && key<=25) {
		ReadPlainText(key)		
	}
	else {
		print("Invalid Key")
	}
