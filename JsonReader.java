import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.Scanner;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;



	

public class JsonReader{
	
	//	Routing Api:
	//
	//	https://route.api.here.com/routing/7.2/calculateroute.json
	//	?app_id={YOUR_APP_ID}
	//	&app_code={YOUR_APP_CODE}
	//	&waypoint0=geo!52.5,13.4
	//	&waypoint1=geo!52.5,13.45
	//	&mode=fastest;truck;traffic:disabled
	//	&limitedWeight=30.5
	//	&height=4.25
	//	&shippedHazardousGoods=harmfulToWater
	//  build a URL
	public static void urlCreator(float lattv, float longtv, float lattn, float longn ) throws IOException, org.json.simple.parser.ParseException{
		String str = "";
		try {
			String s = "https://route.api.here.com/routing/7.2/calculateroute.json" + 
						"?app_id=LqVBq2kLncuFdDyjhOQR"+
						"&app_code=LiEzG8Xcf1psY7BpLC5cbg" +
						"&waypoint0=geo!";
			String addr = lattv + "," + longtv;
			s += addr;
			s += "&waypoint1=geo!";
			addr = lattn + "," + longn;
			s += addr;
			s += "&mode=fastest;truck;traffic:disabled" + 
				"&limitedWeight=30.5" + 
				"&height=4.25" + 
				"&shippedHazardousGoods=harmfulToWater";
			System.out.println(s);
			URL url = new URL(s);
			
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responsecode = conn.getResponseCode();
			System.out.println("Response code is: " +responsecode);
			if(responsecode != 200)	throw new RuntimeException("HttpResponseCode: " +responsecode);
			
			else{
				Scanner sc = new Scanner(url.openStream());
				while(sc.hasNext()){
					str+=sc.nextLine();
					}
			//	System.out.println("\nJSON Response in String format"); 
				//System.out.println(str);
				sc.close();
			}
			conn.disconnect();
			
			JSONParser parse = new JSONParser();
			JSONObject jsonobj = (JSONObject) parse.parse(str);
			
			JSONObject respond = (JSONObject) jsonobj.get("response");
			JSONArray route = (JSONArray) respond.get("route");
			JSONObject zero = (JSONObject) route.get(0);
			JSONObject summary = (JSONObject) zero.get("summary");
			System.out.println(summary.get("distance"));
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
			}
		
	}
	
}
			





