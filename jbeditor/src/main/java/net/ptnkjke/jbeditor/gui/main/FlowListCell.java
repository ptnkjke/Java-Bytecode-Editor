package net.ptnkjke.jbeditor.gui.main;

import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListCell;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import net.ptnkjke.jbeditor.gui.main.model.ConsoleMessage;
import net.ptnkjke.jbeditor.gui.main.model.MessageType;

/**
 * Created by Lopatin on 08.07.2014.
 */
public class FlowListCell extends ListCell<ConsoleMessage> {

    @Override
    protected void updateItem(ConsoleMessage item, boolean empty) {
        super.updateItem(item, empty);

        if (item != null) {
            TextFlow textFlow = new TextFlow();
            Text text = new Text(item.getMessage());

            if (item.getType() == MessageType.CRITICAL) {
                text.setFill(Color.RED);
            } else if (item.getType() == MessageType.WARNING) {
                text.setFill(Color.DARKBLUE);
            }

            Hyperlink hyperlink = new Hyperlink("[description]");


            textFlow.getChildren().addAll(text);
            textFlow.getChildren().add(hyperlink);

            setGraphic(textFlow);
        }
    }
}
