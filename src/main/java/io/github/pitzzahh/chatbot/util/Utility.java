/*
 * MIT License
 *
 * Copyright (c) 2022 pitzzahh
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
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.github.pitzzahh.chatbot.util;

import com.google.gson.reflect.TypeToken;
import io.github.pitzzahh.chatbot.Launcher;
import java.io.InputStreamReader;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.Map;

import static java.util.Objects.requireNonNull;

public interface Utility {

    /**
     * Gets the jokes from a local JSON file
     * @return a map of chat responses
     */
    static Map<String, String> readJson(String fileName) {
        try (InputStreamReader reader = new InputStreamReader(requireNonNull(Launcher.class.getResourceAsStream(fileName), "Cannot find file " + fileName))) {
            return new Gson().fromJson(reader, new TypeToken<Map<String, String>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
            return Map.of();
        }
    }

}