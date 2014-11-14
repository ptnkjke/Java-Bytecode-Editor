package net.ptnkjke.logic;

import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.ptnkjke.Configutation;
import net.ptnkjke.utils.Utils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarInputStream;
import java.util.zip.ZipEntry;

import net.lingala.zip4j.core.ZipFile;
import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.JavaClass;

/**
 * Created by dalopatin on 14.11.2014.
 */
public class Core {
    /**
     * key= ClassName, value = byte class represent
     */
    private Map<String, byte[]> classMap = new HashMap<String, byte[]>();

    /**
     * is .jar file loaded or simple .class file?
     */
    private boolean isJarFileLoaded = false;
    /**
     * Original .jar byte-contant for saving change in new jar
     */
    private byte[] originalJar;

    /**
     * Read file
     *
     * @param inPath
     */
    public void read(String inPath) {
        // Clear Class Map
        classMap.clear();

        File file = new File(inPath);

        if (file.getName().contains(".jar")) {
            readJar(file);
            isJarFileLoaded = true;
        } else if (file.getName().contains(".class")) {
            readClassFile(file);
            isJarFileLoaded = false;
        }
    }

    /**
     * Read .jar file
     */
    private void readJar(File jarFile) {
        JarInputStream jarInputStream = null;

        try {
            jarInputStream = new JarInputStream(new FileInputStream(jarFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ZipEntry next = jarInputStream.getNextEntry();

            while (next != null) {
                if (next.getName().contains(".class")) {
                    JavaClass javaClass = new ClassParser(jarFile.getAbsolutePath(), next.getName()).parse();
                    classMap.put(next.getName(), javaClass.getBytes());
                }

                next = jarInputStream.getNextEntry();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream inputStream = new FileInputStream(jarFile);
            this.originalJar = Utils.readAllFromInputStream(inputStream);
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read .class file
     */
    private void readClassFile(File classFile) {
        try {
            JavaClass javaClass = new ClassParser(classFile.getAbsolutePath()).parse();
            classMap.put(javaClass.getClassName(), javaClass.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * SaveAll
     */
    public void save() {
        if (isJarFileLoaded) {
            saveJar();
        } else {
            saveClassFile();
        }
    }

    /**
     * Save .jar file
     */
    private void saveJar() {
        File workDir = new File(Configutation.workDir, Utils.getRandomName());
        // CreateTmpFile
        File tFile = new File(workDir, Utils.getRandomName());

        try {
            OutputStream outputStream = new FileOutputStream(tFile);
            outputStream.write(originalJar);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // CreateZipFile
        ZipFile zipFile = null;
        try {
            zipFile = new ZipFile(tFile);
        } catch (ZipException e) {
            e.printStackTrace();
        }

        // UpdateAllClassFile
        for (Map.Entry<String, byte[]> entry : classMap.entrySet()) {
            String className = entry.getKey();
            byte[] content = entry.getValue();

            className = className.replace(".", "/");
            String path = className.replace(".", "/") + ".class";

            File f = new File(workDir, path);
            OutputStream outputStream = null;

            try {
                outputStream = new FileOutputStream(f);
                outputStream.write(content);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try {
                zipFile.addFile(f, new ZipParameters());
            } catch (ZipException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Save .class file
     */
    private void saveClassFile() {
        File workDir = new File(Configutation.workDir, Utils.getRandomName());

        for (Map.Entry<String, byte[]> entry : classMap.entrySet()) {
            String className = entry.getKey();
            byte[] content = entry.getValue();

            className = className.replace(".", "/");
            String path = className.replace(".", "/") + ".class";

            File f = new File(workDir, path);
            OutputStream outputStream = null;

            try {
                outputStream = new FileOutputStream(f);
                outputStream.write(content);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
