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
  FreelancerController_1: controllers.FreelancerController,
  // @LINE:15
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    FreelancerController_1: controllers.FreelancerController,
    // @LINE:15
    Assets_0: controllers.Assets
  ) = this(errorHandler, FreelancerController_1, Assets_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, FreelancerController_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.FreelancerController.index(request:play.mvc.Http.Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """search""", """controllers.FreelancerController.search(inputKeyword:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """profile/""" + "$" + """ownerID<[^/]+>""", """controllers.FreelancerController.profile(ownerID:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """profiledata/""" + "$" + """ownerID<[^/]+>""", """controllers.FreelancerController.profileData(ownerID:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """globalStats""", """controllers.FreelancerController.globalStats()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """localStats/""" + "$" + """projectID<[^/]+>""", """controllers.FreelancerController.localStats(projectID:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """skills/""" + "$" + """skillId<[^/]+>""", """controllers.FreelancerController.skills(skillId:Integer)"""),
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
    
    (req:play.mvc.Http.Request) =>
      FreelancerController_1.index(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FreelancerController",
      "index",
      Seq(classOf[play.mvc.Http.Request]),
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
    FreelancerController_1.search(fakeValue[String]),
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
    FreelancerController_1.profile(fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FreelancerController",
      "profile",
      Seq(classOf[Integer]),
      "GET",
      this.prefix + """profile/""" + "$" + """ownerID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_FreelancerController_profileData3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("profiledata/"), DynamicPart("ownerID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_FreelancerController_profileData3_invoker = createInvoker(
    FreelancerController_1.profileData(fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FreelancerController",
      "profileData",
      Seq(classOf[Integer]),
      "GET",
      this.prefix + """profiledata/""" + "$" + """ownerID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_FreelancerController_globalStats4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("globalStats")))
  )
  private[this] lazy val controllers_FreelancerController_globalStats4_invoker = createInvoker(
    FreelancerController_1.globalStats(),
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

  // @LINE:11
  private[this] lazy val controllers_FreelancerController_localStats5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("localStats/"), DynamicPart("projectID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_FreelancerController_localStats5_invoker = createInvoker(
    FreelancerController_1.localStats(fakeValue[String]),
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

  // @LINE:12
  private[this] lazy val controllers_FreelancerController_skills6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("skills/"), DynamicPart("skillId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_FreelancerController_skills6_invoker = createInvoker(
    FreelancerController_1.skills(fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FreelancerController",
      "skills",
      Seq(classOf[Integer]),
      "GET",
      this.prefix + """skills/""" + "$" + """skillId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_Assets_versioned7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned7_invoker = createInvoker(
    Assets_0.versioned(fakeValue[String], fakeValue[Asset]),
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
        controllers_FreelancerController_index0_invoker.call(
          req => FreelancerController_1.index(req))
      }
  
    // @LINE:7
    case controllers_FreelancerController_search1_route(params@_) =>
      call(params.fromQuery[String]("inputKeyword", None)) { (inputKeyword) =>
        controllers_FreelancerController_search1_invoker.call(FreelancerController_1.search(inputKeyword))
      }
  
    // @LINE:8
    case controllers_FreelancerController_profile2_route(params@_) =>
      call(params.fromPath[Integer]("ownerID", None)) { (ownerID) =>
        controllers_FreelancerController_profile2_invoker.call(FreelancerController_1.profile(ownerID))
      }
  
    // @LINE:9
    case controllers_FreelancerController_profileData3_route(params@_) =>
      call(params.fromPath[Integer]("ownerID", None)) { (ownerID) =>
        controllers_FreelancerController_profileData3_invoker.call(FreelancerController_1.profileData(ownerID))
      }
  
    // @LINE:10
    case controllers_FreelancerController_globalStats4_route(params@_) =>
      call { 
        controllers_FreelancerController_globalStats4_invoker.call(FreelancerController_1.globalStats())
      }
  
    // @LINE:11
    case controllers_FreelancerController_localStats5_route(params@_) =>
      call(params.fromPath[String]("projectID", None)) { (projectID) =>
        controllers_FreelancerController_localStats5_invoker.call(FreelancerController_1.localStats(projectID))
      }
  
    // @LINE:12
    case controllers_FreelancerController_skills6_route(params@_) =>
      call(params.fromPath[Integer]("skillId", None)) { (skillId) =>
        controllers_FreelancerController_skills6_invoker.call(FreelancerController_1.skills(skillId))
      }
  
    // @LINE:15
    case controllers_Assets_versioned7_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned7_invoker.call(Assets_0.versioned(path, file))
      }
  }
}
