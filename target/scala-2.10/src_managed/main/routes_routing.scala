// @SOURCE:C:/Users/Rider/GeoLocation/conf/routes
// @HASH:a3ec0b10b17dae40f187ac4f0794b3f0f17337f3
// @DATE:Thu Jan 07 14:08:18 EET 2016


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:7
private[this] lazy val controllers_Application_addClient1 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("client"))))
        

// @LINE:8
private[this] lazy val controllers_Application_getClientIp2 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("return"))))
        

// @LINE:9
private[this] lazy val controllers_Application_javascriptRoutes3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/javascripts/routes"))))
        

// @LINE:11
private[this] lazy val controllers_Assets_at4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """client""","""controllers.Application.addClient(ip:String, city:String, country:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """return""","""controllers.Application.getClientIp()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/javascripts/routes""","""controllers.Application.javascriptRoutes()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:7
case controllers_Application_addClient1(params) => {
   call(params.fromQuery[String]("ip", None), params.fromQuery[String]("city", None), params.fromQuery[String]("country", None)) { (ip, city, country) =>
        invokeHandler(controllers.Application.addClient(ip, city, country), HandlerDef(this, "controllers.Application", "addClient", Seq(classOf[String], classOf[String], classOf[String]),"POST", """""", Routes.prefix + """client"""))
   }
}
        

// @LINE:8
case controllers_Application_getClientIp2(params) => {
   call { 
        invokeHandler(controllers.Application.getClientIp(), HandlerDef(this, "controllers.Application", "getClientIp", Nil,"POST", """""", Routes.prefix + """return"""))
   }
}
        

// @LINE:9
case controllers_Application_javascriptRoutes3(params) => {
   call { 
        invokeHandler(controllers.Application.javascriptRoutes(), HandlerDef(this, "controllers.Application", "javascriptRoutes", Nil,"GET", """""", Routes.prefix + """assets/javascripts/routes"""))
   }
}
        

// @LINE:11
case controllers_Assets_at4(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     