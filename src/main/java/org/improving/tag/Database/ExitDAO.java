package org.improving.tag.Database;

import org.improving.tag.Exit;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

@Component
public class ExitDAO {
    private final JdbcTemplate jdbcTemplate;

    public ExitDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Exit> findByOriginId(int originId) {
        try {
            EntityManager em = JPAUtility.getEntityManager();
            em.getTransaction().begin();
//            List<Exit> exits = jdbcTemplate.query("select * from exits where originId = ? ", new Object[] {originId},
//                    (result, rowNum) -> {
//                        Exit exit = new Exit();
//                        exit.setName(result.getString("Name"));
//                        exit.setDestinationId(result.getInt("DestinationId"));

            List<Exit> exits = em.createQuery("SELECT e FROM org.improving.tag.Exit e").getResultList();

            return exits;
        } catch(DataAccessException ex){
            System.out.println("Exception in JDBC: " + ex.getMessage());
            return null;
        }
}

//public List<Exit> findDestinationName(){
//        try {
//            List<Exit> exits = jdbcTemplate.query("select e.Name, e.DestinationId, l.Name from exits e left join location l on l.Id = e.DestinationId;",
//                    (result,rouNum) -> {
//                        Exit exit = new Exit();
//                        String exitDestination = result.getString("")
//                        return exit;
//            }
//
//            );
//        }catch(DataAccessException ex){
//            System.out.println("Exception in JDBC: " + ex.getMessage());
//            return null;
//        }
//}

}
