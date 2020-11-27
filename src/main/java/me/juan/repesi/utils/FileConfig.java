package me.juan.repesi.utils;

import lombok.Getter;
import me.juan.repesi.Main;
import me.juan.repesi.configuration.ConfigurationManager;
import org.apache.commons.io.IOUtils;
import org.bspfsystems.yamlconfiguration.file.YamlConfiguration;

import java.io.*;

@Getter
public class FileConfig {

    private final File file;
    private final YamlConfiguration config;

    public FileConfig(String fileName, String path) throws IOException {
        if (!path.equals("")) {
            path = path + "/";
        }
        path = "Repesi/"+path;
        InputStream resource = getClass().getResourceAsStream("/" + path + fileName);
        String current = new java.io.File(".").getCanonicalPath();
        new File(current + "/" + path).mkdirs();
        this.file = new File(current + "/" + path, fileName);
        if (!this.file.exists()) {
            if (resource == null) {
                try {
                    this.file.createNewFile();
                    ConfigurationManager.log("Success to create new file " + path + fileName);
                } catch (IOException e) {
                    ConfigurationManager.log("Failed to create new file " + path + fileName);
                }
            } else {
                try {
                    this.file.createNewFile();
                    copyFromInputStream(resource, fileName, current + "/" + path);
                    ConfigurationManager.log("Sucess to copy new file " + path + fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                    ConfigurationManager.log("Failed to copy new file " + path + fileName);
                }
            }
        } else {
            ConfigurationManager.log("Success to load file " + path + fileName);
        }
        this.config = YamlConfiguration.loadConfiguration(this.file);
    }


    public void copyFromInputStream(InputStream file, String name, String path) throws IOException {
        OutputStream outStream = new FileOutputStream(new File(path, name));
        byte[] buffer = new byte[8 * 1024];
        int bytesRead;
        while ((bytesRead = file.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
        IOUtils.closeQuietly(file);
        IOUtils.closeQuietly(outStream);
    }

    public void save() {
        try {
            this.config.save(this.file);
        } catch (IOException e) {
            Main.log("Could not save config file " + this.file.toString());
            e.printStackTrace();
        }
    }

}