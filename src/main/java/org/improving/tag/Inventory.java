package org.improving.tag;

import org.improving.tag.items.Item;
import org.improving.tag.items.ItemComparator;
import org.improving.tag.items.UniqueItems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class Inventory {
    private final List<Item> items = new ArrayList<>();

    //default items in inventory
    public Inventory () {
        items.add(UniqueItems.EGGO_WAFFLE);
        items.add(UniqueItems.EVERLASTING_GOBSTOPPER);
        items.add(UniqueItems.EDIBLE_MUSHROOM);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public String getInventoryDisplay() {
        String displayString = " Your have these items:";
        //bad solution
//        var itemNames = items.stream().map(i->i.getName()).sorted().collect(Collectors.toList());
//        itemNames.stream().map(n ->  items.stream().reduce(null, (ans,i) -> ans = (i.getName().equals(n) ?  i : null) == null && ans != null ? ans : null ))
                //.;
        return items.stream().sorted(new ItemComparator()).map(i -> "\n" +i).
                reduce(displayString,(answer, itemValue) -> answer+=itemValue );
        //newItems.forEach(n -> );
//        items.sort(new ItemComparator());
//        for(Item item: items) {
          // displayString += "\n" + newItems;
//        }
        //return displayString + itemNames;
    }
}
