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




