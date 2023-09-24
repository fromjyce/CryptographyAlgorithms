def ReturnDecKey(num: Int, key: Int) : Int = {
	return (num-key)%26;
}

def ReadCipherText(key : Int) : Unit = {
	val stringBuilder = StringBuilder()
	val alphabets = ('A' to 'Z').zipWithIndex
	print("Enter the Cipher Text: ");
	var word = scala.io.StdIn.readLine();
	for (char <- word.toUpperCase.toList) {
		for ((alph, index) <- alphabets) {
			if (alph==char) {
				var dec_key = ReturnDecKey(index, key)
				var dec_char = alphabets(dec_key)._1
				stringBuilder.append(dec_char)
			}
		}
	}
	val resultString: String = stringBuilder.toString
	print(s"Plain Text: $resultString")
}

@main def main(): Unit =
	print("Enter Key: ")
	var key = scala.io.StdIn.readInt();
	//print(key);
	if (1<=key && key<=25) {
		ReadCipherText(key)		
	}
	else {
		print("Invalid Key")
	}
