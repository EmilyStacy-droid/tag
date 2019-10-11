package org.improving.tag;


import org.improving.tag.items.UniqueItems;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WorldBuilder {
    private final List<Location> locationList = new ArrayList<>();

    public List<Location> getLocationList() {
        return locationList;
    }

    public Location buildWorld() {

        var tdh = new Location();
        tdh.setName("The Deathly Hallows");
        this.locationList.add(tdh);
        tdh.setAdversary(new Adversary("Sauron", UniqueItems.Sauron_Fire));

        var td = new Location();
        td.setName("The Desert");
        this.locationList.add(td);

        var ta = new Location();
        ta.setName("The Amazon");
        this.locationList.add(ta);
        ta.setAdversary(new Adversary("Grumpy Cat", UniqueItems.Meowing));

        var tmcs = new Location();
        tmcs.setName("The Mac & Cheese shop");
        this.locationList.add(tmcs);
        tmcs.setTreasureChest(new TreasureChest(UniqueItems.BLUE_SHELL, "A Kraft box"));

        var tvm = new Location();
        tvm.setName("The Velvet Moose");
        this.locationList.add(tvm);

        var tap = new Location();
        tap.setName("The Airport");

        var tit = new Location();
        tit.setName("The Ice Cream Truck");
        this.locationList.add(tit);

        var tms = new Location();
        tms.setName("The Mountains");
        this.locationList.add(tms);

        var tm = new Location();
        tm.setName("The Mall");
        this.locationList.add(tm);

        var md = new Location();
        md.setName("Mount Doom");
        this.locationList.add(md);

        var tr = new Location();
        tr.setName("The Reef");
        this.locationList.add(tr);

        var tvd = new Location();
        tvd.setName("The Volcano of Death");
        this.locationList.add(tvd);

        tdh.getExits().add(new Exit("Heaven Ave", tmcs, "h", "heaven", "ave"));
        tdh.getExits().add(new Exit("The Deathly Brownie", td, "tdb", "Brownie", "deathly"));
        td.getExits().add(new Exit("Camel Path", ta, "cp", "camel", "path"));
        td.getExits().add(new Exit("The Dock", tap, "td", "dock"));
        td.getExits().add(new Exit("Rocky Road", tit, "rr", "Rocky", "Road"));
        tit.getExits().add(new Exit("Magic Portal", md, "mp", "portal", "magic"));
        tms.getExits().add(new Exit("bike trail", tr, "bt", "trail", "bike"));
        tms.getExits().add(new Exit("The Plane", ta, "tp", "plane"));
        tms.getExits().add(new Exit("The narrow Trail", md, "tat", "narrow trail", "trail", "narrow"));
        tms.getExits().add(new Exit("The Lava Flow", tvd, "tlf", "lava", "flow", "Lava Flow"));
        tmcs.getExits().add(new Exit("highway 121", ta, "121", "hwy", "hwy 121", "h121"));
        tmcs.getExits().add(new Exit("Paradise Rd", tr, "pr", "paradise", "rd"));
        tmcs.getExits().add(new Exit("Higway 21", tvd, "h21", "21", "hwy 21", "higway"));
        md.getExits().add(new Exit("The Cab", tm, "cab", "tc"));
        md.getExits().add(new Exit("Jump into Lava", tvd, "jil", "jump", "into lava"));
        tm.getExits().add(new Exit("Path to Doom", md, "ptd", "path"));
        tr.getExits().add(new Exit("The City Walk", tm, "tcw", "city walk", "city", "walk"));
        tr.getExits().add(new Exit("The Scenic Route", tvm, "tsr", "scenic", "route", "scenic route", "sr"));
        tm.getExits().add(new Exit("An escalator of doom", tvd, "asd", "escalator"));
        ta.getExits().add(new Exit("Amaz-ing Moose", tvm, "moose", "AM", "Amazing", "ing", "Amaz", "Amaz-ing"));
        tvm.getExits().add(new Exit("The pudding Slide", tap, "tps", "pudding", "slide", "pudding slide"));
        tvm.getExits().add(new Exit("The front door", ta, "tfd", "front", "door", "front door"));
        tap.getExits().add(new Exit("flight to the mall", tms, "fttm", "to the mall"));
        tap.getExits().add(new Exit("flight 121", tm, "f121", "121"));


        return tdh;
    }


}
