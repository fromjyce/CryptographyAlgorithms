def ReturnBool(org: String, rev: String): String = {
        if (org==rev) {
                return "This is a Palindrome";
        }
        else {
                return "This is not a Palindrome";
        }
}

def ReverseString(ord: String) : String = {
        return ord.reverse;
}


@main def main(): Unit =
        print("Enter String: ");
        var word = scala.io.StdIn.readLine();
        print(ReturnBool(word,ReverseString(word)));