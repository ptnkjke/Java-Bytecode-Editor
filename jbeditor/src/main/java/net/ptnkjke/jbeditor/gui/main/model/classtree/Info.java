package net.ptnkjke.jbeditor.gui.main.model.classtree;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TreeItem;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Lopatin on 03.07.2014.
 */
public abstract class Info {
    protected SimpleStringProperty title;

    public Info(String title) {
        this.title = new SimpleStringProperty(title);
    }

    public String getTitle() {
        return title.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    @Override
    public String toString() {
        return title.get();
    }


    /**
     * Создающий метод, чтобы не писать каждый раз лишнии строчки кода
     *
     * @param title
     * @param type
     * @return
     */
    public static TreeItem<Info> createInfo(String title, Class type) {
        try {
            Constructor constructor = type.getConstructor(String.class);
            Info info = (Info) constructor.newInstance(title);

            TreeItem<Info> infoTreeItem = new TreeItem<Info>(info);
            return new TreeItem<Info>(info);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}
