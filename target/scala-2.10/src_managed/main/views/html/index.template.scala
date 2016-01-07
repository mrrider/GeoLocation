
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import controllers.routes.javascript._


Seq[Any](format.raw/*1.19*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/main("Geolocation")/*4.21*/ {_display_(Seq[Any](format.raw/*4.23*/("""
<script>
	$(document).ready(function() """),format.raw/*6.31*/("""{"""),format.raw/*6.32*/("""
		var myJson;
		jsRoutes.controllers.Application.getClientIp().ajax("""),format.raw/*8.55*/("""{"""),format.raw/*8.56*/("""
				type : "POST",
				dataType : "json",
				success : function(data) """),format.raw/*11.30*/("""{"""),format.raw/*11.31*/("""
					if(data.ip == "local" || data.ip == "new")"""),format.raw/*12.48*/("""{"""),format.raw/*12.49*/("""
						$.getJSON('http://ipinfo.io', function(data) """),format.raw/*13.52*/("""{"""),format.raw/*13.53*/("""
							myJson = data;
							$('.clientIdText').html(data.ip);
							$('.clientIdText').fadeIn('normal');
							$('.getLocationButton').fadeIn('normal');
							jsRoutes.controllers.Application.addClient(
								myJson.ip, myJson.city, myJson.country
							).ajax("""),format.raw/*20.15*/("""{"""),format.raw/*20.16*/("""
								type : "POST",
								dataType : "text",
								success : function(data) """),format.raw/*23.34*/("""{"""),format.raw/*23.35*/("""
								"""),format.raw/*24.9*/("""}"""),format.raw/*24.10*/(""",
								error : function(data) """),format.raw/*25.32*/("""{"""),format.raw/*25.33*/("""
									console.log("err");
								"""),format.raw/*27.9*/("""}"""),format.raw/*27.10*/("""
							"""),format.raw/*28.8*/("""}"""),format.raw/*28.9*/(""");
						"""),format.raw/*29.7*/("""}"""),format.raw/*29.8*/(""");
						
					"""),format.raw/*31.6*/("""}"""),format.raw/*31.7*/("""
					else"""),format.raw/*32.10*/("""{"""),format.raw/*32.11*/("""
						myJson = data;
						$('.clientIdText').html(data.ip);
						$('.clientIdText').fadeIn('normal');
						$('.getLocationButton').fadeIn('normal');
					"""),format.raw/*37.6*/("""}"""),format.raw/*37.7*/("""
				"""),format.raw/*38.5*/("""}"""),format.raw/*38.6*/(""",
				error : function(data) """),format.raw/*39.28*/("""{"""),format.raw/*39.29*/("""
					console.log("err");
				"""),format.raw/*41.5*/("""}"""),format.raw/*41.6*/("""
		"""),format.raw/*42.3*/("""}"""),format.raw/*42.4*/(""");
		
		$('.getLocationButton').one("click", function() """),format.raw/*44.51*/("""{"""),format.raw/*44.52*/("""
				$('.result').html(myJson.city.toLowerCase() + " - " + myJson.country.toLowerCase());					
				$('.result').fadeIn('normal');
				$(this).css("opacity","0.8");
				$(this).css("background-color","#cdcdcd");
				$(this).css("cursor","default");
		"""),format.raw/*50.3*/("""}"""),format.raw/*50.4*/(""");
	"""),format.raw/*51.2*/("""}"""),format.raw/*51.3*/(""");
	</script>
	<img class="logo" src=""""),_display_(Seq[Any](/*53.26*/routes/*53.32*/.Assets.at("images/location.png"))),format.raw/*53.65*/("""">
	<div class="wrapper">
		<div class="clientIdText"></div>
	   	<button class="getLocationButton" value="Get My Location">Get My Location</button>
	    <div class="result"></div>
    </div>
""")))})),format.raw/*59.2*/("""
"""))}
    }
    
    def render(message:String): play.api.templates.HtmlFormat.Appendable = apply(message)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jan 07 14:12:59 EET 2016
                    SOURCE: C:/Users/Rider/GeoLocation/app/views/index.scala.html
                    HASH: c368d15338e8bcfb861645183a2eba54b524d36f
                    MATRIX: 774->1|924->18|951->59|987->61|1014->80|1053->82|1120->122|1148->123|1244->192|1272->193|1372->265|1401->266|1477->314|1506->315|1586->367|1615->368|1912->637|1941->638|2053->722|2082->723|2118->732|2147->733|2208->766|2237->767|2302->805|2331->806|2366->814|2394->815|2430->824|2458->825|2500->840|2528->841|2566->851|2595->852|2780->1010|2808->1011|2840->1016|2868->1017|2925->1046|2954->1047|3011->1077|3039->1078|3069->1081|3097->1082|3181->1138|3210->1139|3487->1389|3515->1390|3546->1394|3574->1395|3649->1434|3664->1440|3719->1473|3943->1666
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|34->6|34->6|36->8|36->8|39->11|39->11|40->12|40->12|41->13|41->13|48->20|48->20|51->23|51->23|52->24|52->24|53->25|53->25|55->27|55->27|56->28|56->28|57->29|57->29|59->31|59->31|60->32|60->32|65->37|65->37|66->38|66->38|67->39|67->39|69->41|69->41|70->42|70->42|72->44|72->44|78->50|78->50|79->51|79->51|81->53|81->53|81->53|87->59
                    -- GENERATED --
                */
            