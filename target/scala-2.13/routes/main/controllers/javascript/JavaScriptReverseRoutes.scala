// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:5
package controllers.javascript {

  // @LINE:8
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:17
  class ReverseDocumentWebSocketController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def documentSocket: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DocumentWebSocketController.documentSocket",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ws/documents"})
        }
      """
    )
  
  }

  // @LINE:10
  class ReverseDocumentController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def getAllDocuments: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DocumentController.getAllDocuments",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "documents"})
        }
      """
    )
  
    // @LINE:11
    def createDocument: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DocumentController.createDocument",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "documents"})
        }
      """
    )
  
  }

  // @LINE:14
  class ReverseChatController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def chatSocket: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ChatController.chatSocket",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ws/chat"})
        }
      """
    )
  
  }

  // @LINE:5
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:5
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:20
  class ReverseLogStreamController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:20
    def streamLogs: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LogStreamController.streamLogs",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/stream/logs"})
        }
      """
    )
  
  }


}
