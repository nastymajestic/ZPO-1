class toNieLiczbaException(s: String) extends Exception(s) {}

object HelloWorld {
  def main(args: Array[String]): Unit = {
    var dane: String = "-3  + 4 - 1 + 1 + 12 - 5 + 6"

    var wynik: Integer = 0
    var stringArray: Array[String] = dane.split(" ")
    wynik = wynik + stringArray(0).toInt;

    for (i <- 1 until stringArray.length) {
      var temporaryString: String = stringArray(i)

      temporaryString match {
        case "+" => {
          wynik = wynik + stringArray(i + 1).toInt

        }
        case "-" => {
          wynik = wynik - stringArray(i + 1).toInt

        }
        case _ => {
          if (!temporaryString.forall(_.isDigit)) {
            throw new toNieLiczbaException("zly format")
          }
        }
      }


    }
    println("Wynik wynosi:" + wynik)
  }
}
