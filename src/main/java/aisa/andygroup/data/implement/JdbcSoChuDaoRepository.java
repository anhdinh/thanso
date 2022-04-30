package aisa.andygroup.data.implement;

import aisa.andygroup.data.SoChuDaoRepository;
import aisa.andygroup.data.data.SoChuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcSoChuDaoRepository implements SoChuDaoRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public JdbcSoChuDaoRepository(JdbcTemplate jdbc){
        this.jdbc =  jdbc;
    }

    private SoChuDao mapRowToSoChuDao(ResultSet rs, int i) throws SQLException {
        return new SoChuDao(rs.getInt("id"),rs.getInt("number"), rs.getString("content"));
    }

    @Override
    public SoChuDao findOne(String number) {
        return jdbc.queryForObject("Select id,number,content type from CON_SO_CHU_DAO  where number=?", new Object[]{new Integer(number)},this::mapRowToSoChuDao);
    }


    @Override
    public SoChuDao save(SoChuDao sochudao) {
        jdbc.update("UPDATE  CON_SO_CHU_DAO set content = ? where number=?",sochudao.getContent(),sochudao.getNumber());
        return sochudao;
    }
}
