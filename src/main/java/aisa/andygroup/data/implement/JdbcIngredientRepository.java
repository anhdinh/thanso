package aisa.andygroup.data.implement;

import aisa.andygroup.data.IngredientRepository;
import aisa.andygroup.domain.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbc){
        this.jdbc =  jdbc;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbc.query("Select id,name,type from Ingredient",this::mapRowToIngredient);
    }

    private  Ingredient mapRowToIngredient(ResultSet rs, int i) throws SQLException {
        return new Ingredient(rs.getString("id"),
                rs.getString("name"),
                Ingredient.Type.valueOf(rs.getString("type")));
    }

    @Override
    public Ingredient findOne(String id) {
        return jdbc.queryForObject("Select id,name,type from ingredient where id=?",this::mapRowToIngredient);
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbc.update("insert into Ingredient(id,name,type) values (?,?,?)",ingredient.getId(),ingredient.getName(),ingredient.getType());
        return ingredient;
    }
}
