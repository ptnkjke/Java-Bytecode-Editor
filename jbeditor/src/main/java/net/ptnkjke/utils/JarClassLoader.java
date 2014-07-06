package net.ptnkjke.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by Lopatin on 04.07.2014.
 */
public class JarClassLoader extends ClassLoader {
    private HashMap<String, Class<?>> cache = new HashMap<String, Class<?>>();

    private String jarFileName;


    public JarClassLoader(String jarFileName) {
        this.jarFileName = jarFileName;
        cacheClasses();
    }

    public void cacheClasses() {
        try {
            JarFile jarFile = new JarFile(this.jarFileName);

            Enumeration entries = jarFile.entries();

            while (entries.hasMoreElements()) {
                JarEntry jarEntry = (JarEntry) entries.nextElement();

                if (!jarEntry.getName().contains(".class")) {
                    continue;
                }

                byte[] classData = loadClassData(jarFile, jarEntry);
                if (classData != null) {

                    try {
                        Class<?> clazz = defineClass(stripClassName(normalize(jarEntry.getName())), classData, 0, classData.length);

                        cache.put(clazz.getName(), clazz);
                    } catch (Exception e) {
                        //e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        Class<?> result = cache.get(name);

        // TODO: Иногда встерчаются ситуации, когад класс заружается быстрее родителя - вначале зарузить тогда.... и отловить эксепшен
        if (result == null) {
            try {
                result = super.findSystemClass(name);
            } catch (Exception e) {
                //e.printStackTrace();
            }
        }

        return result;
    }

    private byte[] loadClassData(JarFile jarFile, JarEntry jarEntry) throws IOException {
        long size = jarEntry.getSize();

        if (size == -1 || size == 0)
            return null;

        byte[] data = new byte[(int) size];
        InputStream in = jarFile.getInputStream(jarEntry);
        in.read(data);
        return data;
    }

    /**
     * Получаем каноническое имя класса
     *
     * @param className
     * @return
     */
    private String stripClassName(String className) {
        return className.substring(0, className.length() - 6);
    }

    /**
     * Преобразуем имя в файловой системе в имя класса
     * <p/>
     * (заменяем слэши на точки)
     *
     * @param className
     * @return
     */
    private String normalize(String className) {
        return className.replace('/', '.');
    }
}
