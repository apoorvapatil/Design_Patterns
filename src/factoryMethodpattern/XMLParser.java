package factoryMethodpattern;

import java.io.File;
import java.util.List;

public class XMLParser extends TextParser implements Parser{
	
	public XMLParser() {
		
	}

	public XMLParser(File file) {
		System.out.println("XML parser created");
	}

	@Override
	public List<Record> parse() {
		System.out.println("Parsing xml and creating list of records");
		return null;
	}
	
}
