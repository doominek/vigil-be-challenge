package global.vigil.be.challenge.utils

import collection.mutable.Stack
import org.scalatest._
import flatspec._
import matchers._
import StringFormatters._

class StringFormattersSpec extends AnyFlatSpec with should.Matchers {

  behavior of "splitIntoLines"

  it should "split empty input into no lines" in {
    " \t    \n\n\n".splitIntoLines() shouldBe empty
  }

  it should "split input into lines strings longer than max chars" in {
    "I am Groot".splitIntoLines(5) shouldBe Vector("I am", "Groot")
  }

  it should "split input of items of size equal to max chars" in {
    "must test only last line".splitIntoLines(4) shouldBe Vector("must", "test", "only", "last", "line")
  }

  it should "not split line longer than max chars when no break word char inside" in {
    "12345678 is long number".splitIntoLines(6) shouldBe Vector("12345678", "is", "long", "number")
  }

  it should "group consecutive break word chars when splitting" in {
    "one\t\n     two       \n\n\n\nthree".splitIntoLines(5) shouldBe Vector("one", "two", "three")
  }

  it should "split longer text into many lines" in {
    val input =
      "In 1991, while studying computer science at University of Helsinki, Linus Torvalds began a project that later " +
        "became the Linux kernel. He wrote the program specifically for the hardware he was using and independent of " +
        "an operating system because he wanted to use the functions of his new PC with an 80386 processor. Development " +
        "was done on MINIX using the GNU C Compiler."

    val expectedOutput =
      """In 1991, while studying computer science
        |at University of Helsinki, Linus
        |Torvalds began a project that later
        |became the Linux kernel. He wrote the
        |program specifically for the hardware he
        |was using and independent of an
        |operating system because he wanted to
        |use the functions of his new PC with an
        |80386 processor. Development was done on
        |MINIX using the GNU C Compiler.""".stripMargin

    input.splitIntoLines(40).mkString("\n") shouldBe (expectedOutput)
  }

}
