import scala.collection.mutable
import scala.io.Source
import scala.io.StdIn.readLine
import scala.util.Random

object Teacher extends App {
  val filename = "C:\\Users\\r.kaczynski\\IdeaProjects\\language-teacher\\src\\main\\scala\\dict.txt"
  val lines = Source.fromFile(filename).getLines
  var dictionary = mutable.Map.empty[String, String]

  for (l <- lines) {
    val words = l.split("\\W+")
    dictionary += (words(0) -> words(1))
  }
//  dictionary.foreach(println)


  var wordScores = dictionary.foldLeft(List.empty[(String, String, Int)]) {
    (result, x) => result :+ (x._1, x._2, 0)
  }
//  wordScores.foreach(println)

  def getRandomElement(seq: Seq[(String, String, Int)]) : (String, String, Int)  = {


    var x = seq(Random.nextInt(seq.length))

    while (x._3 != 3) {
      var x = seq(Random.nextInt(seq.length))
    }
    x
  }


  def allWordsDone(ls: List[(String, String, Int)]) = {
    var counter = 0
    ls.foreach{case (_, _, 3) => counter += 1}
    counter == ls.length
  }

  var input = ""
  while (input.toLowerCase() != "q") {
    val word = getRandomElement(wordScores)
    input = readLine(s"Translate word ${word._1}: ")
  }

}
