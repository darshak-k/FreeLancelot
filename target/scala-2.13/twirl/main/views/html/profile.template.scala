
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


Seq[Any](format.raw/*2.77*/("""

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
				<button style="background-color: deepskyblue; color: white; width: 110px; height: 35px; margin-left: 20px; border-radius: 10px; font-weight: bold"  type="submit">Go</button>
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

									<td><a href="/localStats/"""),_display_(/*82.36*/{project.getOwner_id()}),format.raw/*82.59*/("""" > stats </a></td>

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
								<td>"""),_display_(/*122.14*/profileData/*122.25*/.getProfiledata().getRegistrationdate()),format.raw/*122.64*/("""</td>
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
                  HASH: 72eb977cc3a76a8f9725fe6ea516ef52dcdbe028
                  MATRIX: 610->1|980->35|1150->110|1180->114|1399->306|1414->312|1476->353|1552->402|1567->408|1630->450|1706->499|1721->505|1788->551|1870->606|1885->612|1945->651|1990->669|2005->675|2067->716|2145->767|2160->773|2222->814|2312->876|2341->877|2371->880|2448->930|2476->931|2507->935|2539->940|2567->941|2597->944|2644->964|2672->965|2703->969|3443->1683|3496->1720|3536->1722|3573->1732|3966->2099|4024->2141|4064->2143|4101->2153|4170->2195|4214->2218|4246->2223|4262->2230|4297->2244|4349->2269|4365->2276|4403->2293|4451->2314|4467->2321|4499->2332|4547->2353|4563->2360|4594->2370|4654->2403|4701->2434|4740->2435|4781->2448|4826->2466|4862->2481|4894->2486|4908->2491|4939->2501|4987->2518|5026->2529|5097->2573|5141->2596|5219->2644|5254->2652|5346->2714|5377->2718|5456->2770|5505->2803|5545->2805|5591->2823|6262->3466|6283->3477|6330->3502|6402->3546|6423->3557|6476->3588|6524->3608|6545->3619|6601->3653|6649->3673|6670->3684|6719->3711|6767->3731|6788->3742|6849->3781|6897->3801|6918->3812|6973->3845|7021->3865|7042->3876|7101->3913|7149->3933|7170->3944|7246->3998|7294->4018|7315->4029|7386->4078|7434->4098|7455->4109|7526->4158|7734->4334|7772->4344
                  LINES: 23->1|28->2|33->2|35->4|41->10|41->10|41->10|42->11|42->11|42->11|43->12|43->12|43->12|44->13|44->13|44->13|45->14|45->14|45->14|46->15|46->15|46->15|49->18|49->18|50->19|53->22|53->22|55->24|55->24|55->24|56->25|57->26|57->26|59->28|81->50|81->50|81->50|83->52|101->70|101->70|101->70|102->71|103->72|103->72|103->72|103->72|103->72|104->73|104->73|104->73|105->74|105->74|105->74|106->75|106->75|106->75|108->77|108->77|108->77|109->78|109->78|109->78|109->78|109->78|109->78|110->79|111->80|113->82|113->82|117->86|118->87|122->91|123->92|127->96|127->96|127->96|128->97|149->118|149->118|149->118|150->119|150->119|150->119|151->120|151->120|151->120|152->121|152->121|152->121|153->122|153->122|153->122|154->123|154->123|154->123|155->124|155->124|155->124|156->125|156->125|156->125|157->126|157->126|157->126|158->127|158->127|158->127|164->133|165->134
                  -- GENERATED --
              */
          