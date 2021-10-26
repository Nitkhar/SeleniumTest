package org.example;

import java.util.Map;

public abstract class Page {
    public abstract boolean checkTheHeader(String header);
    public abstract void fillFields(Map<String, String> fields);
    public abstract void checkFields(Map<String, String> fields);
}
