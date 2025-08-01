// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseDocumentWebSocketController DocumentWebSocketController = new controllers.ReverseDocumentWebSocketController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseDocumentController DocumentController = new controllers.ReverseDocumentController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseLogStreamController LogStreamController = new controllers.ReverseLogStreamController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseWebSocketController WebSocketController = new controllers.ReverseWebSocketController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseDocumentWebSocketController DocumentWebSocketController = new controllers.javascript.ReverseDocumentWebSocketController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseDocumentController DocumentController = new controllers.javascript.ReverseDocumentController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseLogStreamController LogStreamController = new controllers.javascript.ReverseLogStreamController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseWebSocketController WebSocketController = new controllers.javascript.ReverseWebSocketController(RoutesPrefix.byNamePrefix());
  }

}
