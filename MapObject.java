import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MapObject implements Comparable<MapObject> {
	private	int trans;
	private	int lief;
	private	String von;
	private	float latv;
	private	float lonv;
	private	String nach;
	private	float latn;
	private	float lonn;
	

	public MapObject(int trans,	int lief, String von, float latv, float lonv, String nach, float latn, float lonn) {
		this.trans = trans;
		this.lief = lief;
		this.von = von;
		this.latv = latv;
		this.lonv = lonv;
		this.nach = nach;
		this.latn = latn;
		this.lonn = lonn;
			
	}
	public boolean myComparetor(MapObject a, MapObject b) {
		if(a.trans > b.trans) return true;
		return false;
	}
	@Override
	public int compareTo(MapObject mobj) {
		return this.trans - mobj.trans;
		
	}

	public static ArrayList<MapObject> readCSV(String file, ArrayList<MapObject> TransList) {
		//LinkedList<MapObject> TransList = new LinkedList<MapObject>();
        String line = "";
  
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        	br.readLine(); //pass first line
            while ((line = br.readLine()) != null) {
            	
                String[] obje = line.split(";");
//                for(int i = 0; i < obje.length; i++) {
//                	System.out.print(obje[i] + "{" + i + "}" + "\t");
//                }
                MapObject x = new MapObject(Integer.parseInt(obje[0]),Integer.parseInt(obje[1]), obje[2], Float.parseFloat(obje[3]), Float.parseFloat(obje[4]), obje[5], Float.parseFloat(obje[6]), Float.parseFloat(obje[7]));
              TransList.add(x);
               // System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return TransList;
	}

	
	
	public int getTrans() {
		return trans;
	}


	public void setTrans(int trans) {
		this.trans = trans;
	}


	public int getLief() {
		return lief;
	}


	public void setLief(int lief) {
		this.lief = lief;
	}


	public String getVon() {
		return von;
	}


	public void setVon(String von) {
		this.von = von;
	}


	public float getLatv() {
		return latv;
	}


	public void setLatv(float latv) {
		this.latv = latv;
	}


	public float getLonv() {
		return lonv;
	}


	public void setLonv(float lonv) {
		this.lonv = lonv;
	}


	public String getNach() {
		return nach;
	}


	public void setNach(String nach) {
		this.nach = nach;
	}


	public float getLatn() {
		return latn;
	}


	public void setLatn(float latn) {
		this.latn = latn;
	}


	public float getLonn() {
		return lonn;
	}


	public void setLonn(float lonn) {
		this.lonn = lonn;
	}

	
}
