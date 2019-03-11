package Controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Model.CSVModel;
import Model.Coor;
import Model.KMLModel;
import Model.Model;

public class SorterControl {

	private Model model;
	private CSVModel csvModel;
	private KMLModel kmlModel;
	
	private LinkedList<Coor> preSortCoors;
	private LinkedList<Coor> postSortCoors;
	
	
	public SorterControl(Model model, CSVModel csvModel, KMLModel kmlModel) {
		this.model = model;
		this.csvModel= csvModel;
		this.kmlModel= kmlModel;
	}
		
	public LinkedList<Coor> getPreSortCoors() {
		return preSortCoors;
	}

	public LinkedList<Coor> getPostSortCoors() {
		return postSortCoors;
	}



	public void loadCoors(List<Coor> coors) {
		preSortCoors = (LinkedList<Coor>) coors;
	}
	
	public void sortPoints(){
		ArrayList<Double> distanceList = null;
		
		double distance=0;
		double distanceMin = 0;
		
		int distanceMinPos =0;
		int index =0;
		
		postSortCoors = preSortCoors;
	
		// ---------------------FINDING MIN DISTANCE----------------
		for(int i=index;i<postSortCoors.size();i++) {
			distance = model.distance(postSortCoors.get(index).getLat(), postSortCoors.get(i).getLat(), postSortCoors.get(index).getLon(), postSortCoors.get(i).getLon(), 0, 0);
			
			if (distance<distanceMin) {
				distanceMin = distance;
				distanceMinPos = i;
			}
//			distanceList.add(distance);
		}
		//----------------------------------------------------------
		
		
		
	}
	
}
