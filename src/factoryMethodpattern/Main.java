package factoryMethodpattern;

public class Main {

	public static void main(String[] args) {
		BatchProcessor batchprocessor=createBatchProcessor(args[1]);
		batchprocessor.processBatch(args[0]);
		System.out.println("Done..");
	}

	private static BatchProcessor createBatchProcessor(String string) {
		if(string.equals("text")){
			return new TextbatchProcessor();
		}else if(string.equals("csv")){
			return new CSVbatchProcessor();
		}else if(string.equals("xml")){
			return new XMLbatchProcessor();
		}
		return null;
	}

}
