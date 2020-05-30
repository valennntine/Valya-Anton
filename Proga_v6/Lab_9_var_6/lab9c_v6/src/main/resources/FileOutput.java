package main.resources;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutput {
    private String path;
    private FileWriter outputStream;

    public FileOutput(String path) throws IOException {
        this.path = path;
        this.outputStream = new FileWriter(this.path);
    }

    public void writeLine(String line) throws IOException {
        this.outputStream.write(line + "\n");
    }

    public void closeStream() throws IOException {
        this.outputStream.close();
    }
}
