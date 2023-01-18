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

import java.io.File;
import java.io.IOException;

/**
 * class used by services to gain access to the database.
 */
public class Database {

    private static final String APP_DATA_DIR = System.getenv("LOCALAPPDATA") + "\\Programs";
    private static final File DIR = new File(APP_DATA_DIR, "ChaTTY");

    public static void createResponsesFile() throws IOException {
        String appDataPath = System.getenv("LOCALAPPDATA") + "\\Programs";

        File dir = new File(appDataPath, "ChaTTY");
        if (!dir.exists()) {
            System.out.println("Create folder ChaTTY = " + dir.mkdir());
        }
        System.out.println("Create Database: " + new File(dir, "data.db").createNewFile());
    }

    public static File getResponsesFile() {
        String appDataPath = System.getenv("LOCALAPPDATA") + "\\Programs";
        File dir = new File(appDataPath, "ChaTTY");
        return new File(dir, "responses.json");
    }

    public static boolean doesNotExist() {
        return !new File(DIR, "data.db").exists();
    }

}

