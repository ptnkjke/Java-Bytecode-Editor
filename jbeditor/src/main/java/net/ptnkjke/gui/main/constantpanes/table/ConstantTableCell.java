package net.ptnkjke.gui.main.constantpanes.table;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Lopatin on 09.07.2014.
 */
public class ConstantTableCell {
    private SimpleIntegerProperty id = new SimpleIntegerProperty();
    private SimpleStringProperty type = new SimpleStringProperty();
    private SimpleStringProperty value = new SimpleStringProperty();
    // Пользователь в таблице сделал изменение
    private boolean changed = false;
    // Тип константы
    private  byte const_type;

    public Integer getId() {
        return id.get();
    }

    public void setId(Integer id) {
        this.id.set(id);
    }

    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getValue() {
        return value.get();
    }

    public void setValue(String value) {
        this.value.set(value);
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }


    public byte getConst_type() {
        return const_type;
    }

    public  void setConst_type(byte const_type) {
        this.const_type = const_type;
    }
}
