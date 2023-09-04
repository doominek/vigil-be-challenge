package global.vigil.be.challenge.utils

object StringFormatters {

  implicit class StringOps(value: String) {
    private val DefaultWordBreakRegex: String = "\\s+"

    def splitIntoLines(maxChars: Int = 80): Seq[String] = {
      def appendToLine(line: String, nextWord: String): Vector[String] =
        if ((line + " " + nextWord).length > maxChars) Vector(line, nextWord)
        else Vector(line + " " + nextWord)

      value
        .split(DefaultWordBreakRegex)
        .foldLeft(Vector.empty[String]) { (acc, word) =>
          if (acc.isEmpty) Vector(word)
          else acc.init ++ acc.lastOption.map(line => appendToLine(line, word)).getOrElse(Vector(word))
        }
    }
  }

}
