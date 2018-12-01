import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;

public class Main {

	public static void main(String[] args) throws IOException, ParseException, InterruptedException {
		ArrayList<MapObject> x = new ArrayList<MapObject>();
		
		MapObject.readCSV("/home/guney/Desktop/testdata.csv", x);
		
//		for(int i = 0; i < x.size(); i++) {
//			System.out.println(x.get(i).getVon());
//		}
//		Collections.sort(x);
//		for(int i = 0; i < x.size(); i++) {
//			
//			System.out.println(x.get(i).getVon() + " : " + x.get(i).getNach() + " : " + x.get(i).getLatv() + " : " +x.get(i).getLonv() + " : " +x.get(i).getLatn() + " : " +x.get(i).getLonn());
//			JsonReader.urlCreator(x.get(i).getLatv(), x.get(i).getLonv(), x.get(i).getLatn(), x.get(i).getLonn());	
//			//TimeUnit.SECONDS.sleep(2);
//		}
		//System.out.println(x.get(4).getVon() + " : " + x.get(4).getLief() + " : " + x.get(4).getLatv() + " : " +x.get(4).getLonv() + " : " +x.get(4).getLatn() + " : " +x.get(4).getLonn());
		JsonReader.urlCreator(x.get(1).getLatv(), x.get(1).getLonv(), x.get(1).getLatn(), x.get(1).getLonn());	
		

	}
}