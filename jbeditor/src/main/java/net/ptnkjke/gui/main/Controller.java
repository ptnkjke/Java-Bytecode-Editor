package net.ptnkjke.gui.main;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.ptnkjke.gui.main.model.classtree.*;
import net.ptnkjke.gui.main.panes.methodpane.Utils;
import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.generic.ClassGen;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.jar.JarInputStream;
import java.util.zip.ZipEntry;

/**
 * Created by Lopatin on 25.06.2014.
 */
public class Controller {

    @FXML
    private GridPane firstPane;
    @FXML
    private GridPane secondPane;
    @FXML
    private TreeView<Info> mainTree;

    private ClassGen classGen;

    private boolean classFile = false;

    private File source;

    @FXML
    private void initialize() {

        // Загружаем по умолчанию mainPain
        GridPane root = null;
        FXMLLoader fxmlLoader = null;

        fxmlLoader = new FXMLLoader();
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());

        try {
            root = (GridPane) fxmlLoader.load(getClass().getResource("/net/ptnkjke/gui/main/panes/defaultpane/View.fxml").openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        root.setMaxWidth(10000);
        root.setMaxHeight(10000);
        secondPane.getChildren().add(root);


        // Вешаем слушателя
        mainTree.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<Info>>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem<Info>> observableValue, TreeItem<Info> oldValue, TreeItem<Info> newValue) {
                if (newValue == null) {
                    return;
                }

                if (newValue.getValue() instanceof Method) {
                    Method method = (Method) newValue.getValue();

                    // Загружаем для правой части
                    GridPane gridPane = Utils.loadView(method);
                    secondPane.getChildren().clear();
                    secondPane.getChildren().add(gridPane);
                }
            }
        });
    }

    public void onButtonLoadClass() {
        // Вызываем диалоговое окно для выбора файла

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters(); // TODO: Добавить фильтр для расширений

        source = fileChooser.showOpenDialog(null);
        // Если файл не пустой, то производим открытие
        if (source == null) {
            return;
        }

        // Заполняем дерево
        openFile(source);
    }

    private void openFile(File file) {
        TreeItem<Info> rootNode = Info.createInfo(file.getName(), Root.class);
        mainTree.setRoot(rootNode);

        if (file.getName().contains(".jar")) {
            openJarFile(file);
        } else {
            classFile = true;
            openClassFile(file);
        }
    }

    private void openJarFile(File file) {
        // Принудительно загружаем класс
        //JarClassLoader classLoader = new JarClassLoader(file.getAbsolutePath());


        JarInputStream jarInputStream = null;

        try {
            jarInputStream = new JarInputStream(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
            return;

        }

        try {
            ZipEntry next = jarInputStream.getNextEntry();
            while (next != null) {
                if (next.getName().contains(".class")) {

/*                    ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer();
                    int data = 0;
                    while ((data = jarInputStream.read()) != -1) {
                        byteArrayBuffer.write(data);
                    }*/
                    JavaClass javaClass = new ClassParser(file.getAbsolutePath(), next.getName()).parse();
                    addClassToTree(javaClass, false);
                }
                next = jarInputStream.getNextEntry();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }

    private void openClassFile(File file) {
        JavaClass javaClass;
        try {
            javaClass = new ClassParser(file.getAbsolutePath()).parse();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        addClassToTree(javaClass, false);

    }

    private void addClassToTree(JavaClass javaClass, boolean toRoot) {
        ClassGen classGen = new ClassGen(javaClass);
        TreeItem<Info> rootNode = mainTree.getRoot();

        TreeItem<Info> classNode = Info.createInfo(javaClass.getClassName(), Root.class);
        rootNode.getChildren().add(classNode);
        rootNode = classNode;

        TreeItem<Info> node = null;
        // GENERAL INFORMATION
        node = Info.createInfo("General Information", GeneralInformation.class);
        rootNode.getChildren().add(node);

        // CONSTANT POOL
        node = Info.createInfo("Constant Pool", ConstantPool.class);
        rootNode.getChildren().add(node);

        org.apache.bcel.classfile.Constant[] constants = javaClass.getConstantPool().getConstantPool();
        for (int i = 0; i < constants.length; i++) {
            org.apache.bcel.classfile.Constant constant = constants[i];
            if (constant == null) {
                continue;
            }
            TreeItem<Info> inner = Info.createInfo("[" + i + "] " + constant.toString(), Constant.class);
            node.getChildren().add(inner);
        }

        // INTERFACES
        node = Info.createInfo("Interfaces", Interfaces.class);
        rootNode.getChildren().add(node);

        try {
            JavaClass[] intrefaces = javaClass.getInterfaces();
            for (JavaClass inter : intrefaces) {
                TreeItem<Info> inner = Info.createInfo(inter.toString(), Interface.class);
                node.getChildren().add(inner);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // METHODS
        node = Info.createInfo("Methods", Methods.class);
        rootNode.getChildren().add(node);

        org.apache.bcel.classfile.Method[] methods = javaClass.getMethods();
        int methodIndex = 0;
        for (org.apache.bcel.classfile.Method method : methods) {
            TreeItem<Info> inner = Info.createInfo(method.toString(), Method.class);
            ((Method) inner.getValue()).setMethodIndex(methodIndex);
            ((Method) inner.getValue()).setClassGen(classGen);

            node.getChildren().add(inner);
            methodIndex++;
        }

        // ATTRIBUTES
        node = Info.createInfo("Attributes", Attributes.class);
        rootNode.getChildren().add(node);

        org.apache.bcel.classfile.Attribute[] attributes = javaClass.getAttributes();
        for (org.apache.bcel.classfile.Attribute attribute : attributes) {
            TreeItem<Info> inner = Info.createInfo(attribute.toString(), Attribute.class);
            node.getChildren().add(inner);
        }
    }

    public void saveChange() {
        ZipFile zipFile = null;


        try {
            zipFile = new ZipFile(source);
        } catch (ZipException e) {
            e.printStackTrace();
            return;
        }

        // Удаляем все изменённые файлы

    }
}
