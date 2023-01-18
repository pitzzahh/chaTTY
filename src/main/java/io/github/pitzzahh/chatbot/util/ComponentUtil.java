/*
 * MIT License
 *
 * Copyright (c) 2023 pitzzahh
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.github.pitzzahh.chatbot.util;

import io.github.pitzzahh.chatbot.controllers.UserCardController;
import io.github.pitzzahh.chatbot.controllers.BotCardController;
import static java.util.Objects.requireNonNull;
import io.github.pitzzahh.chatbot.Launcher;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;

public interface ComponentUtil {

    static void initUserMessageCard(VBox messageContainer, ScrollPane scrollPane, String message) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(requireNonNull(Launcher.class.getResource("fxml/userCard.fxml"), "Cannot find userCard.fxml"));
            HBox messageCard = fxmlLoader.load();
            UserCardController userCardController = fxmlLoader.getController();
            userCardController.setData(message);
            messageContainer.getChildren().add(messageCard);
            scrollPane.layout();
            scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void initBotMessageCard(VBox messageContainer, ScrollPane scrollPane, String message, boolean isStart) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(requireNonNull(Launcher.class.getResource("fxml/botCard.fxml"), "Cannot find botCard.fxml"));
            HBox messageCard = fxmlLoader.load();
            BotCardController doctorCardController = fxmlLoader.getController();
            doctorCardController.setData(message, isStart);
            messageContainer.getChildren().add(messageCard);
            scrollPane.layout();
            scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            scrollPane.setVvalue(1.0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

