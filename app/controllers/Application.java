package controllers;

import java.io.IOException;

import org.apache.http.HttpResponse;

import com.fasterxml.jackson.databind.node.ObjectNode;

import models.Client;
import play.Routes;
import play.libs.F.Promise;
import play.libs.Json;
import play.libs.WS;
import play.libs.WS.Response;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {

	public static Result index() {
		return ok(index.render("Geolocation"));
	}

	public static Result javascriptRoutes() {
		response().setContentType("text/javascript");
		return ok(Routes.javascriptRouter("jsRoutes", routes.javascript.Application.addClient(),
				routes.javascript.Application.getClientIp()));
	}

	public static Result addClient(String ip, String city, String country) {
		if (Client.findIp(ip) == null) {
			Client newCl = new Client(ip, city, country);
			if (city.equals("") || city == null) {
				newCl.clientCity = "city not identified";
			}
			if (country.equals("") || country == null) {
				newCl.clientCountry = "country not identified";
			}
			newCl.save();
			return redirect(routes.Application.index());
		}
		return redirect(routes.Application.index());
	}

	private static String localhostIp = "0:0:0:0:0:0:0:1";

	public static Result getClientIp() throws IOException {
		ObjectNode result = Json.newObject();
		String clip = request().remoteAddress();
		if (clip.equals(localhostIp)) {
			result.put("ip", "local");
			return ok(result);
		} else {
			Client dbCl = Client.findIp(clip);
			if (dbCl == null) {
				result.put("ip", "new");
				return ok(result);
			} else {
				result.put("city", dbCl.clientCity);
				result.put("country", dbCl.clientCountry);
				result.put("ip", dbCl.clientIp);
				return ok(result);
			}
		}
	}
}
