// @SOURCE:C:/Users/Rider/GeoLocation/conf/routes
// @HASH:a3ec0b10b17dae40f187ac4f0794b3f0f17337f3
// @DATE:Thu Jan 07 14:08:18 EET 2016

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:11
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:11
class ReverseAssets {
    

// @LINE:11
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:8
def getClientIp(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "return")
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                

// @LINE:7
def addClient(ip:String, city:String, country:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "client" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("ip", ip)), Some(implicitly[QueryStringBindable[String]].unbind("city", city)), Some(implicitly[QueryStringBindable[String]].unbind("country", country)))))
}
                                                

// @LINE:9
def javascriptRoutes(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/javascripts/routes")
}
                                                
    
}
                          
}
                  


// @LINE:11
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:11
class ReverseAssets {
    

// @LINE:11
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:8
def getClientIp : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getClientIp",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "return"})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:7
def addClient : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.addClient",
   """
      function(ip,city,country) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "client" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("ip", ip), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("city", city), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("country", country)])})
      }
   """
)
                        

// @LINE:9
def javascriptRoutes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.javascriptRoutes",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/javascripts/routes"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:11
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:11
class ReverseAssets {
    

// @LINE:11
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:8
def getClientIp(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getClientIp(), HandlerDef(this, "controllers.Application", "getClientIp", Seq(), "POST", """""", _prefix + """return""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:7
def addClient(ip:String, city:String, country:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.addClient(ip, city, country), HandlerDef(this, "controllers.Application", "addClient", Seq(classOf[String], classOf[String], classOf[String]), "POST", """""", _prefix + """client""")
)
                      

// @LINE:9
def javascriptRoutes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.javascriptRoutes(), HandlerDef(this, "controllers.Application", "javascriptRoutes", Seq(), "GET", """""", _prefix + """assets/javascripts/routes""")
)
                      
    
}
                          
}
        
    