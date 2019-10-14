package org.improving.tag.Database;

import org.improving.tag.Adversary;
import org.improving.tag.Exit;
import org.improving.tag.Location;
import org.improving.tag.items.UniqueItems;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class LocationDAO {
    private final JdbcTemplate jdbcTemplate;

    public LocationDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Location> findAll(){
        try {
            List<Location> locations = jdbcTemplate.query("SELECT l.Id as LocId, l.Name as LocName, l.Description, l.AdversaryId, a.Id as AdvId, a.Name as AdvName, a.HitPoints, a.DamageTaken, a.AttackDamage, a.DropItem FROM location l LEFT JOIN adversary a ON l.AdversaryId = a.Id",
                    (result, rowNum) -> {
                Location location = new Location();
                location.setId(result.getInt("LocId"));
                location.setName(result.getString("LocName"));
                location.setDescription(result.getString("Description"));

                if(result.getString("AdversaryId") != null){

                    Integer adversaryId = result.getInt("AdversaryId");
                                Adversary adversary = new Adversary();
                                adversary.setName(result.getString("AdvName"));
                                adversary.setHitPoints(result.getInt("HitPoints"));
                                adversary.setDamageTakenProperty(result.getInt("DamageTaken"));
                                String dropItem = result.getString("DropItem");
                                if (null != dropItem) {

                                    adversary.setAdversaryItem(Arrays.stream(UniqueItems.values())
                                            .filter(item -> item.getName().equals(dropItem))
                                            .findFirst()
                                            .orElse(null));
                                }
                                location.setAdversary(adversary);

                        }
                return location;
            });
            return locations;
        }
        catch(DataAccessException ex) {
            System.out.println("Exception in JDBC: " + ex.getMessage());
            return null;
        }

        }


    }




