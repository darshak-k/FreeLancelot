
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
                  HASH: 9ceb1b28890efc54de5eb34b3e67a17a07a273ca
                  MATRIX: 610->1|958->34|1091->74|1118->75|1331->261|1346->267|1408->308|1483->356|1498->362|1561->404|1636->452|1651->458|1718->504|1799->558|1814->564|1874->603|1918->620|1933->626|1995->667|2072->717|2087->723|2149->764|2909->1498|3083->1652|3114->1657|3167->1694|3207->1696|3239->1701|3302->1737|3323->1749|3355->1760|3384->1761|3694->2045|3752->2087|3792->2089|3828->2098|3896->2139|3940->2162|3972->2167|3988->2174|4023->2188|4074->2212|4090->2219|4128->2236|4175->2256|4191->2263|4223->2274|4270->2294|4286->2301|4317->2311|4375->2342|4422->2373|4461->2374|4501->2386|4546->2404|4582->2419|4614->2424|4628->2429|4659->2439|4706->2455|4744->2465|4813->2507|4851->2524|4924->2567|4958->2574|5046->2632|5076->2635
                  LINES: 23->1|28->2|33->3|34->4|40->10|40->10|40->10|41->11|41->11|41->11|42->12|42->12|42->12|43->13|43->13|43->13|44->14|44->14|44->14|45->15|45->15|45->15|71->41|79->49|80->50|80->50|80->50|81->51|82->52|82->52|82->52|82->52|96->66|96->66|96->66|97->67|98->68|98->68|98->68|98->68|98->68|99->69|99->69|99->69|100->70|100->70|100->70|101->71|101->71|101->71|103->73|103->73|103->73|104->74|104->74|104->74|104->74|104->74|104->74|105->75|106->76|108->78|108->78|111->81|112->82|116->86|117->87
                  -- GENERATED --
              */
          