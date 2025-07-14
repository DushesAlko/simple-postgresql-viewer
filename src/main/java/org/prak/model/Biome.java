package org.prak.model;


import javafx.beans.property.*;

public class Biome {
    private final IntegerProperty id;
    private final StringProperty name;
    private final FloatProperty temperature;
    private final IntegerProperty worldTypeID;


    public Biome(int id, String name, int worldTypeID, float temperature) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.temperature = new SimpleFloatProperty(temperature);
        this.worldTypeID = new SimpleIntegerProperty(worldTypeID);
    }

    public int getId() { return id.get(); }
    public IntegerProperty idProperty() { return id; }

    public String getName() { return name.get(); }
    public StringProperty nameProperty() { return name; }


    public float getTemperature() {
        return temperature.get();
    }

    public FloatProperty temperatureProperty() {
        return temperature;
    }

    public int getWorldTypeID() {
        return worldTypeID.get();
    }

    public IntegerProperty worldTypeIDProperty() {
        return worldTypeID;
    }
}
