package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.LineString;
import de.micromata.opengis.kml.v_2_2_0.LineStyle;
import de.micromata.opengis.kml.v_2_2_0.Placemark;
import de.micromata.opengis.kml.v_2_2_0.PolyStyle;
import de.micromata.opengis.kml.v_2_2_0.Style;
import de.micromata.opengis.kml.v_2_2_0.StyleMap;
import de.micromata.opengis.kml.v_2_2_0.StyleSelector;
import de.micromata.opengis.kml.v_2_2_0.StyleState;
import de.micromata.opengis.kml.v_2_2_0.Units;
import de.micromata.opengis.kml.v_2_2_0.Vec2;
import de.micromata.opengis.kml.v_2_2_0.Create;
import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Feature;
import de.micromata.opengis.kml.v_2_2_0.Folder;
import de.micromata.opengis.kml.v_2_2_0.IconStyle;;

public class KMLFile {

	
	private final String iconStyleId = "icon";
	private final String lineStyleId = "line";
	private final String polyStyleId = "poly";

	private final String iconStyleNormalId = "icon-normal";
	private final String lineStyleNormalId = "line-normal";
	private final String polyStyleNormalId = "poly-normal";
	
	private final String iconStyleHighlightlId = "icon-highlight";
	private final String lineStyleHighlightId = "line-highlight";
	private final String polyStyleHighlighId = "poly-highlight";
	
	
	private Kml kml;
	private Document document;
	private String name = "";
	
	private List<StyleSelector> styleSelectorList;
	private Style iconStyleNormal;
	private Style iconStyleHighlight;
	private Style lineStyleNormal;
	private Style lineStyleHighlight;
	private Style polyStyleNormal;
	private Style polyStyleHighlight;
	
	private StyleMap iconMap;
	private StyleMap lineMap;
	private StyleMap polyMap;
	
	private List<Feature> features;
	private Folder folder;
	private Placemark placemark;
	private LineString lineString;
	
	
	public KMLFile() {
		kml = new Kml();
		document = kml.createAndSetDocument();
		styleSelectorList = document.getStyleSelector();
		
	}
	
	public void setDocumentName(String name) {
		this.name = name;
		document.setName(this.name);
	}
	
	
	public void addLineStyle(String color, double width) { //warto dodac baloonstyle
		lineStyleNormal = document.createAndAddStyle();
		lineStyleNormal.setId(lineStyleNormalId);
		lineStyleNormal.createAndSetLineStyle()
				.withColor(color)
				.withWidth(width);
		
		lineStyleHighlight = document.createAndAddStyle();
		lineStyleHighlight.setId(lineStyleHighlightId);
		lineStyleHighlight.createAndSetLineStyle()
				.withColor(color)
				.withWidth(1.3*width);
	}
	
	public void addIconStyle(String color, double scale, String href) {//warto dodac baloonstyle i pobawiæ sie z hotspot, warto zapoznac sie z href
		
		//hotspot dodany na pa³e, mo¿na siê pobawiæ
		Vec2 vec2 = new Vec2();
		vec2.setX(32);
		vec2.setY(64);
		vec2.setXunits(Units.PIXELS);
		vec2.setYunits(Units.PIXELS);
		
		iconStyleNormal = document.createAndAddStyle();
		iconStyleNormal.setId(iconStyleNormalId);
		iconStyleNormal.createAndSetIconStyle()
			.withColor(color)
			.withScale(scale)
			.withHotSpot(vec2);
		iconStyleNormal.createAndSetLabelStyle()
			.withScale(0);
		
		iconStyleHighlight = document.createAndAddStyle();
		iconStyleHighlight.setId(iconStyleHighlightlId);
		iconStyleHighlight.createAndSetIconStyle()
			.withColor(color)
			.withScale(scale)
			.withHotSpot(vec2);
		iconStyleHighlight.createAndSetLabelStyle()
			.withScale(1);
		
	}
	
	public void addPoligonStyle(String colorLine, double widthLine, String colorPoly, Boolean fill, Boolean outline) {//mo¿na pomyœleæ o podziale na odrebne style, baloonstyle tez
		
		polyStyleNormal = document.createAndAddStyle();
		polyStyleNormal.setId(polyStyleNormalId);
		polyStyleNormal.createAndSetLineStyle()
				.withColor(colorLine)
				.withWidth(widthLine);	
		polyStyleNormal.createAndSetPolyStyle()
				.withColor(colorPoly)
				.withFill(fill)
				.withOutline(outline);
		
		polyStyleHighlight = document.createAndAddStyle();
		polyStyleHighlight.setId(polyStyleHighlighId);
		polyStyleHighlight.createAndSetLineStyle()
			.withColor(colorLine)
			.withWidth(1.3*widthLine);
		polyStyleHighlight.createAndSetPolyStyle()
			.withColor(colorPoly)
			.withFill(fill)
			.withOutline(outline);
	}

	public void addLineMap() {
		lineMap = document.createAndAddStyleMap();
		lineMap.setId(lineStyleId);
		lineMap.createAndAddPair()
			.withKey(StyleState.NORMAL)
			.withStyleUrl("#"+lineStyleNormalId);
		lineMap.createAndAddPair()
			.withKey(StyleState.HIGHLIGHT)
			.withStyleUrl("#" + lineStyleHighlightId);		
	}
	
	public void addIconMap() {
		iconMap = document.createAndAddStyleMap();
		iconMap.setId(iconStyleId);
		iconMap.createAndAddPair()
			.withKey(StyleState.NORMAL)
			.withStyleUrl("#"+iconStyleNormalId);
		iconMap.createAndAddPair()
			.withKey(StyleState.HIGHLIGHT)
			.withStyleUrl("#"+iconStyleHighlightlId);
	}
	
	public void  addPolyMap() {
		polyMap = document.createAndAddStyleMap();
		polyMap.setId(polyStyleId);
		polyMap.createAndAddPair()
			.withKey(StyleState.NORMAL)
			.withStyleUrl("#"+polyStyleNormalId);
		polyMap.createAndAddPair()
			.withKey(StyleState.HIGHLIGHT)
			.withStyleUrl("#"+polyStyleHighlighId);
	}
	
	public void addFolder(String name) {
		folder = document.createAndAddFolder().withName(name);
	}
	
	public void addPlacemarkWithLineString(String name) {
		placemark = folder.createAndAddPlacemark()
				.withName(name)
				.withStyleUrl("#"+lineStyleId);
		lineString = placemark.createAndSetLineString().withTessellate(true);
	}
	
//	public void addLineString() {
//		lineString = placemark.createAndSetLineString().withTessellate(true);
//	}
	
	public String getName() {
		return name;
	}

	public void addCoordinate(double lon, double lat) {
		lineString.addToCoordinates(lon, lat);
	}
	
	
//	
//	public String getIconStyleId() {
//		return iconStyleId;
//	}
//
//	public String getLineStyleId() {
//		return lineStyleId;
//	}
//
//	public String getPolyStyleId() {
//		return polyStyleId;
//	}
	
	

	public Kml getKml() {
		return kml;
	}
	
	public void clearKMLFile() {
		
	}
	
	
	
	
		

	
	
	
}
