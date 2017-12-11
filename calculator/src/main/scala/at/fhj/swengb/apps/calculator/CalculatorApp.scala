package at.fhj.swengb.apps.calculator

import java.net.URL
import java.util.ResourceBundle
import javafx.application.Application
import javafx.beans.property.{ObjectProperty, SimpleObjectProperty}
import javafx.fxml.{FXML, FXMLLoader, Initializable}
import javafx.scene.control.TextField
import javafx.scene.{Parent, Scene}
import javafx.stage.Stage

import scala.util.{Failure, Success}
import scala.util.control.NonFatal

object CalculatorApp {

  def main(args: Array[String]): Unit = {
    Application.launch(classOf[CalculatorFX], args: _*)
  }
}

class CalculatorFX extends javafx.application.Application {

  val fxml = "/at/fhj/swengb/apps/calculator/calculator.fxml"
  val css = "/at/fhj/swengb/apps/calculator/calculator.css"

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

  val calculatorProperty: ObjectProperty[RpnCalculator] = new SimpleObjectProperty[RpnCalculator](RpnCalculator())

  def getCalculator() : RpnCalculator = calculatorProperty.get()

  def setCalculator(rpnCalculator : RpnCalculator) : Unit = calculatorProperty.set(rpnCalculator)

  @FXML var numberTextField1 : TextField = _
  @FXML var numberTextField2 : TextField = _
  @FXML var numberTextField3 : TextField = _

  override def initialize(location: URL, resources: ResourceBundle) = {

  }

  def calc(): Unit = {
    getCalculator().push(Op(numberTextField1.getText)) match {
      case Success(c) => setCalculator(c)
      case Failure(e) => // show warning / error
    }
    getCalculator().stack foreach println

    (numberTextField2.setText(getCalculator().stack(0).toString.drop(4).init))
    numberTextField3.setText("")
    (numberTextField1.setText(getCalculator().stack(0).toString.drop(4).init))
    numberTextField3.setText("")

  }



  def one() : Unit = {
    numberTextField3.appendText("1")

  }

  def two() : Unit = {
    numberTextField3.appendText("2")

  }

  def three() : Unit = {
    numberTextField3.appendText("3")

  }

  def four() : Unit = {
    numberTextField3.appendText("4")

  }

  def five() : Unit = {
    numberTextField3.appendText("5")

  }

  def six() : Unit = {
    numberTextField3.appendText("6")

  }

  def seven() : Unit = {
    numberTextField3.appendText("7")

  }

  def eight() : Unit = {
    numberTextField3.appendText("8")

  }

  def nine() : Unit = {
    numberTextField3.appendText("9")

  }

  def zero() : Unit = {
    numberTextField3.appendText("0")

  }

  def add() : Unit = {
    numberTextField3.appendText("+")

  }

  def subst() : Unit = {
    numberTextField3.appendText("-")

  }

  def multi() : Unit = {
    numberTextField3.appendText("*")

  }

  def change() : Unit = {
    numberTextField3.appendText("+/-")

  }

  def div() : Unit = {
    numberTextField3.appendText("/")

  }

  def comma() : Unit = {
    numberTextField3.appendText(",")

  }

  def stack() : Unit = {
    numberTextField3.appendText("Interim")

  }

  def perc() : Unit = {
    numberTextField3.appendText("%")
  }


  def ac() : Unit = {
    numberTextField3.appendText("")
  }

}