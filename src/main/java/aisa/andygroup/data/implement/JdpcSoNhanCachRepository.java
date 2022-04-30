package aisa.andygroup.data.implement;

import aisa.andygroup.data.SoNhanCachRepository;
import aisa.andygroup.data.data.SoBase;
import aisa.andygroup.data.data.SoLinhHon;
import aisa.andygroup.data.data.SoNhanCach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdpcSoNhanCachRepository extends JdpcBase<SoNhanCach> implements SoNhanCachRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public JdpcSoNhanCachRepository(JdbcTemplate jdbc){
        this.jdbc =  jdbc;
    }

    @Override
    public SoNhanCach findOne(String number) {
        return jdbc.queryForObject("Select id,number,content type from SO_NHAN_CACH  where number=?", new Object[]{new Integer(number)},this::mapRow);
    }

    @Override
    public SoBase save(SoBase soBase) {
        jdbc.update("UPDATE  SO_NHAN_CACH set content = ? where number=?",soBase.getContent(),soBase.getNumber());
        return soBase;
    }
}
