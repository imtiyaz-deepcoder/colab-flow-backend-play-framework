// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:5
package controllers {

  // @LINE:8
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:17
  class ReverseDocumentWebSocketController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def documentSocket: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ws/documents")
    }
  
  }

  // @LINE:10
  class ReverseDocumentController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def getAllDocuments: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "documents")
    }
  
    // @LINE:11
    def createDocument(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "documents")
    }
  
  }

  // @LINE:14
  class ReverseChatController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def chatSocket: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ws/chat")
    }
  
  }

  // @LINE:5
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:5
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:20
  class ReverseLogStreamController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:20
    def streamLogs: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/stream/logs")
    }
  
  }


}
