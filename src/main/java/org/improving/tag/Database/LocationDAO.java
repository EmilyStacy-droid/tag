package org.improving.tag.Database;

import org.improving.tag.Adversary;
import org.improving.tag.Exit;
import org.improving.tag.Location;
import org.improving.tag.items.UniqueItems;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
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

            EntityManager em = JPAUtility.getEntityManager();
            em.getTransaction().begin();
            List <Location> locations = em.createQuery("SELECT loc FROM org.improving.tag.Location loc").getResultList();
//            List<Location> locations = jdbcTemplate.query("SELECT l.Id as LocId, l.Name as LocName, l.Description, l.AdversaryId, a.Id as AdvId, a.Name as AdvName, a.HitPoints, a.DamageTaken, a.AttackDamage, a.DropItem FROM location l LEFT JOIN adversary a ON l.AdversaryId = a.Id",
//                    (result, rowNum) -> {
//                Location location = new Location();
//                location.setId(result.getInt("LocId"));
//                location.setName(result.getString("LocName"));
//                location.setDescription(result.getString("Description"));
//                for(int i = 0; i < locations.size(); i++) {
//
//                    if ( locations.get(i).getAdversary() != null){
//                        //em = JPAUtility.getEntityManager();
//                        Adversary adversary = em.find(Adversary.class, locations.get(i).getAdversary().);
//                        locations.get(i).setAdversary(adversary);
//                        System.out.println("adversary is set as " + locations.get(i).getAdversary().getName());
//                    }
//                    //return location;
//                }
                em.getTransaction().commit();
            System.out.println(" we are at " + locations.get(2).getName());
            return locations;
        }
        catch(Exception ex) {
            System.out.println("Exception in JDBC: " + ex.getMessage());
            return null;
        }

        }


    }




