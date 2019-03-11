package Controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import Model.Model;
import View.MainView;

public class MainViewControl {

	private final String STATE = "STATE";
	
	private MainView mv;
	private Model model;
	
	
	public MainViewControl(MainView mv, Model model) {
		this.mv = mv;
		this.model = model;
		
		model.addPropertyChangeListener(new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if(STATE.equals(evt.getPropertyName())) {
					mv.showPanel(evt.getNewValue().toString());
			}
//					System.out.println(evt.getPropertyName());
				
			}
		});
	}
	

	
	
}
