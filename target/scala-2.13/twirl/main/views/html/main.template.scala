
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

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /*
 * This template is called from the `index` template. This template
 * handles the rendering of the page header and body tags. It takes
 * two arguments, a `String` for the title of the page and an `Html`
 * object to insert into the body of the page.
 */
  def apply/*7.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*7.32*/("""

"""),format.raw/*9.1*/("""<!DOCTYPE html>
<html lang="en">

<head>
    <title>"""),_display_(/*13.13*/title),format.raw/*13.18*/("""</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" media="screen" href='"""),_display_(/*15.50*/routes/*15.56*/.Assets.versioned("stylesheets/main.css")),format.raw/*15.97*/("""'>
    <link rel="stylesheet" media="screen" href='"""),_display_(/*16.50*/routes/*16.56*/.Assets.versioned("stylesheets/prism.css")),format.raw/*16.98*/("""'>
    <link rel="stylesheet" media="screen" href='"""),_display_(/*17.50*/routes/*17.56*/.Assets.versioned("stylesheets/formStyle.css")),format.raw/*17.102*/("""'>

    <link rel="shortcut icon" type="image/png" href='"""),_display_(/*19.55*/routes/*19.61*/.Assets.versioned("images/favicon.png")),format.raw/*19.100*/("""'>
    <script src='"""),_display_(/*20.19*/routes/*20.25*/.Assets.versioned("javascripts/hello.js")),format.raw/*20.66*/("""' type="text/javascript"></script>
    <script src='"""),_display_(/*21.19*/routes/*21.25*/.Assets.versioned("javascripts/prism.js")),format.raw/*21.66*/("""' type="text/javascript"></script>
</head>

<body>
    
    """),_display_(/*26.6*/content),format.raw/*26.13*/("""
"""),format.raw/*27.1*/("""</body>

</html>"""))
      }
    }
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/main.scala.html
                  HASH: b6a62081c702adb18b785e254f87eb36411bea7a
                  MATRIX: 1170->266|1295->296|1325->300|1409->357|1435->362|1597->497|1612->503|1674->544|1754->597|1769->603|1832->645|1912->698|1927->704|1995->750|2082->810|2097->816|2158->855|2207->877|2222->883|2284->924|2365->978|2380->984|2442->1025|2534->1091|2562->1098|2591->1100
                  LINES: 32->7|37->7|39->9|43->13|43->13|45->15|45->15|45->15|46->16|46->16|46->16|47->17|47->17|47->17|49->19|49->19|49->19|50->20|50->20|50->20|51->21|51->21|51->21|56->26|56->26|57->27
                  -- GENERATED --
              */
          