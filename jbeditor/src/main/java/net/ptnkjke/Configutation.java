package net.ptnkjke;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Lopatin on 06.07.2014.
 */
public class Configutation {
    public static String graphVizPath = "C:\\soft\\graphviz\\bin\\dot.exe";
    public static String workDir = "C:\\temp";

    private static final String config = "config.ini";

    public static void save() {
        File f = new File(config);
        Properties properties = new Properties();

        properties.setProperty("graphVizPath", graphVizPath);
        properties.setProperty("workDir", workDir);
        try {
            properties.store(new FileOutputStream(f), "jbedit file options");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read() {
        File con = new File(config);
        if (!con.exists()) {
            save();
        }

        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(con));
        } catch (IOException e) {
            e.printStackTrace();
        }

        graphVizPath = properties.getProperty("graphVizPath");
        workDir = properties.getProperty("workDir");
    }
}
