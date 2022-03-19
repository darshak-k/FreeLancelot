
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


Seq[Any](format.raw/*1.63*/("""

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
                  HASH: b429296e2d1f360561698f6d399f556698a20bc6
                  MATRIX: 935->1|1091->62|1121->66|1350->269|1364->275|1426->316|1509->373|1523->379|1586->421|1670->478|1685->484|1753->530|1843->593|1858->599|1919->638|1972->664|1987->670|2049->711|2135->770|2150->776|2212->817|2462->1040|3115->1672|3157->1686|3542->2044|3598->2084|3638->2086|3696->2116|3766->2159|3794->2166|3865->2210|3895->2219|3995->2288|4049->2314
                  LINES: 27->1|32->1|34->3|39->8|39->8|39->8|40->9|40->9|40->9|41->10|41->10|41->10|42->11|42->11|42->11|43->12|43->12|43->12|44->13|44->13|44->13|55->24|69->38|70->39|80->49|80->49|80->49|81->50|82->51|82->51|83->52|83->52|86->55|87->56
                  -- GENERATED --
              */
          