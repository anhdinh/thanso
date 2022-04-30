package aisa.andygroup.data.implement;

import aisa.andygroup.data.SoSuMenhRepository;
import aisa.andygroup.data.data.SoBase;
import aisa.andygroup.data.data.SoSuMenh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdpcSoSuMenhRepository extends JdpcBase<SoSuMenh> implements SoSuMenhRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public JdpcSoSuMenhRepository(JdbcTemplate jdbc){
        this.jdbc =  jdbc;
    }

    @Override
    public SoSuMenh findOne(String number) {
        return jdbc.queryForObject("Select id,number,content type from SO_SU_MENH  where number=?", new Object[]{new Integer(number)},this::mapRow);
    }

    @Override
    public SoBase save(SoBase soBase) {
        jdbc.update("UPDATE  SO_SU_MENH set content = ? where number=?",soBase.getContent(),soBase.getNumber());
        return soBase;
    }
}
