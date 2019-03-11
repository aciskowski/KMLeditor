package Model;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

import de.micromata.opengis.kml.v_2_2_0.Coordinate;
import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Feature;
import de.micromata.opengis.kml.v_2_2_0.Folder;
import de.micromata.opengis.kml.v_2_2_0.Geometry;
import de.micromata.opengis.kml.v_2_2_0.IconStyle;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.LineString;
import de.micromata.opengis.kml.v_2_2_0.LineStyle;
import de.micromata.opengis.kml.v_2_2_0.MultiGeometry;
import de.micromata.opengis.kml.v_2_2_0.Placemark;
import de.micromata.opengis.kml.v_2_2_0.Point;
import de.micromata.opengis.kml.v_2_2_0.PolyStyle;
import de.micromata.opengis.kml.v_2_2_0.Style;
import de.micromata.opengis.kml.v_2_2_0.StyleSelector;

public class KMLModel {

	final private String BALLONSTYLETEXT = "<![CDATA[<h3>$[name]</h3>]]>";

	private Marshaller marshaller;
	private Unmarshaller unmarshaller;
	private JAXBContext jaxbcontext;

	private Kml kml;
	private List<Kml> kmlList;

	private Document document;
	private List<Feature> features;
	private List<StyleSelector> styles;
	private List<Placemark> placemarks;
	private List<LineString> lineStrings; //lista dla konkretnego placemarku

	
	private Boolean errorflag = false;
	private String ErrorMassage = "";

	public KMLModel() {
		try {
			jaxbcontext = JAXBContext.newInstance(Kml.class);
			marshaller = jaxbcontext.createMarshaller();
			unmarshaller = jaxbcontext.createUnmarshaller();

			kml = new Kml();

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorflag = true;
			ErrorMassage = e.getMessage();
		}
	}

	public List<Kml> getKmlList() {
		return kmlList;
	}

	
	public List<Feature> getFeatures() {
		return features;
	}

	public List<Placemark> getPlacemarks() {
		return placemarks;
	}

	public void setKmlList(List<Kml> kmlList) {
		this.kmlList = kmlList;
	}
	

	public List<LineString> getLineStrings() {
		return lineStrings;
	}

	public void readKML(String path) {

		try {
			kml = (Kml) unmarshaller.unmarshal(new File(path));
			document = (Document) kml.getFeature();
			features = document.getFeature();
			styles = document.getStyleSelector();

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorflag = true;
			ErrorMassage = e.getMessage();
		}
	}
	
	public void readKML(File file) {
		
		try {
			kml = (Kml) unmarshaller.unmarshal(file);
			document = (Document) kml.getFeature();
			features = document.getFeature();
			styles = document.getStyleSelector();

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorflag = true;
			ErrorMassage = e.getMessage();
		}
	}
	
	public void readKML(Kml kml) {
		this.kml = kml;
		document = (Document) kml.getFeature();
		features = document.getFeature();
		styles = document.getStyleSelector();
 
	}
	

	public void splitKml() {

		kmlList = new ArrayList<Kml>();
		Document doc = new Document();

		for (int i = 0; i <= features.size()-1; i++) {
			kmlList.add(new Kml());
			doc = kmlList.get(i).createAndSetDocument();
			doc.setName(features.get(i).getName());
			doc.setStyleSelector(styles);
			doc.addToFeature(features.get(i));

			// System.out.println(features.get(i).getName());
			// System.out.println(features.size());
			// document.getFeature().remove(i);
		}
		// return KMLlist;
	}

