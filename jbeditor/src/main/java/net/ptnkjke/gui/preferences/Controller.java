package net.ptnkjke.gui.preferences;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import net.ptnkjke.Configutation;
import sun.management.AgentConfigurationError;


import java.io.File;

/**
 * Created by Lopatin on 07.07.2014.
 */
public class Controller {
    @FXML
    private TextField graphViz;
    @FXML
    private TextField workDir;

    @FXML
    private void initialize() {
        graphViz.setText(Configutation.graphVizPath);
        workDir.setText(Configutation.workDir);
    }

    public void chooseGraphVizFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters(); // TODO: Добавить фильтр

        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            graphViz.setText(file.getAbsolutePath());
        }
    }

    public void chooseWorkDir() {
        DirectoryChooser directoryChooser = new DirectoryChooser();

        File f = directoryChooser.showDialog(null);

        if (f != null) {
            workDir.setText(f.getAbsolutePath());
        }
    }

    public void save() {
        Configutation.workDir = workDir.getText();
        Configutation.graphVizPath = graphViz.getText();

        Configutation.save();
    }
}
