
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

object profile extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[List[SearchResult],List[SearchProfile],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(searchResultData:  List[SearchResult], profileResult: List[SearchProfile]):play.twirl.api.HtmlFormat.Appendable = {
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
table, th, td """),format.raw/*18.15*/("""{"""),format.raw/*18.16*/("""
	"""),format.raw/*19.2*/("""padding: 5px;
	font-size: small;
	color: #000;
"""),format.raw/*22.1*/("""}"""),format.raw/*22.2*/("""

"""),format.raw/*24.1*/("""thead"""),format.raw/*24.6*/("""{"""),format.raw/*24.7*/("""
	"""),format.raw/*25.2*/("""font-weight: bold;
"""),format.raw/*26.1*/("""}"""),format.raw/*26.2*/("""

"""),format.raw/*28.1*/("""</style>
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
				<input type="text" style="width: 240px; height: 35px; padding: 5px;" name="inputKeyword" placeholder="Enter Search terms" required>
				<button style="background-color: #009879; color: white; width: 110px; height: 35px; margin-left: 20px; border-radius: 10px; font-weight: bold"  type="submit">Go</button>
			</form>
		</center>
		<br>

		<div class="container">
			"""),_display_(/*50.5*/for(searchResult <- searchResultData) yield /*50.42*/ {_display_(Seq[Any](format.raw/*50.44*/("""
		
				"""),format.raw/*52.5*/("""<center>
					<a > Employee Projects </a>
				</center>
				<br/>
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
							<th></th>
						</thead>
						<tbody>
							"""),_display_(/*70.9*/for(project <- searchResult.getProjects()) yield /*70.51*/ {_display_(Seq[Any](format.raw/*70.53*/("""
								"""),format.raw/*71.9*/("""<tr>
									<td><a href="/profiledata/"""),_display_(/*72.37*/{project.getOwner_id()}),format.raw/*72.60*/("""" > """),_display_(/*72.65*/project/*72.72*/.getOwner_id()),format.raw/*72.86*/("""</a></td>
									<td>"""),_display_(/*73.15*/project/*73.22*/.getDate_string()),format.raw/*73.39*/("""</td>
									<td>"""),_display_(/*74.15*/project/*74.22*/.getTitle()),format.raw/*74.33*/("""</td>
									<td>"""),_display_(/*75.15*/project/*75.22*/.getType()),format.raw/*75.32*/("""</td>
									<td>
										"""),_display_(/*77.12*/for(skill <- project.getJobs()) yield /*77.43*/{_display_(Seq[Any](format.raw/*77.44*/("""
											"""),format.raw/*78.12*/("""<a href="/skills/"""),_display_(/*78.30*/{skill.getId()}),format.raw/*78.45*/("""" > """),_display_(/*78.50*/skill/*78.55*/.getName()),format.raw/*78.65*/("""</a>
										""")))}),format.raw/*79.12*/("""
									"""),format.raw/*80.10*/("""</td>

									<td><a href="/localStats/"""),_display_(/*82.36*/{project.getId()}),format.raw/*82.53*/("""" > stats </a></td>

								</tr>

							""")))}),format.raw/*86.9*/("""
						"""),format.raw/*87.7*/("""</tbody>
					</table>
				</center>
				<br><br><br>
			""")))}),format.raw/*91.5*/("""
		"""),format.raw/*92.3*/("""</div>

		<div class="container">

            """),_display_(/*96.14*/for(profileData <- profileResult) yield /*96.47*/ {_display_(Seq[Any](format.raw/*96.49*/("""
                """),format.raw/*97.17*/("""<center>
					<a> Employee Details </a>
				</center>
				<br/>
				<br/>
                <center>
                    <table class="styled-table">
                        <thead>
                            <th>id</th>
                            <th>username</th>
							<th>displayname</th>
							<th>role</th>
							<th>registrationdate</th>
							<th>chosenrole</th>
							<th>limitedaccount</th>
							<th>Location</th>
							<th>Status</th>
							<th>primary_currency</th>
                        </thead>
                        <tbody>
                            <tr>
                                <td>"""),_display_(/*118.38*/profileData/*118.49*/.getProfiledata().getId()),format.raw/*118.74*/("""</td>
                                <td>"""),_display_(/*119.38*/profileData/*119.49*/.getProfiledata().getUsername()),format.raw/*119.80*/("""</td>
								<td>"""),_display_(/*120.14*/profileData/*120.25*/.getProfiledata().getDisplayname()),format.raw/*120.59*/("""</td>
								<td>"""),_display_(/*121.14*/profileData/*121.25*/.getProfiledata().getRole()),format.raw/*121.52*/("""</td>
								<td>"""),_display_(/*122.14*/profileData/*122.25*/.getProfiledata().getRegistration_date()),format.raw/*122.65*/("""</td>
								<td>"""),_display_(/*123.14*/profileData/*123.25*/.getProfiledata().getChosenrole()),format.raw/*123.58*/("""</td>
								<td>"""),_display_(/*124.14*/profileData/*124.25*/.getProfiledata().getLimitedaccount()),format.raw/*124.62*/("""</td>
								<td>"""),_display_(/*125.14*/profileData/*125.25*/.getProfiledata().getLocation().getCountry().getName()),format.raw/*125.79*/("""</td>
								<td>"""),_display_(/*126.14*/profileData/*126.25*/.getProfiledata().getStatus().getEmail_varified()),format.raw/*126.74*/("""</td>
								<td>"""),_display_(/*127.14*/profileData/*127.25*/.getProfiledata().getPrimary_currency().getName()),format.raw/*127.74*/("""</td>
                            </tr>
                        </tbody>
                    </table>
                </center>
                <br><br><br>
            """)))}),format.raw/*133.14*/("""
        """),format.raw/*134.9*/("""</div>
		
	</section>
</body>
</html>"""))
      }
    }
  }

  def render(searchResultData:List[SearchResult],profileResult:List[SearchProfile]): play.twirl.api.HtmlFormat.Appendable = apply(searchResultData,profileResult)

  def f:((List[SearchResult],List[SearchProfile]) => play.twirl.api.HtmlFormat.Appendable) = (searchResultData,profileResult) => apply(searchResultData,profileResult)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/profile.scala.html
                  HASH: a2598b8e395f31ebc03938df38f7ba2b5304e0ad
                  MATRIX: 610->1|980->34|1149->110|1176->111|1389->297|1404->303|1466->344|1541->392|1556->398|1619->440|1694->488|1709->494|1776->540|1857->594|1872->600|1932->639|1976->656|1991->662|2053->703|2130->753|2145->759|2207->800|2294->859|2323->860|2352->862|2426->909|2454->910|2483->912|2515->917|2543->918|2572->920|2618->939|2646->940|2675->942|3389->1630|3442->1667|3482->1669|3517->1677|3892->2026|3950->2068|3990->2070|4026->2079|4094->2120|4138->2143|4170->2148|4186->2155|4221->2169|4272->2193|4288->2200|4326->2217|4373->2237|4389->2244|4421->2255|4468->2275|4484->2282|4515->2292|4573->2323|4620->2354|4659->2355|4699->2367|4744->2385|4780->2400|4812->2405|4826->2410|4857->2420|4904->2436|4942->2446|5011->2488|5049->2505|5123->2549|5157->2556|5245->2614|5275->2617|5350->2665|5399->2698|5439->2700|5484->2717|6134->3339|6155->3350|6202->3375|6273->3418|6294->3429|6347->3460|6394->3479|6415->3490|6471->3524|6518->3543|6539->3554|6588->3581|6635->3600|6656->3611|6718->3651|6765->3670|6786->3681|6841->3714|6888->3733|6909->3744|6968->3781|7015->3800|7036->3811|7112->3865|7159->3884|7180->3895|7251->3944|7298->3963|7319->3974|7390->4023|7592->4193|7629->4202
                  LINES: 23->1|28->2|33->3|34->4|40->10|40->10|40->10|41->11|41->11|41->11|42->12|42->12|42->12|43->13|43->13|43->13|44->14|44->14|44->14|45->15|45->15|45->15|48->18|48->18|49->19|52->22|52->22|54->24|54->24|54->24|55->25|56->26|56->26|58->28|80->50|80->50|80->50|82->52|100->70|100->70|100->70|101->71|102->72|102->72|102->72|102->72|102->72|103->73|103->73|103->73|104->74|104->74|104->74|105->75|105->75|105->75|107->77|107->77|107->77|108->78|108->78|108->78|108->78|108->78|108->78|109->79|110->80|112->82|112->82|116->86|117->87|121->91|122->92|126->96|126->96|126->96|127->97|148->118|148->118|148->118|149->119|149->119|149->119|150->120|150->120|150->120|151->121|151->121|151->121|152->122|152->122|152->122|153->123|153->123|153->123|154->124|154->124|154->124|155->125|155->125|155->125|156->126|156->126|156->126|157->127|157->127|157->127|163->133|164->134
                  -- GENERATED --
              */
          