	public void saveKml(String path) {

		try {
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new NamespacePrefixMapper() {
				@Override
				public String getPreferredPrefix(String arg0, String arg1, boolean arg2) {
					// TODO Auto-generated method stub
					return arg0.matches("http://www.opengis.net/kml/.*?") ? "" : null;
				}
			});
			marshaller.marshal(kml, new File(path + "\\" + document.getName() + ".kml"));

		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			errorflag = true;
			ErrorMassage = e1.getMessage();
		}
	}
	
	public void saveKml(File file) {
		
		try {
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new NamespacePrefixMapper() {
				@Override
				public String getPreferredPrefix(String arg0, String arg1, boolean arg2) {
					// TODO Auto-generated method stub
					return arg0.matches("http://www.opengis.net/kml/.*?") ? "" : null;
				}
			});
			marshaller.marshal(kml, file);

		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			errorflag = true;
			ErrorMassage = e1.getMessage();
		}
	}

	public void saveKmlList(String path) {

		try {
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new NamespacePrefixMapper() {
				@Override
				public String getPreferredPrefix(String arg0, String arg1, boolean arg2) {
					// TODO Auto-generated method stub
					return arg0.matches("http://www.opengis.net/kml/.*?") ? "" : null;
				}
			});
			for (int i = 0; i <= kmlList.size() - 1; i++) {
				marshaller.marshal(kmlList.get(i),
						new File(path + "\\" + kmlList.get(i).getFeature().getName() + ".kml"));
			}

		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			errorflag = true;
			ErrorMassage = e1.getMessage();
		}

	}
	
	public void createPlacemarksList() {
		placemarks = new ArrayList<Placemark>();
		
		Iterator<Feature> it, itf;
		Feature f;
		Folder fl;
		Placemark pm;
		
		it = document.getFeature().iterator();
		
		while (it.hasNext()) {
			f = it.next();
			if(f instanceof Folder) {
				fl = (Folder) f;
				itf = fl.getFeature().iterator();
				
				while(itf.hasNext()) {
					f = itf.next();
					if (f instanceof Placemark) {
						pm = (Placemark) f;
						placemarks.add(pm);
					}
				}
			
			}else if(f instanceof Placemark) {
				pm = (Placemark) f;
				placemarks.add(pm);
			}
		}
	}
	
	public String getGeometryName(Placemark pm) {
		
		return pm.getGeometry().getClass().getSimpleName();
	}
	
	public List<LineString> createLinesListForPlacemark(Placemark pm) {
		
		lineStrings = new ArrayList<LineString>();
		
		LineString ls = null;
		MultiGeometry mg = null;
		
		if(pm.getGeometry() instanceof LineString) {
			ls = (LineString) pm.getGeometry();
			lineStrings.add(ls);
		}else if(pm.getGeometry() instanceof MultiGeometry) {
			mg = (MultiGeometry) pm.getGeometry();
			for(Geometry geo:mg.getGeometry()) {
				if(geo instanceof LineString) {
					ls = (LineString) geo;
					lineStrings.add(ls);
				}
			}
		}
		
		return lineStrings;
	}
	
	public List<Coor> getCoordinatesLineString(LineString ls){
		
		List<Coor> coors = new ArrayList<Coor>();
		
		for(Coordinate coordinate:ls.getCoordinates()) {
			coors.add(new Coor(coordinate.getLongitude(), coordinate.getLatitude()));
		}
		
		
		return coors;
	}

	public void namePoints(Boolean alphabetic) {

		int indexAlp = 65;
		int indexNum=1;
		Iterator<Feature> it, itf;
		Feature f;
		Folder fl;
		Placemark pm;
		Geometry gm;

		it = document.getFeature().iterator();
		while (it.hasNext()) {
			f = it.next();
			if (f instanceof Folder) {
				fl = (Folder) f;
				itf = fl.getFeature().iterator();
				
				while (itf.hasNext()) {
					f = itf.next();
					if (f instanceof Placemark) {
						pm = (Placemark) f;
						gm = pm.getGeometry();
						if (gm instanceof Point) {
							if (alphabetic == true) pm.setName(String.valueOf((char) indexAlp));
							else pm.setName(Integer.toString(indexNum));
							indexAlp++;
							indexNum++;
						}
					}
				}
				indexAlp=65;
				indexNum =1;
				
			} else if (f instanceof Placemark) {
				pm = (Placemark) f;
				gm = pm.getGeometry();
				if (gm instanceof Point) {
					if (alphabetic == true) pm.setName(String.valueOf((char) indexAlp));
					else pm.setName(Integer.toString(indexNum));
					indexAlp++;
					indexNum++;
				}
			}	
		}
		indexAlp=65;
		indexNum =1;
	}
	
	public void changeAllLines(double thick, String color) {
		Iterator<StyleSelector> its;
		its = document.getStyleSelector().iterator();
		StyleSelector ss;
		Style s;
		
		while(its.hasNext()) {
			ss=its.next();
			if (ss instanceof Style) {
				s= (Style) ss;
				if (s.getId().contains("line")) {
					s.getLineStyle().setWidth(thick);
					s.getLineStyle().setColor(color);
				}
//				s.getLineStyle().setWidth(thick);		
			}
				
		}
	}
	
}
