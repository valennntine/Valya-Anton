package main.resources;

import java.io.File;
import java.io.IOException;

public class FileCreator {
    private String filename;
    private String directory;

    public FileCreator(String directory, String filename) {
        this.filename = filename;
        this.directory = directory;
    }

    public void createDirectory() {
        File dir = new File(this.directory);
        boolean isCreated = dir.mkdir();
    }

    public void createFileInDirectory() throws IOException {
        String path = this.directory + "/" + this.filename;
        File file = new File(path);
        boolean fileExists = file.createNewFile();
    }
}
