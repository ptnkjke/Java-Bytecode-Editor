package net.ptnkjke.gui.main;

import javafx.scene.control.ListView;
import net.ptnkjke.gui.main.model.ConsoleMessage;

/**
 * Created by Lopatin on 09.07.2014.
 */
public class Static {
    private static ListView<ConsoleMessage> consoleid;

    public static void setConsoleid(ListView<ConsoleMessage> consoleid_) {
        consoleid = consoleid_;
    }

    public static void addMessage(ConsoleMessage consoleMessage) {
        consoleid.getItems().addAll(consoleMessage);
    }
}