//{"response":{"metaInfo":{"timestamp":"2018-11-30T20:54:08Z","mapVersion":"8.30.90.154","moduleVersion":"7.2.201846-589","interfaceVersion":"2.6.34","availableMapVersion":["8.30.90.154"]},"route":[{"waypoint":[{"linkId":"-1129773223","mappedPosition":{"latitude":48.3990074,"longitude":9.9566398},"originalPosition":{"latitude":48.398872,"longitude":9.956896},"type":"stopOver","spot":0.44,"sideOfStreet":"left","mappedRoadName":"Magirus-Deutz-Straﬂe","label":"Magirus-Deutz-Straﬂe","shapeIndex":0},{"linkId":"+53150417","mappedPosition":{"latitude":48.3953963,"longitude":9.9564557},"originalPosition":{"latitude":48.3954729,"longitude":9.956896},"type":"stopOver","spot":0.35,"sideOfStreet":"right","mappedRoadName":"Schlossergasse","label":"Schlossergasse","shapeIndex":35}],"mode":{"type":"fastest","transportModes":["truck"],"trafficMode":"disabled","feature":[]},"leg":[{"start":{"linkId":"-1129773223","mappedPosition":{"latitude":48.3990074,"longitude":9.9566398},"originalPosition":{"latitude":48.398872,"longitude":9.956896},"type":"stopOver","spot":0.44,"sideOfStreet":"left","mappedRoadName":"Magirus-Deutz-Straﬂe","label":"Magirus-Deutz-Straﬂe","shapeIndex":0},"end":{"linkId":"+53150417","mappedPosition":{"latitude":48.3953963,"longitude":9.9564557},"originalPosition":{"latitude":48.3954729,"longitude":9.956896},"type":"stopOver","spot":0.35,"sideOfStreet":"right","mappedRoadName":"Schlossergasse","label":"Schlossergasse","shapeIndex":35},"length":1133,"travelTime":416,"maneuver":[{"position":{"latitude":48.3990074,"longitude":9.9566398},"instruction":"Head toward <span class=\"toward_street\">Einsteinstraﬂe</span> on <span class=\"street\">Magirus-Deutz-Straﬂe</span>. <span class=\"distance-description\">Go for <span class=\"length\">61 m</span>.</span>","travelTime":32,"length":61,"id":"M1","_type":"PrivateTransportManeuverType"},{"position":{"latitude":48.3987451,"longitude":9.9563491},"instruction":"Turn <span class=\"direction\">right</span> onto <span class=\"next-street\">Einsteinstraﬂe</span>. <span class=\"distance-description\">Go for <span class=\"length\">160 m</span>.</span>","travelTime":39,"length":160,"id":"M2","_type":"PrivateTransportManeuverType"},{"position":{"latitude":48.3992493,"longitude":9.9543428},"instruction":"Turn <span class=\"direction\">left</span> onto <span class=\"next-street\">J‰gerstraﬂe</span>. <span class=\"distance-description\">Go for <span class=\"length\">77 m</span>.</span>","travelTime":29,"length":77,"id":"M3","_type":"PrivateTransportManeuverType"},{"position":{"latitude":48.3986056,"longitude":9.9539459},"instruction":"Turn <span class=\"direction\">slightly left</span> onto <span class=\"next-street\">Klingensteiner Straﬂe</span>. <span class=\"distance-description\">Go for <span class=\"length\">175 m</span>.</span>","travelTime":58,"length":175,"id":"M4","_type":"PrivateTransportManeuverType"},{"position":{"latitude":48.3974791,"longitude":9.9555552},"instruction":"Turn <span class=\"direction\">slightly right</span> onto <span class=\"next-street\">Schlˆﬂlesgasse</span>. <span class=\"distance-description\">Go for <span class=\"length\">197 m</span>.</span>","travelTime":62,"length":197,"id":"M5","_type":"PrivateTransportManeuverType"},{"position":{"latitude":48.3957946,"longitude":9.9549651},"instruction":"Continue on <span class=\"next-street\">Gemeindeplatz</span>. <span class=\"distance-description\">Go for <span class=\"length\">32 m</span>.</span>","travelTime":21,"length":32,"id":"M6","_type":"PrivateTransportManeuverType"},{"position":{"latitude":48.3955693,"longitude":9.9546969},"instruction":"Turn <span class=\"direction\">slightly left</span> onto <span class=\"next-street\">Kapellengasse</span>. <span class=\"distance-description\">Go for <span class=\"length\">82 m</span>.</span>","travelTime":41,"length":82,"id":"M7","_type":"PrivateTransportManeuverType"},{"position":{"latitude":48.3948612,"longitude":9.9549115},"instruction":"Turn <span class=\"direction\">right</span> onto <span class=\"next-street\">Uhrenmachergasse</span>. <span class=\"distance-description\">Go for <span class=\"length\">7 m</span>.</span>","travelTime":6,"length":7,"id":"M8","_type":"PrivateTransportManeuverType"},{"position":{"latitude":48.3948183,"longitude":9.9548364},"instruction":"Continue on <span class=\"next-street\">Kapellengasse</span>. <span class=\"distance-description\">Go for <span class=\"length\">46 m</span>.</span>","travelTime":30,"length":46,"id":"M9","_type":"PrivateTransportManeuverType"},{"position":{"latitude":48.394475,"longitude":9.9549651},"instruction":"Continue on <span class=\"next-street\">Neue Gasse</span>. <span class=\"distance-description\">Go for <span class=\"length\">149 m</span>.</span>","travelTime":46,"length":149,"id":"M10","_type":"PrivateTransportManeuverType"},{"position":{"latitude":48.3945286,"longitude":9.9569821},"instruction":"Turn <span class=\"direction\">left</span> onto <span class=\"next-street\">Schlossergasse</span>. <span class=\"distance-description\">Go for <span class=\"length\">57 m</span>.</span>","travelTime":31,"length":57,"id":"M11","_type":"PrivateTransportManeuverType"},{"position":{"latitude":48.3949041,"longitude":9.9565852},"instruction":"Turn <span class=\"direction\">right</span> onto <span class=\"next-street\">Schlossergasse</span>. <span class=\"distance-description\">Go for <span class=\"length\">56 m</span>.</span>","travelTime":21,"length":56,"id":"M12","_type":"PrivateTransportManeuverType"},{"position":{"latitude":48.3953963,"longitude":9.9564557},"instruction":"Arrive at <span class=\"street\">Schlossergasse</span>. Your destination is on the right.","travelTime":5,"length":34,"id":"M13","_type":"PrivateTransportManeuverType"}]}],"summary":{"distance":1133,"trafficTime":416,"baseTime":416,"flags":["builtUpArea"],"text":"The trip takes <span class=\"length\">1.1 km</span> and <span class=\"time\">7 mins</span>.","travelTime":416,"_type":"RouteSummaryType"}}],"language":"en-us"}}

