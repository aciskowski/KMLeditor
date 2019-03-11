package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.LinkedList;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CSVModel {
	
	private File CSVFile;	
	private BufferedReader br;
	private CsvToBean<Coor> csvToBean;
	private ColumnPositionMappingStrategy strategy;
	private String [] fieldsToBind = {"lon", "lat", "msgTime"};
	
	private Iterator<Coor> coordinateIterator;
	private LinkedList<Coor> coordinates;

	public CSVModel() {
		
		
//		Reader reader = Files.newBufferedReader("C:\\Users\\a.ciskowski\\Desktop\\telstra AU\\A_driven.csv");
	
	}
	
	public void readCSV(String path) {
		try {
			CSVFile = new File(path);
			br= new BufferedReader(new FileReader(CSVFile));
			
			strategy = new ColumnPositionMappingStrategy();
			strategy.setType(Coor.class); 
			strategy.setColumnMapping(fieldsToBind);
			
			csvToBean = new CsvToBeanBuilder(br)
					.withMappingStrategy(strategy)
					.withSkipLines(1)
					.withIgnoreLeadingWhiteSpace(true)
					.build();
			
			coordinateIterator = csvToBean.iterator();
			
			coordinates = new LinkedList<Coor>();
			
			while(coordinateIterator.hasNext()) {
				Coor coordinate = coordinateIterator.next();
				coordinates.add(coordinate);
			}
			
//			CSVReader csvr = new CSVReader(br);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readCSV(File file) {
		try {
			CSVFile = file;
			br= new BufferedReader(new FileReader(CSVFile));
			
			strategy = new ColumnPositionMappingStrategy();
			strategy.setType(Coor.class); 
			strategy.setColumnMapping(fieldsToBind);
			
			csvToBean = new CsvToBeanBuilder(br)
					.withMappingStrategy(strategy)
					.withSkipLines(1)
					.withIgnoreLeadingWhiteSpace(true)
					.build();
			
			coordinateIterator = csvToBean.iterator();
			
			coordinates = new LinkedList<Coor>();
			
			while(coordinateIterator.hasNext()) {
				Coor coordinate = coordinateIterator.next();
				coordinates.add(coordinate);
			}
			
//			CSVReader csvr = new CSVReader(br);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public LinkedList<Coor> getCoordinates() {
		
		return coordinates;
	}
	
	public void clearCSV() {
		CSVFile = null;
		br = null;
		csvToBean = null;
		strategy = null;
		coordinateIterator = null;
		coordinates = null;
	}
	
	
	
	
	
}
