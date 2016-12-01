package analise_proporcional.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;

public abstract class FileTableReader {
    
    protected String FilePath;
    protected String[] columns;
    protected ArrayList rows;
    
    public FileTableReader(String filePath) {
        FilePath = filePath;
        // getAll();
    }
    
    protected void getAll() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(FilePath));
        String line;
        while ((line = br.readLine()) != null) {
            processRow(line.split(";"));
        }
        br.close();
    }
    
    protected abstract void processRow(String[] entry);

    protected ArrayList getRows() {
        return this.rows;
    }
}
