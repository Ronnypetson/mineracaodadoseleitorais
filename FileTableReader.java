package mineracaodadoseleitorais;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public abstract class FileTableReader {
	private String FilePath;
	
	public FileTableReader(String filePath) {
		FilePath = filePath;
	}
	
	public void getAll() throws FileNotFoundException, IOException {
	    BufferedReader br = new BufferedReader(new FileReader(FilePath));
    	String line;
		while ((line = br.readLine()) != null) {
			processRow(line.split(";"));
		}
		br.close();
	}
	
	protected abstract void processRow(String[] entry);
}
