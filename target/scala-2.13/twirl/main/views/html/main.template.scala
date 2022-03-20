
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


Seq[Any](format.raw/*8.1*/("""
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
                  HASH: ba4978df24631a793ef3665b3da53706c0b5ba6f
                  MATRIX: 1165->260|1289->291|1316->292|1396->345|1422->350|1582->483|1597->489|1659->530|1738->582|1753->588|1816->630|1895->682|1910->688|1978->734|2063->792|2078->798|2139->837|2187->858|2202->864|2264->905|2344->958|2359->964|2421->1005|2508->1066|2536->1073|2564->1074
                  LINES: 32->7|37->8|38->9|42->13|42->13|44->15|44->15|44->15|45->16|45->16|45->16|46->17|46->17|46->17|48->19|48->19|48->19|49->20|49->20|49->20|50->21|50->21|50->21|55->26|55->26|56->27
                  -- GENERATED --
              */
          