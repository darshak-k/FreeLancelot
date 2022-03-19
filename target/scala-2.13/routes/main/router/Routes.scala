// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  FreelancerController_0: controllers.FreelancerController,
  // @LINE:14
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    FreelancerController_0: controllers.FreelancerController,
    // @LINE:14
    Assets_1: controllers.Assets
  ) = this(errorHandler, FreelancerController_0, Assets_1, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, FreelancerController_0, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.FreelancerController.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """search""", """controllers.FreelancerController.search(inputKeyword:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """profile/""" + "$" + """ownerID<[^/]+>""", """controllers.FreelancerController.profile(ownerID:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """globalStats""", """controllers.FreelancerController.globalStats()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """localStats/""" + "$" + """projectID<[^/]+>""", """controllers.FreelancerController.localStats(projectID:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """skills/""" + "$" + """skillName<[^/]+>""", """controllers.FreelancerController.skills(skillName:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_FreelancerController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_FreelancerController_index0_invoker = createInvoker(
    FreelancerController_0.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FreelancerController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_FreelancerController_search1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("search")))
  )
  private[this] lazy val controllers_FreelancerController_search1_invoker = createInvoker(
    FreelancerController_0.search(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FreelancerController",
      "search",
      Seq(classOf[String]),
      "GET",
      this.prefix + """search""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_FreelancerController_profile2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("profile/"), DynamicPart("ownerID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_FreelancerController_profile2_invoker = createInvoker(
    FreelancerController_0.profile(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FreelancerController",
      "profile",
      Seq(classOf[String]),
      "GET",
      this.prefix + """profile/""" + "$" + """ownerID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_FreelancerController_globalStats3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("globalStats")))
  )
  private[this] lazy val controllers_FreelancerController_globalStats3_invoker = createInvoker(
    FreelancerController_0.globalStats(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FreelancerController",
      "globalStats",
      Nil,
      "GET",
      this.prefix + """globalStats""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_FreelancerController_localStats4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("localStats/"), DynamicPart("projectID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_FreelancerController_localStats4_invoker = createInvoker(
    FreelancerController_0.localStats(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FreelancerController",
      "localStats",
      Seq(classOf[String]),
      "GET",
      this.prefix + """localStats/""" + "$" + """projectID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_FreelancerController_skills5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("skills/"), DynamicPart("skillName", """[^/]+""",true)))
  )
  private[this] lazy val controllers_FreelancerController_skills5_invoker = createInvoker(
    FreelancerController_0.skills(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FreelancerController",
      "skills",
      Seq(classOf[String]),
      "GET",
      this.prefix + """skills/""" + "$" + """skillName<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_Assets_versioned6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned6_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_FreelancerController_index0_route(params@_) =>
      call { 
        controllers_FreelancerController_index0_invoker.call(FreelancerController_0.index())
      }
  
    // @LINE:7
    case controllers_FreelancerController_search1_route(params@_) =>
      call(params.fromQuery[String]("inputKeyword", None)) { (inputKeyword) =>
        controllers_FreelancerController_search1_invoker.call(FreelancerController_0.search(inputKeyword))
      }
  
    // @LINE:8
    case controllers_FreelancerController_profile2_route(params@_) =>
      call(params.fromPath[String]("ownerID", None)) { (ownerID) =>
        controllers_FreelancerController_profile2_invoker.call(FreelancerController_0.profile(ownerID))
      }
  
    // @LINE:9
    case controllers_FreelancerController_globalStats3_route(params@_) =>
      call { 
        controllers_FreelancerController_globalStats3_invoker.call(FreelancerController_0.globalStats())
      }
  
    // @LINE:10
    case controllers_FreelancerController_localStats4_route(params@_) =>
      call(params.fromPath[String]("projectID", None)) { (projectID) =>
        controllers_FreelancerController_localStats4_invoker.call(FreelancerController_0.localStats(projectID))
      }
  
    // @LINE:11
    case controllers_FreelancerController_skills5_route(params@_) =>
      call(params.fromPath[String]("skillName", None)) { (skillName) =>
        controllers_FreelancerController_skills5_invoker.call(FreelancerController_0.skills(skillName))
      }
  
    // @LINE:14
    case controllers_Assets_versioned6_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned6_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
