package org.improving.tag.items;

import java.util.Comparator;

public class ItemComparator implements Comparator <Item> {

    @Override

    public int compare(Item item1, Item item2) {
        if(item1.getID() == item2.getID()){
           return item1.getName().compareTo(item2.getName());
        }else if(item1.getID() > item2.getID()){
            return 1;
        }
        return -1;

    }
}


