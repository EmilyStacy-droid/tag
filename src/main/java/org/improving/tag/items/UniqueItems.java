package org.improving.tag.items;

import java.util.HashMap;
import java.util.Map;

public enum UniqueItems implements Item {
    THE_ONE_RING("A golden ring"),
    BLUE_SHELL("A blue shell with wings"),
    NOTHING(""){
        @Override
        public String getDescription() {
            throw new UnsupportedOperationException();
        }
    };
    private String description;


    UniqueItems(String description) {
        this.description = description;

    }
@Override
    public String getDescription(){
        return description;
    }

}


