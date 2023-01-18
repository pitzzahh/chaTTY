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

package io.github.pitzzahh.chatbot.backend.db;

import io.github.pitzzahh.util.utilities.FileUtil;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.io.File;

/**
 * class used by services to gain access to the database.
 */
public class Database {

    private static final String APP_DATA_DIR = System.getenv("LOCALAPPDATA") + "\\Programs";
    private static final File DIR = new File(APP_DATA_DIR, "ChaTTY");

    public static void createResponsesFile() throws IOException {
        String appDataPath = System.getenv("LOCALAPPDATA") + "\\Programs";

        File dir = new File(appDataPath, "ChaTTY");
        if (!dir.exists()) System.out.println("Create folder ChaTTY = " + dir.mkdir());

        final Map<String, String> MAP = new HashMap<>();
        MAP.put("hello", "Hello! How can I help you today?");
        MAP.put("hi", "Hello! How can I help you today?");
        MAP.put("hours", "Our school is open Monday through Friday, from 8am to 3pm.");
        MAP.put("location", "Our school is located at 123 Main St.");
        MAP.put("enrollment", "For information on enrollment, please visit our website or call 555-1234.");
        MAP.put("schedule", "Classes start at 8:30am and end at 3:00pm. You can find a detailed schedule on our website.");
        MAP.put("counseling", "For counseling services, please contact the counseling office at 555-5678.");
        MAP.put("teachers", "To contact a teacher, please visit our website and find the directory of teachers.");
        MAP.put("events", "Upcoming events can be found on our calendar on the school website.");
        MAP.put("bye", "Thank you for contacting us. Have a great day!");
        MAP.put("love", "I Love you too. However a Bot like me can't love a human!");
        Gson gson = new Gson();
        String json = gson.toJson(MAP);
        FileUtil.writeToATextFile(json, new File(dir, "responses.json"), true);
        System.out.println("Create Database: " + (!doesNotExist()));
    }

    public static File getResponsesFile() {
        String appDataPath = System.getenv("LOCALAPPDATA") + "\\Programs";
        File dir = new File(appDataPath, "ChaTTY");
        return new File(dir, "responses.json");
    }

    public static boolean doesNotExist() {
        return !new File(DIR, "responses.json").exists();
    }

}

