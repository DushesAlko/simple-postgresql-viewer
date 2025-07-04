package org.prak.ui;

import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import org.prak.model.Item;
import org.prak.repository.ItemRepository;

import java.time.LocalDate;
import java.util.List;

import static org.prak.util.Constants.UPDATE_BUTTON_TEXT;
import static org.prak.util.Constants.VBOX_INDENT;

public class MainView {
    private final VBox root = new VBox(VBOX_INDENT);
    private final TableView<Item> table = new TableView<>();

    public MainView() {
        Button loadButton = new Button(UPDATE_BUTTON_TEXT);

        TableColumn<Item, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(data -> data.getValue().idProperty().asObject());

        TableColumn<Item, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(data -> data.getValue().nameProperty());

        TableColumn<Item, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setCellValueFactory(data -> data.getValue().typeProperty());

        TableColumn<Item, Integer> stackSizeColumn = new TableColumn<>("Stack Size");
        stackSizeColumn.setCellValueFactory(data -> data.getValue().stackSizeProperty().asObject());

        TableColumn<Item, Integer> durabilityColumn = new TableColumn<>("Durability");
        durabilityColumn.setCellValueFactory(data -> data.getValue().durabilityProperty().asObject());

        TableColumn<Item, Boolean> useableColumn = new TableColumn<>("Useable");
        useableColumn.setCellValueFactory(data -> data.getValue().useableProperty());

        TableColumn<Item, LocalDate> addedDateColumn = new TableColumn<>("Added Date");
        addedDateColumn.setCellValueFactory(data -> data.getValue().addedDateProperty());
        table.getColumns().addAll(idColumn, nameColumn, typeColumn, stackSizeColumn, durabilityColumn, useableColumn, addedDateColumn);
        loadButton.setOnAction(e -> {
            List<Item> items = ItemRepository.getAll();
            table.setItems(FXCollections.observableArrayList(items));
        });
        root.getChildren().addAll(loadButton, table);
    }
    public VBox getRoot() {
        return root;
    }
}
