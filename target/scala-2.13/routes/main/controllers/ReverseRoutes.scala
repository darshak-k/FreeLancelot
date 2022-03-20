// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:15
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:6
  class ReverseFreelancerController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def search(inputKeyword:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "search" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("inputKeyword", inputKeyword)))))
    }
  
    // @LINE:12
    def skills(skillId:Integer): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "skills/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("skillId", skillId)))
    }
  
    // @LINE:10
    def globalStats(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "globalStats")
    }
  
    // @LINE:11
    def localStats(projectID:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "localStats/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("projectID", projectID)))
    }
  
    // @LINE:8
    def profile(ownerID:Integer): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "profile/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("ownerID", ownerID)))
    }
  
    // @LINE:9
    def profileData(ownerID:Integer): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "profiledata/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("ownerID", ownerID)))
    }
  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }


}
