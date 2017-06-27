package factoryMethodpattern;

import java.io.File;

public class XMLbatchProcessor extends BatchProcessor{

	@Override
	public Parser createParser(File file) {
		
		return new XMLParser(file);
	}

}
