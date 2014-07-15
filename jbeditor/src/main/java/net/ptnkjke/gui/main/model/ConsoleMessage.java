package net.ptnkjke.gui.main.model;

/**
 * Created by Lopatin on 08.07.2014.
 */
public class ConsoleMessage {
    private String message;
    private String descritionPropertie;
    private MessageType type;
    private Exception exception;

    public ConsoleMessage(String message, MessageType type, String descritionPropertie, Exception e) {
        this.message = message;
        this.type = type;
        this.descritionPropertie = descritionPropertie;
        this.exception = exception;
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

    public String getDescritionPropertie() {
        return descritionPropertie;
    }

    public void setDescritionPropertie(String descritionPropertie) {
        this.descritionPropertie = descritionPropertie;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
