
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.data._
import play.core.j.PlayFormsMagicForJava._
import scala.jdk.CollectionConverters._

object stats extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,LinkedHashMap[String, Long],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(statString:String, statsResult: LinkedHashMap[String, Long]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<html lang="en">

    <head>
        <title>Freelancelot</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" media="screen"  href='"""),_display_(/*8.55*/routes/*8.61*/.Assets.versioned("stylesheets/main.css")),format.raw/*8.102*/("""'>
        <link rel="stylesheet" media="screen" href='"""),_display_(/*9.54*/routes/*9.60*/.Assets.versioned("stylesheets/prism.css")),format.raw/*9.102*/("""'>
        <link rel="stylesheet" media="screen" href='"""),_display_(/*10.54*/routes/*10.60*/.Assets.versioned("stylesheets/formStyle.css")),format.raw/*10.106*/("""'>
        <link rel="shortcut icon" type="image/png"  href='"""),_display_(/*11.60*/routes/*11.66*/.Assets.versioned("images/favicon.png")),format.raw/*11.105*/("""'>
        <script src='"""),_display_(/*12.23*/routes/*12.29*/.Assets.versioned("javascripts/hello.js")),format.raw/*12.70*/("""'  type="text/javascript"></script>
        <script src='"""),_display_(/*13.23*/routes/*13.29*/.Assets.versioned("javascripts/prism.js")),format.raw/*13.70*/("""'  type="text/javascript"></script>

        <style>

        </style>
    </head>
    <body>
        <section id="content">
            <br>
            <br>
            <div class="container">
                """),_display_(/*24.18*/{
                    if (statString == "local") {
                        <center>
                            <h1 style="font-size: 25px; font-weight: bold">
                                <strong>Local Stats of Project</strong>
                            </h1>
                        </center>
                    } else {
                        <center>
                            <h1 style="font-size: 25px; font-weight: bold">
                                <strong>Global Stats of Project</strong>
                            </h1>
                        </center>
                    }
                }),format.raw/*38.18*/("""
            """),format.raw/*39.13*/("""</div>
            <br>
            <div class="container">
                <center>
                    <table class="styled-table">
                        <thead>
                            <th>Keyword</th>
                            <th>Frequency</th>
                        </thead>
                        <tbody>
                        """),_display_(/*49.26*/for((keyword, frequency) <- statsResult) yield /*49.66*/ {_display_(Seq[Any](format.raw/*49.68*/("""
                            """),format.raw/*50.29*/("""<tr>
                                <td>"""),_display_(/*51.38*/keyword),format.raw/*51.45*/("""</td>
                                <td>"""),_display_(/*52.38*/frequency),format.raw/*52.47*/("""</td>
                            </tr>

                        """)))}),format.raw/*55.26*/("""
                        """),format.raw/*56.25*/("""</tbody>
                    </table>
                </center>
                <br><br><br>
            </div>
        </section>
    </body>
</html>"""))
      }
    }
  }

  def render(statString:String,statsResult:LinkedHashMap[String, Long]): play.twirl.api.HtmlFormat.Appendable = apply(statString,statsResult)

  def f:((String,LinkedHashMap[String, Long]) => play.twirl.api.HtmlFormat.Appendable) = (statString,statsResult) => apply(statString,statsResult)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/stats.scala.html
                  HASH: b49e9c6a795436987769e80fcae5c6e65814e316
                  MATRIX: 935->1|1090->63|1117->64|1341->262|1355->268|1417->309|1499->365|1513->371|1576->413|1659->469|1674->475|1742->521|1831->583|1846->589|1907->628|1959->653|1974->659|2036->700|2121->758|2136->764|2198->805|2437->1017|3076->1635|3117->1648|3492->1996|3548->2036|3588->2038|3645->2067|3714->2109|3742->2116|3812->2159|3842->2168|3939->2234|3992->2259
                  LINES: 27->1|32->2|33->3|38->8|38->8|38->8|39->9|39->9|39->9|40->10|40->10|40->10|41->11|41->11|41->11|42->12|42->12|42->12|43->13|43->13|43->13|54->24|68->38|69->39|79->49|79->49|79->49|80->50|81->51|81->51|82->52|82->52|85->55|86->56
                  -- GENERATED --
              */
          