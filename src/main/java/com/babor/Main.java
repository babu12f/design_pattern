package com.babor;

import com.babor.editor.Editor;
import com.babor.listeners.EmailNotificationListener;
import com.babor.listeners.LogOpenListener;

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener("./log_file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));
        editor.events.subscribe("save", (eventType, file) -> {
            System.out.println("editor saved change to the file" + file);
        });

        try {
            editor.openFile("./test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
