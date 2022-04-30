package aisa.andygroup.data.implement;

import aisa.andygroup.data.SoNgaySinhRepository;
import aisa.andygroup.data.data.SoBase;
import aisa.andygroup.data.data.SoNgaySinh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class JdpcSoNgaySinhRepository extends JdpcBase<SoNgaySinh> implements SoNgaySinhRepository {


    private JdbcTemplate jdbc;

    @Autowired
    public JdpcSoNgaySinhRepository(JdbcTemplate jdbc){
        this.jdbc =  jdbc;
    }

    @Override
    public SoNgaySinh findOne(String number) {
        return jdbc.queryForObject("Select id,number,content type from SO_NGAY_SINH  where number=?", new Object[]{new Integer(number)},this::mapRow);
    }

    @Override
    public SoBase save(SoBase soBase) {
        jdbc.update("UPDATE  SO_NGAY_SINH set content = ? where number=?",soBase.getContent(),soBase.getNumber());
        return soBase;
    }
}

