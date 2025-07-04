package org.prak.model;


import javafx.beans.property.*;


import java.time.LocalDate;


public class Item {
    private final IntegerProperty id;
    private final StringProperty name;
    private final StringProperty type;
    private final IntegerProperty stackSize;
    private final IntegerProperty durability;
    private final BooleanProperty useable;
    private final ObjectProperty<LocalDate> addedDate;
    public Item(int id, String name, String type, short stackSize, short durability, boolean useable, LocalDate addedDate) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.type = new SimpleStringProperty(type);
        this.stackSize = new SimpleIntegerProperty(stackSize);
        this.durability = new SimpleIntegerProperty(durability);
        this.useable = new SimpleBooleanProperty(useable);
        this.addedDate = new SimpleObjectProperty<>(addedDate);
    }

    public int getId() { return id.get(); }
    public IntegerProperty idProperty() { return id; }

    public String getName() { return name.get(); }
    public StringProperty nameProperty() { return name; }

    public String getType() { return type.get(); }
    public StringProperty typeProperty() { return type; }

    public int getStackSize() { return stackSize.get(); }
    public IntegerProperty stackSizeProperty() { return stackSize; }

    public int getDurability() { return durability.get(); }
    public IntegerProperty durabilityProperty() { return durability; }

    public boolean isUseable() { return useable.get(); }
    public BooleanProperty useableProperty() { return useable; }

    public LocalDate getAddedDate() { return addedDate.get(); }
    public ObjectProperty<LocalDate> addedDateProperty() { return addedDate; }
}
