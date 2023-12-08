def RailFenceTechnique(plainText: String): String = {
    val formattedPlainText = plainText.replace(" ", "").toLowerCase
    val newWordEven = formattedPlainText.zipWithIndex.collect { case (c, i) if i % 2 == 0 => c }
    val newWordOdd = formattedPlainText.zipWithIndex.collect { case (c, i) if i % 2 == 1 => c }
    (newWordEven ++ newWordOdd).mkString
}

@main def main(): Unit = {
  print("Enter Plaintext: ")
  val plain_text = scala.io.StdIn.readLine()
  println(RailFenceTechnique(plain_text))
}
