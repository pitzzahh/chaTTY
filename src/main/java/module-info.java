module io.github.pitzzahh.chatbot {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires com.google.gson;

    opens io.github.pitzzahh.chatbot to javafx.fxml;
    opens io.github.pitzzahh.chatbot.controllers to javafx.fxml;
    opens io.github.pitzzahh.chatbot.application to javafx.graphics;
    exports io.github.pitzzahh.chatbot.controllers to javafx.fxml;
    exports io.github.pitzzahh.chatbot;
}