package com.babor.decorators;

public interface DataSource {
    void writeData(String data);

    String readData();
}
