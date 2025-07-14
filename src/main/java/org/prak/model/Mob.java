package org.prak.model;


import javafx.beans.property.*;

public class Mob {
    private final IntegerProperty id;
    private final StringProperty name;
    private final StringProperty type;
    private final BooleanProperty isHostile;
    private final IntegerProperty biomeId;
    private final FloatProperty spawnChance;
    public Mob(int id, String name, String type, boolean isHostile, int biomeId, float spawnChance) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.type = new SimpleStringProperty(type);
        this.biomeId = new SimpleIntegerProperty(biomeId);
        this.spawnChance = new SimpleFloatProperty(spawnChance);
        this.isHostile = new SimpleBooleanProperty(isHostile);

    }

    public int getId() { return id.get(); }
    public IntegerProperty idProperty() { return id; }

    public String getName() { return name.get(); }
    public StringProperty nameProperty() { return name; }

    public String getType() { return type.get(); }
    public StringProperty typeProperty() { return type; }


    public boolean isHostile() { return isHostile.get(); }
    public BooleanProperty isHostileProperty() { return isHostile; }

    public int getBiomeId() { return biomeId.get(); }
    public IntegerProperty biomeIdProperty() { return biomeId; }

    public float getSpawnChance() { return spawnChance.get(); }
    public FloatProperty spawnChanceProperty() { return spawnChance; }
}
