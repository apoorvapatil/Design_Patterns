package factoryMethodpattern;

import java.io.File;

public class TextbatchProcessor extends BatchProcessor{

	@Override
	public Parser createParser(File file) {
		return new TextParser(file);
	}


}
