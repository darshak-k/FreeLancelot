
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
/*1.2*/import models.FreelancerProject

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[List[SearchResult],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(searchResultData:  List[SearchResult]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.41*/("""

"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html lang="en">

<head>
<title>Freelancelot</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" media="screen"  href='"""),_display_(/*10.47*/routes/*10.53*/.Assets.versioned("stylesheets/main.css")),format.raw/*10.94*/("""'>
<link rel="stylesheet" media="screen" href='"""),_display_(/*11.46*/routes/*11.52*/.Assets.versioned("stylesheets/prism.css")),format.raw/*11.94*/("""'>
<link rel="stylesheet" media="screen" href='"""),_display_(/*12.46*/routes/*12.52*/.Assets.versioned("stylesheets/formStyle.css")),format.raw/*12.98*/("""'>
<link rel="shortcut icon" type="image/png"  href='"""),_display_(/*13.52*/routes/*13.58*/.Assets.versioned("images/favicon.png")),format.raw/*13.97*/("""'>
<script src='"""),_display_(/*14.15*/routes/*14.21*/.Assets.versioned("javascripts/hello.js")),format.raw/*14.62*/("""'  type="text/javascript"></script>
<script src='"""),_display_(/*15.15*/routes/*15.21*/.Assets.versioned("javascripts/prism.js")),format.raw/*15.62*/("""'  type="text/javascript"></script>

<style>

</style>
</head>
<body>
	<section id="content">
		<br>
		<br>
		<div class="container">
			<center>
				<h1 style="font-size: 25px; font-weight: bold">
					<strong>Welcome to FreeLancelot</strong>
				</h1>
			</center>
		</div>
		<center>
			<form id="form" method="get" action="/search" style="margin-top: 60px;">
				<input type="text" style="width: 240px; height: 25px; padding: 5px;" name="inputKeyword" placeholder="Enter Search terms" required>
				<button style="background-color: #009879; color: white; width: 110px; height: 35px; margin-left: 20px; border-radius: 10px; font-weight: bold"  type="submit">Go</button>
			</form>
		</center>
		<br>

		<div class="container">
			"""),_display_(/*41.5*/{
				if(searchResultData.size() > 0){
						<center>
							<a href="/globalStats" > Global Stats </a>
						</center>
						<br/>
						<br/>
				}
			}),format.raw/*49.5*/("""
			"""),_display_(/*50.5*/for(searchResult <- searchResultData) yield /*50.42*/ {_display_(Seq[Any](format.raw/*50.44*/("""
				"""),format.raw/*51.5*/("""<center>
					<label>Search terms: """),_display_(/*52.28*/searchResult/*52.40*/.getQuery()),format.raw/*52.51*/("""	"""),format.raw/*52.52*/("""</label>
				</center>
				<br/>
				<center>
					<table class="styled-table">
						<thead>
							<th>Owner_ID</th>
							<th>Time submitted</th>
							<th>Title</th>
							<th>Type</th>
							<th>Required_skills</th>
							<th>Stats</th>
						</thead>
						<tbody>
							"""),_display_(/*66.9*/for(project <- searchResult.getProjects()) yield /*66.51*/ {_display_(Seq[Any](format.raw/*66.53*/("""
								"""),format.raw/*67.9*/("""<tr>
									<td><a href="/profiledata/"""),_display_(/*68.37*/{project.getOwner_id()}),format.raw/*68.60*/("""" > """),_display_(/*68.65*/project/*68.72*/.getOwner_id()),format.raw/*68.86*/("""</a></td>
									<td>"""),_display_(/*69.15*/project/*69.22*/.getDate_string()),format.raw/*69.39*/("""</td>
									<td>"""),_display_(/*70.15*/project/*70.22*/.getTitle()),format.raw/*70.33*/("""</td>
									<td>"""),_display_(/*71.15*/project/*71.22*/.getType()),format.raw/*71.32*/("""</td>
									<td>
										"""),_display_(/*73.12*/for(skill <- project.getJobs()) yield /*73.43*/{_display_(Seq[Any](format.raw/*73.44*/("""
											"""),format.raw/*74.12*/("""<a href="/skills/"""),_display_(/*74.30*/{skill.getId()}),format.raw/*74.45*/("""" > """),_display_(/*74.50*/skill/*74.55*/.getName()),format.raw/*74.65*/("""</a>
										""")))}),format.raw/*75.12*/("""
									"""),format.raw/*76.10*/("""</td>

									<td><a href="/localStats/"""),_display_(/*78.36*/{project.getId()}),format.raw/*78.53*/("""" > stats </a></td>
								</tr>

							""")))}),format.raw/*81.9*/("""
						"""),format.raw/*82.7*/("""</tbody>
					</table>
				</center>
				<br><br><br>
			""")))}),format.raw/*86.5*/("""
		"""),format.raw/*87.3*/("""</div>
	</section>
</body>
</html>"""))
      }
    }
  }

  def render(searchResultData:List[SearchResult]): play.twirl.api.HtmlFormat.Appendable = apply(searchResultData)

  def f:((List[SearchResult]) => play.twirl.api.HtmlFormat.Appendable) = (searchResultData) => apply(searchResultData)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/index.scala.html
                  HASH: 134c912d185c304d25ea2addd613ed614515901f
                  MATRIX: 610->1|958->35|1092->74|1122->78|1341->270|1356->276|1418->317|1494->366|1509->372|1572->414|1648->463|1663->469|1730->515|1812->570|1827->576|1887->615|1932->633|1947->639|2009->680|2087->731|2102->737|2164->778|2950->1538|3132->1700|3164->1706|3217->1743|3257->1745|3290->1751|3354->1788|3375->1800|3407->1811|3436->1812|3760->2110|3818->2152|3858->2154|3895->2164|3964->2206|4008->2229|4040->2234|4056->2241|4091->2255|4143->2280|4159->2287|4197->2304|4245->2325|4261->2332|4293->2343|4341->2364|4357->2371|4388->2381|4448->2414|4495->2445|4534->2446|4575->2459|4620->2477|4656->2492|4688->2497|4702->2502|4733->2512|4781->2529|4820->2540|4891->2584|4929->2601|5005->2647|5040->2655|5132->2717|5163->2721
                  LINES: 23->1|28->2|33->2|35->4|41->10|41->10|41->10|42->11|42->11|42->11|43->12|43->12|43->12|44->13|44->13|44->13|45->14|45->14|45->14|46->15|46->15|46->15|72->41|80->49|81->50|81->50|81->50|82->51|83->52|83->52|83->52|83->52|97->66|97->66|97->66|98->67|99->68|99->68|99->68|99->68|99->68|100->69|100->69|100->69|101->70|101->70|101->70|102->71|102->71|102->71|104->73|104->73|104->73|105->74|105->74|105->74|105->74|105->74|105->74|106->75|107->76|109->78|109->78|112->81|113->82|117->86|118->87
                  -- GENERATED --
              */
          