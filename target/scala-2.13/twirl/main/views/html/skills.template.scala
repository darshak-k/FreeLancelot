
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

object skills extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[List[SearchResult],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(skillSearchResultData:  List[SearchResult]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.1*/("""
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
				if(skillSearchResultData.size() > 0){
						<center>
							<a href="/globalStats" > Global Stats </a>
						</center>
						<br/>
						<br/>
				}
			}),format.raw/*49.5*/("""
			"""),_display_(/*50.5*/for(searchResult <- skillSearchResultData) yield /*50.47*/ {_display_(Seq[Any](format.raw/*50.49*/("""
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

  def render(skillSearchResultData:List[SearchResult]): play.twirl.api.HtmlFormat.Appendable = apply(skillSearchResultData)

  def f:((List[SearchResult]) => play.twirl.api.HtmlFormat.Appendable) = (skillSearchResultData) => apply(skillSearchResultData)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/skills.scala.html
                  HASH: 60cd6fa1b2cee1884d5c916082ca5a3f913ab742
                  MATRIX: 610->1|959->34|1097->79|1124->80|1337->266|1352->272|1414->313|1489->361|1504->367|1567->409|1642->457|1657->463|1724->509|1805->563|1820->569|1880->608|1924->625|1939->631|2001->672|2078->722|2093->728|2155->769|2915->1503|3094->1662|3125->1667|3183->1709|3223->1711|3255->1716|3318->1752|3339->1764|3371->1775|3400->1776|3710->2060|3768->2102|3808->2104|3844->2113|3912->2154|3956->2177|3988->2182|4004->2189|4039->2203|4090->2227|4106->2234|4144->2251|4191->2271|4207->2278|4239->2289|4286->2309|4302->2316|4333->2326|4391->2357|4438->2388|4477->2389|4517->2401|4562->2419|4598->2434|4630->2439|4644->2444|4675->2454|4722->2470|4760->2480|4829->2522|4867->2539|4940->2582|4974->2589|5062->2647|5092->2650
                  LINES: 23->1|28->2|33->3|34->4|40->10|40->10|40->10|41->11|41->11|41->11|42->12|42->12|42->12|43->13|43->13|43->13|44->14|44->14|44->14|45->15|45->15|45->15|71->41|79->49|80->50|80->50|80->50|81->51|82->52|82->52|82->52|82->52|96->66|96->66|96->66|97->67|98->68|98->68|98->68|98->68|98->68|99->69|99->69|99->69|100->70|100->70|100->70|101->71|101->71|101->71|103->73|103->73|103->73|104->74|104->74|104->74|104->74|104->74|104->74|105->75|106->76|108->78|108->78|111->81|112->82|116->86|117->87
                  -- GENERATED --
              */
          