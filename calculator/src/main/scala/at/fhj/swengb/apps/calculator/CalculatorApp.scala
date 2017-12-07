package at.fhj.swengb.apps.calculator

import java.net.URL
import java.util.ResourceBundle
import javafx.application.Application
import javafx.fxml.{FXMLLoader, Initializable}
import javafx.scene.{Parent, Scene}
import javafx.stage.Stage

import scala.util.control.NonFatal

object CalculatorApp {

  def main(args: Array[String]): Unit = {
    Application.launch(classOf[CalculatorFX], args: _*)
  }
}

class CalculatorFX extends javafx.application.Application {

  val fxml = "/at/fhj/swengb/apps/calculator/calculator.fxml"
  val css =  "/at/fhj/swengb/apps/calculator/calculator.css"

  def mkFxmlLoader(fxml: String): FXMLLoader = {
    new FXMLLoader(getClass.getResource(fxml))
  }

  override def start(stage: Stage): Unit =
    try {
      stage.setTitle("Calculator")
      setSkin(stage, fxml, css)
      stage.show()
      stage.setMinWidth(stage.getWidth)
      stage.setMinHeight(stage.getHeight)
    } catch {
      case NonFatal(e) => e.printStackTrace()
    }

  def setSkin(stage: Stage, fxml: String, css: String): Boolean = {
    val scene = new Scene(mkFxmlLoader(fxml).load[Parent]())
    stage.setScene(scene)
    stage.getScene.getStylesheets.clear()
    stage.getScene.getStylesheets.add(css)
  }

}

class CalculatorFxController extends Initializable {
  override def initialize(location: URL, resources: ResourceBundle) = {

  }

  /** Liste für jeden knopfdruck zum zwischenspeichern
    * Liste für jede operation zum zwischenspeichern
    * Liste für das ergebnis.
    * funktion um die nächste eingabe zu bestätigen; sobald eine Op. eingegeben wird muss eine zahl Folgen,
    * falls eine weitere Op folgt -> liste für zwischenergebnis, falls = dann ergebnis
    *   ( Zahl -> Operation -> Zahl .... -> Ergebnis)
    *
    *einfacher ansatz -> IF - Else JUNGLE....!
    *
    */

  def one() : Unit = {
    println("1 clicked")

  }

  def two() : Unit = {
    println("2 clicked")

  }

  def three() : Unit = {
    println("3 clicked")

  }

  def four() : Unit = {
    println("4 clicked")

  }

  def five() : Unit = {
    println("5 clicked")

  }

  def six() : Unit = {
    println("6 clicked")

  }

  def seven() : Unit = {
    println("7 clicked")

  }

  def eight() : Unit = {
    println("8 clicked")

  }

  def nine() : Unit = {
    println("9 clicked")

  }

  def zero() : Unit = {
    println("0 clicked")

  }

  def add() : Unit = {
    println("+ clicked")

  }

  def subst() : Unit = {
    println("- clicked")

  }

  def multi() : Unit = {
    println("X clicked")

  }

  def change() : Unit = {
    println("+/- clicked")

  }

  def div() : Unit = {
    println("/ clicked")

  }

  def comma() : Unit = {
    println(", clicked")

  }

  def stack() : Unit = {
    println("INTERIM clicked")

  }

  def calc() : Unit = {
    println("= clicked")

  }

  def perc() : Unit = {
    println("% clicked")

  }


  def ac() : Unit = {
    println("AC clicked")

  }

  def sgn() : Unit = {
    println("SCheisse")
  }


}

