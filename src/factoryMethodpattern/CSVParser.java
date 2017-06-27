package factoryMethodpattern;

import java.io.File;
import java.util.List;

public class CSVParser extends TextParser implements Parser{

	public CSVParser(File file) {
		
		System.out.println("CSV parser created");
	}
	@Override
	public List<Record> parse() {
		System.out.println("Parsing csv and creating list of records");
		return null;
	}
}
