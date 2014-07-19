package net.ptnkjke.gui.main.constantpanes.table;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import net.ptnkjke.utils.CellConstantWorker;
import net.ptnkjke.utils.TextConstantWorker;
import org.apache.bcel.classfile.Constant;
import org.apache.bcel.generic.ClassGen;
import org.apache.bcel.generic.ConstantPoolGen;

/**
 * Created by Lopatin on 09.07.2014.
 */
public class Controller {
    @FXML
    private TableView<ConstantTableCell> table;

    private ClassGen classGen;

    @FXML
    public void initialize() {
        TableColumn<ConstantTableCell, Integer> column = (TableColumn<ConstantTableCell, Integer>) table.getColumns().get(0);
        column.setCellValueFactory(new PropertyValueFactory<ConstantTableCell, Integer>("id"));

        TableColumn<ConstantTableCell, String> column1 = (TableColumn<ConstantTableCell, String>) table.getColumns().get(1);
        column1.setCellValueFactory(new PropertyValueFactory<ConstantTableCell, String>("type"));

        TableColumn<ConstantTableCell, String> column2 = (TableColumn<ConstantTableCell, String>) table.getColumns().get(2);
        column2.setCellValueFactory(new PropertyValueFactory<ConstantTableCell, String>("value"));
    }

    public void setClassGen(ClassGen cg) {
        this.classGen = cg;
        ConstantPoolGen cpg = cg.getConstantPool();
        int length = cpg.getConstantPool().getLength();
        for (int i = 0; i < length; i++) {
            Constant constant = cpg.getConstant(i);
            if (constant == null) {
                System.out.println(i + " is null");
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

        // Преобразуем константу в текст

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < length; i++) {
            Constant constant = cpg.getConstant(i);
            if (constant == null) {
                System.out.println(i + " is null");
                continue;
            }
            TextConstantWorker textConstantWorker = new TextConstantWorker(cpg.getConstantPool());

            try {
                textConstantWorker.visit(constant);
            } catch (Exception e) {
                e.printStackTrace();
            }

            sb.append(textConstantWorker.getText()).append("\n");
        }
    }
}
