package factoryMethodpattern;

import java.io.File;
import java.util.List;

public class TextParser implements Parser{
	TextParser(){}
	public TextParser(File file){
		System.out.println("Text parser created");
	}
	public List<Record> parse() {
		System.out.println("Parsing text and creating list of records");
		return null;
	}

}
