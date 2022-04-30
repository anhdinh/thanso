package aisa.andygroup.data.implement;

import aisa.andygroup.data.SoThaiDoRepository;
import aisa.andygroup.data.data.SoThaiDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdpcSoThaiDoRepository extends JdpcBase<SoThaiDo> implements SoThaiDoRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public JdpcSoThaiDoRepository(JdbcTemplate jdbc){
        this.jdbc =  jdbc;
    }


    @Override
    public SoThaiDo findOne(String number) {
        return jdbc.queryForObject("Select id,number,content type from SO_THAI_DO  where number=?", new Object[]{new Integer(number)},this::mapRow);
    }

    @Override
    public SoThaiDo save(SoThaiDo SoThaiDo) {
        jdbc.update("UPDATE  SO_THAI_DO set content = ? where number=?",SoThaiDo.getContent(),SoThaiDo.getNumber());
        return SoThaiDo;
    }
}
