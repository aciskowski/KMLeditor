package Model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class DownloadModel {

	private String mapLink;
	private String downloadLink;
	private String savePath;
	private String KMLname;
	
	private Boolean errorFlag = false;
	private String ErrorMassage = "";
	
	public DownloadModel() {
		
	}
	
	
	public String createDownloadLink() {		
		String[] temp = mapLink.split("&");			
		downloadLink = temp[0].replaceAll("edit", "kml") + "&forcekml=1";						
		return downloadLink;
	}
	
	
	public void downloadKML() {
		try {
			URL url = new URL(downloadLink);
			ReadableByteChannel rbc = Channels.newChannel(url.openStream());
			FileOutputStream fos = new FileOutputStream(savePath+ "\\" + KMLname + ".kml");
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			fos.close();
			rbc.close();
		}catch (IOException e) {
			e.printStackTrace();
			ErrorMassage = e.getMessage();
			errorFlag = true;
		}
	}


	public String getMapLink() {
		return mapLink;
	}


	public void setMapLink(String mapLink) {
		this.mapLink = mapLink;
	}


	public String getDownloadLink() {
		return downloadLink;
	}


	public void setDownloadLink(String downloadLink) {
		this.downloadLink = downloadLink;
	}


	public String getKMLPath() {
		return savePath+ "\\" + KMLname + ".kml";
	}
	
	public String getSavePath() {
		return savePath;
	}
	

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}


	public String getKMLname() {
		return KMLname;
	}


	public void setKMLname(String kMLname) {
		KMLname = kMLname;
	}
	
}
