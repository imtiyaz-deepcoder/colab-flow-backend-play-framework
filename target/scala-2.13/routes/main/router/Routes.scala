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
  HomeController_5: controllers.HomeController,
  // @LINE:9
  Assets_3: controllers.Assets,
  // @LINE:11
  DocumentController_2: controllers.DocumentController,
  // @LINE:14
  WebSocketController_0: controllers.WebSocketController,
  // @LINE:15
  DocumentWebSocketController_1: controllers.DocumentWebSocketController,
  // @LINE:17
  LogStreamController_4: controllers.LogStreamController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_5: controllers.HomeController,
    // @LINE:9
    Assets_3: controllers.Assets,
    // @LINE:11
    DocumentController_2: controllers.DocumentController,
    // @LINE:14
    WebSocketController_0: controllers.WebSocketController,
    // @LINE:15
    DocumentWebSocketController_1: controllers.DocumentWebSocketController,
    // @LINE:17
    LogStreamController_4: controllers.LogStreamController
  ) = this(errorHandler, HomeController_5, Assets_3, DocumentController_2, WebSocketController_0, DocumentWebSocketController_1, LogStreamController_4, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_5, Assets_3, DocumentController_2, WebSocketController_0, DocumentWebSocketController_1, LogStreamController_4, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """documents""", """controllers.DocumentController.getAllDocuments"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """documents""", """controllers.DocumentController.createDocument(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ws/ping""", """controllers.WebSocketController.socket"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ws/documents""", """controllers.DocumentWebSocketController.documentSocket"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/stream/logs""", """controllers.LogStreamController.streamLogs"""),
    Nil
  ).foldLeft(Seq.empty[(String, String, String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String, String, String)]
    case l => s ++ l.asInstanceOf[List[(String, String, String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_5.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Assets_versioned1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned1_invoker = createInvoker(
    Assets_3.versioned(fakeValue[String], fakeValue[Asset]),
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

  // @LINE:11
  private[this] lazy val controllers_DocumentController_getAllDocuments2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("documents")))
  )
  private[this] lazy val controllers_DocumentController_getAllDocuments2_invoker = createInvoker(
    DocumentController_2.getAllDocuments,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DocumentController",
      "getAllDocuments",
      Nil,
      "GET",
      this.prefix + """documents""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_DocumentController_createDocument3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("documents")))
  )
  private[this] lazy val controllers_DocumentController_createDocument3_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      DocumentController_2.createDocument(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DocumentController",
      "createDocument",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """documents""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_WebSocketController_socket4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ws/ping")))
  )
  private[this] lazy val controllers_WebSocketController_socket4_invoker = createInvoker(
    WebSocketController_0.socket,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.WebSocketController",
      "socket",
      Nil,
      "GET",
      this.prefix + """ws/ping""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_DocumentWebSocketController_documentSocket5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ws/documents")))
  )
  private[this] lazy val controllers_DocumentWebSocketController_documentSocket5_invoker = createInvoker(
    DocumentWebSocketController_1.documentSocket,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DocumentWebSocketController",
      "documentSocket",
      Nil,
      "GET",
      this.prefix + """ws/documents""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_LogStreamController_streamLogs6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/stream/logs")))
  )
  private[this] lazy val controllers_LogStreamController_streamLogs6_invoker = createInvoker(
    LogStreamController_4.streamLogs,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LogStreamController",
      "streamLogs",
      Nil,
      "GET",
      this.prefix + """api/stream/logs""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_5.index())
      }
  
    // @LINE:9
    case controllers_Assets_versioned1_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned1_invoker.call(Assets_3.versioned(path, file))
      }
  
    // @LINE:11
    case controllers_DocumentController_getAllDocuments2_route(params@_) =>
      call { 
        controllers_DocumentController_getAllDocuments2_invoker.call(DocumentController_2.getAllDocuments)
      }
  
    // @LINE:12
    case controllers_DocumentController_createDocument3_route(params@_) =>
      call { 
        controllers_DocumentController_createDocument3_invoker.call(
          req => DocumentController_2.createDocument(req))
      }
  
    // @LINE:14
    case controllers_WebSocketController_socket4_route(params@_) =>
      call { 
        controllers_WebSocketController_socket4_invoker.call(WebSocketController_0.socket)
      }
  
    // @LINE:15
    case controllers_DocumentWebSocketController_documentSocket5_route(params@_) =>
      call { 
        controllers_DocumentWebSocketController_documentSocket5_invoker.call(DocumentWebSocketController_1.documentSocket)
      }
  
    // @LINE:17
    case controllers_LogStreamController_streamLogs6_route(params@_) =>
      call { 
        controllers_LogStreamController_streamLogs6_invoker.call(LogStreamController_4.streamLogs)
      }
  }
}
