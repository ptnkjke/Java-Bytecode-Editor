package net.ptnkjke.gui.main.panes.constanpanes.table;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import org.apache.bcel.classfile.Constant;
import org.apache.bcel.generic.ConstantPoolGen;

/**
 * Created by Lopatin on 09.07.2014.
 */
public class Controller {
    @FXML
    private TableView<ConstantTableCell> table;

    @FXML
    public void initialize() {
        TableColumn<ConstantTableCell, Integer> column = (TableColumn<ConstantTableCell, Integer>) table.getColumns().get(0);
        column.setCellValueFactory(new PropertyValueFactory<ConstantTableCell, Integer>("id"));

        TableColumn<ConstantTableCell, String> column1 = (TableColumn<ConstantTableCell, String>) table.getColumns().get(1);
        column1.setCellValueFactory(new PropertyValueFactory<ConstantTableCell, String>("type"));

        TableColumn<ConstantTableCell, String> column2 = (TableColumn<ConstantTableCell, String>) table.getColumns().get(2);
        column2.setCellValueFactory(new PropertyValueFactory<ConstantTableCell, String>("value"));
    }

    public void setConstantPool(ConstantPoolGen cpg) {
        int length = cpg.getConstantPool().getLength();
        for (int i = 0; i < length; i++) {
            Constant constant = cpg.getConstant(i);
            if (constant == null) {
                continue;
            }
            ConstantTableCell ctb;

            CellConstantWorker cellConstantWorker = new CellConstantWorker(cpg.getConstantPool());

            try {
                cellConstantWorker.visit(constant);
            } catch (Exception e) {
                e.printStackTrace();
            }

            ctb = cellConstantWorker.getConstantTableCell();
            ctb.setId(i);
            table.getItems().add(ctb);

        }
    }
}
