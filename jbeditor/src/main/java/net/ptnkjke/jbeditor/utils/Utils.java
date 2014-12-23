package net.ptnkjke.jbeditor.utils;

import org.objectweb.asm.ClassReader;

import java.io.*;
import java.util.Random;
import java.util.jar.JarInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by dalopatin on 07.07.2014.
 */
public class Utils {

    /**
     * Получить строку с рандомным именем
     *
     * @return
     */
    public static String getRandomName() {
        String alpha = "0123456789abcdef";
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < 15; i++) {
            int num = r.nextInt(15);
            sb.append(alpha.charAt(num));
        }

        return sb.toString();
    }

    /**
     * Прочитать файл из ZIP-архива
     *
     * @param zipPath
     * @param innerFile
     * @return
     */
    public static byte[] readFileFromZipFile(String zipPath, String innerFile) {
        ZipFile zip = null;

        try {
            zip = new ZipFile(zipPath);

            ZipEntry entry = zip.getEntry(innerFile);

            if (entry == null) {
                return null;
            }

            InputStream stream = zip.getInputStream(entry);
            byte[] bytes = readAllFromInputStream(stream);
            stream.close();

            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (zip != null) {
                try {
                    zip.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    public static byte[] readAllFromInputStream(InputStream stream){
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[16384];

        try {
            while ((nRead = stream.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            buffer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return buffer.toByteArray();
    }
}
