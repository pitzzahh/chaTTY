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

public interface Style {

    /**
     * Gets the button styles for admin window
     * @return styles for admin window buttons.
     */
    static String normalToolTipStyle() {
        return "-fx-background-color: #003049; " +
               "-fx-text-fill: white; " +
               "-fx-font-weight: bold; " +
               "-fx-font-family: Jetbrains Mono;" +
               "-fx-font-size: 13px;";
    }

    static String errorToolTipStyle() {
        return "-fx-background-color: #CFD7DF; " +
                "-fx-text-fill: #D50000; " +
                "-fx-font-weight: bold; " +
                "-fx-font-family: Jetbrains Mono;" +
                "-fx-font-size: 13px;";
    }

    static String normalInputStyle() {
        return "-fx-font-size: 20px; " +
                "-fx-background-radius: 10px; " +
                "-fx-border-radius: 10px;";
    }

    static String errorInputStyle() {
        return "-fx-border-color: #970E0E; " +
                "-fx-border-width: 2px; " +
                "-fx-border-radius: 10px; " +
                "-fx-background-radius: 10px; ";
//                "-fx-font-size: 20px; " +
//                "-fx-background-color: transparent;";
    }
}
