package factoryMethodpattern;

import java.io.File;

public class CSVbatchProcessor extends BatchProcessor{

	@Override
	public Parser createParser(File file) {
		return new CSVParser(file);
	}

}
