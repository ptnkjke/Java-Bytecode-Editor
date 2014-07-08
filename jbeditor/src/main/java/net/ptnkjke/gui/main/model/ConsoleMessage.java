package net.ptnkjke.gui.main.model;

import sun.plugin2.message.Message;

/**
 * Created by Lopatin on 08.07.2014.
 */
public class ConsoleMessage {
    private String message;
    private MessageType type;

    public ConsoleMessage(String message, MessageType type) {
        this.message = message;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }
}
