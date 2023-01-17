package io.github.pitzzahh.chatbot.application;

import static io.github.pitzzahh.chatbot.util.WindowUtil.*;
import static java.util.Objects.requireNonNull;
import io.github.pitzzahh.chatbot.Launcher;
import static javafx.fxml.FXMLLoader.load;
import javafx.application.Application;
import javafx.scene.Parent;
import java.io.IOException;

import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Map;

public class ChatBot extends Application {

    private final Class<Launcher> aClass = Launcher.class;

    @Override
    public void start(Stage primaryStage) throws Exception {
        initParents();
        Parent parent = getParent("main_window");
        setStage(primaryStage);
        getStage().initStyle(StageStyle.DECORATED);
        getStage().getIcons().add(new Image(requireNonNull(aClass.getResourceAsStream("assets/logo.png"), "Logo not found")));
        loadParent(parent, "ChaTTY");
        getStage().addEventHandler(KeyEvent.KEY_PRESSED, fullScreenEvent);
        getStage().setWidth(600);
        getStage().setHeight(700);
        getStage().setMinWidth(600);
        getStage().setMinHeight(700);
        getStage().centerOnScreen();
        getStage().show();
    }

    /**
     * Initializes the parents.
     * The window is loaded from the FXML file.
     *
     * @throws IOException if the parent cannot be loaded.
     */
    private void initParents() throws IOException {

        Parent mainWindow = load(requireNonNull(aClass.getResource("fxml/main.fxml"), "Cannot find main.fxml"));

        mainWindow.setId("main_window");

        addParents.accept(Map.of(
                mainWindow.getId(), mainWindow
        ));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
