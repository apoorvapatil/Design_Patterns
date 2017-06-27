package factoryMethodpattern;

import java.io.File;
import java.util.List;

public abstract class BatchProcessor {
	public void processBatch(String filename){
		File file=openFile(filename);
		
		
		// Depends on concrete classes Dependency inversion - Always depend on abstractions and not on concrete classes
		/*if(format.equals("text")){
			parser=new TextParser(file);
		}else if(format.equals("csv")){
			parser=new CSVParser(file);
		}else if(format.equals("xml")){
			parser=new XMLParser(file);
		}*/
		Parser parser=createParser(file); // FACTORY METHOD
		List<Record> records=parser.parse();
		processRecords(records);
		writeSummary();
		closeFile(file);
	}

	public abstract Parser createParser(File file);

	private void closeFile(File file) {
		System.out.println("File has been Closed");
		
	}

	private File openFile(String filename) {
		System.out.println("File has been opened");
		return null;
	}

	private void processRecords(List<Record> records) {
		System.out.println("Processing records");
		
	}

	private void writeSummary() {
		System.out.println("Writing summary");
		
	}
}
