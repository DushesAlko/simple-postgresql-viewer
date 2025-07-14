package org.prak.ui;

import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.cell.PropertyValueFactory;

import org.prak.model.Biome;
import org.prak.model.Item;
import org.prak.model.Mob;
import org.prak.model.WorldType;
import org.prak.repository.BiomesRepository;
import org.prak.repository.ItemRepository;
import org.prak.repository.MobsRepository;
import org.prak.repository.WorldTypeRepository;

import java.time.LocalDate;

import static org.prak.util.Constants.VBOX_INDENT;

public class MainView {
    private final VBox root = new VBox(VBOX_INDENT);
    private final StackPane tableContainer = new StackPane();

    private final TableView<Item> itemTable = new TableView<>();
    private final TableView<Mob> mobTable = new TableView<>();
    private final TableView<Biome> biomeTable = new TableView<>();
    private final TableView<WorldType> worldTypeTable = new TableView<>();

    public MainView() {
        // Кнопки
        Button itemButton = new Button("Items");
        Button mobButton = new Button("Mobs");
        Button biomeButton = new Button("Biomes");
        Button worldTypeButton = new Button("World Types");


        // Настройка всех таблиц
        setupItemTable();
        setupMobTable();
        setupBiomeTable();
        setupWorldTypeTable();

        // Добавляем все таблицы в контейнер
        tableContainer.getChildren().addAll(itemTable, mobTable, biomeTable, worldTypeTable);
        showTable(itemTable); // По умолчанию показываем Item

        itemTable.setItems(FXCollections.observableArrayList(new ItemRepository().getAll()));
        mobTable.setItems(FXCollections.observableArrayList(new MobsRepository().getAll()));
        biomeTable.setItems(FXCollections.observableArrayList(new BiomesRepository().getAll()));
        worldTypeTable.setItems(FXCollections.observableArrayList(new WorldTypeRepository().getAll()));

        itemTable.setVisible(false);
        mobTable.setVisible(false);
        biomeTable.setVisible(false);
        worldTypeTable.setVisible(false);

        // Действия по кнопкам
        itemButton.setOnAction(e -> {
            showTable(itemTable);
        });

        mobButton.setOnAction(e -> {
            showTable(mobTable);
        });

        biomeButton.setOnAction(e -> {
            showTable(biomeTable);
        });

        worldTypeButton.setOnAction(e -> {
            showTable(worldTypeTable);
        });

        // Панель управления
        ToolBar toolBar = new ToolBar(itemButton, mobButton, biomeButton, worldTypeButton);
        HBox toolbarContainer = new HBox(toolBar);
        toolbarContainer.setAlignment(Pos.CENTER);
        root.getChildren().addAll(toolbarContainer, tableContainer);
    }

    private void showTable(TableView<?> tableToShow) {
        itemTable.setVisible(false);
        mobTable.setVisible(false);
        biomeTable.setVisible(false);
        worldTypeTable.setVisible(false);
        tableToShow.setVisible(true);
    }

    private void setupItemTable() {
        itemTable.getColumns().addAll(
                createColumn("ID", "id", Integer.class),
                createColumn("Name", "name", String.class),
                createColumn("Type", "type", String.class),
                createColumn("Stack Size", "stackSize", Integer.class),
                createColumn("Durability", "durability", Integer.class),
                createColumn("Useable", "useable", Boolean.class),
                createColumn("Added Date", "addedDate", LocalDate.class)
        );
    }

    private void setupMobTable() {
        mobTable.getColumns().addAll(
                createColumn("ID", "id", Integer.class),
                createColumn("Name", "name", String.class),
                createColumn("Type", "type", String.class),
                createColumn("Hostile", "hostile", Boolean.class),
                createColumn("Biome ID", "biomeId", Integer.class),
                createColumn("Spawn %", "spawnChance", Float.class)
        );
    }

    private void setupBiomeTable() {
        biomeTable.getColumns().addAll(
                createColumn("ID", "id", Integer.class),
                createColumn("Name", "name", String.class),
                createColumn("Temperature", "temperature", Float.class),
                createColumn("World Type ID", "worldTypeId", Integer.class)
        );
    }

    private void setupWorldTypeTable() {
        worldTypeTable.getColumns().addAll(
                createColumn("ID", "id", Integer.class),
                createColumn("Name", "name", String.class),
                createColumn("Description", "description", String.class)
        );
    }

    private <S, T> TableColumn<S, T> createColumn(String title, String property, Class<T> type) {
        TableColumn<S, T> column = new TableColumn<>(title);
        column.setCellValueFactory(new PropertyValueFactory<>(property));
        return column;
    }

    public VBox getRoot() {
        return root;
    }
}
