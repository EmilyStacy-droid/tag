package org.improving.tag.Database;

import org.improving.tag.Exit;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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
            List<Exit> exits = jdbcTemplate.query("select * from exits = ?", new Object[] {originId},
                    (result, rowNum) -> {
                        Exit exit = new Exit();
                        exit.setName(result.getString("Name"));
                        //test this line by throwing a null
                        //exit.getAliases(Arrays.asList(result.getArray("Aliases")).toString();
                     String aliases = result.getString("Aliases");
                      if(null !=aliases) {
                          Arrays.stream(aliases.replace(" ","").split(","))
                                  .forEach(alias->exit.addAlias(alias));
                      }
                        return exit;
                    } );
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
