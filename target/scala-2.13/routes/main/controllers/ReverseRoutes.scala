// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:9
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:15
  class ReverseDocumentWebSocketController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def documentSocket: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ws/documents")
    }
  
  }

  // @LINE:11
  class ReverseDocumentController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def getAllDocuments: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "documents")
    }
  
    // @LINE:12
    def createDocument(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "documents")
    }
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:17
  class ReverseLogStreamController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def streamLogs: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/stream/logs")
    }
  
  }

  // @LINE:14
  class ReverseWebSocketController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def socket: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ws/ping")
    }
  
  }


}
