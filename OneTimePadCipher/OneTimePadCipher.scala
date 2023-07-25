def index_giving(text: String, array: IndexedSeq[(Char, Int)]): List[Int] = {
  text.toUpperCase.toList.flatMap { char =>
    array.find(_._1 == char).map(_._2)
  }
}

def enc_key_giving(plain_text: List[Int], random_text: List[Int], length: Int): List[Int] = {
  (plain_text zip random_text).map { case (plainIndex, randomIndex) =>
    (plainIndex + randomIndex) % 26
  }
}

def OneTimePadCipher(plain_text: String, random_text: String): String = {
  if (random_text.length() >= plain_text.length()) {
    val stringBuilder = new StringBuilder()
    val alphabets = ('A' to 'Z').zipWithIndex
    val plain_text_index = index_giving(plain_text, alphabets)
    val random_text_index = index_giving(random_text, alphabets)
    val enc_word_index = enc_key_giving(plain_text_index, random_text_index, plain_text.length())
    for (i <- enc_word_index) {
      stringBuilder.append(alphabets(i)._1)
    }
    stringBuilder.toString
  } else {
    "Invalid Key"
  }
}

@main def main(): Unit = {
  print("Enter Plaintext: ")
  val plain_text = scala.io.StdIn.readLine()
  print("Enter Randomtext: ")
  val random_text = scala.io.StdIn.readLine()
  println(OneTimePadCipher(plain_text, random_text))
}
