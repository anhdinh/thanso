package aisa.andygroup.data.implement;

import aisa.andygroup.data.SoLinhHonRepository;
import aisa.andygroup.data.data.SoBase;
import aisa.andygroup.data.data.SoLinhHon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdpcSoLinhHonRepository extends JdpcBase<SoLinhHon> implements SoLinhHonRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public JdpcSoLinhHonRepository(JdbcTemplate jdbc){
        this.jdbc =  jdbc;
    }

    @Override
    public SoLinhHon findOne(String number) {
        return jdbc.queryForObject("Select id,number,content type from SO_lINH_HON  where number=?", new Object[]{new Integer(number)},this::mapRow);
    }

    @Override
    public SoBase save(SoBase soBase) {
        jdbc.update("UPDATE  SO_lINH_HON set content = ? where number=?",soBase.getContent(),soBase.getNumber());
        return soBase;
    }
}
