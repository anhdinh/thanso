package aisa.andygroup.data.implement;

import aisa.andygroup.data.SoTruongThanhRepository;
import aisa.andygroup.data.data.SoBase;
import aisa.andygroup.data.data.SoThaiDo;
import aisa.andygroup.data.data.SoTruongThanh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdpcSoTruongThanhRepository extends JdpcBase<SoTruongThanh> implements SoTruongThanhRepository {
    private JdbcTemplate jdbc;

    @Autowired
    public JdpcSoTruongThanhRepository(JdbcTemplate jdbc){
        this.jdbc =  jdbc;
    }

    @Override
    public SoTruongThanh findOne(String number) {
        return jdbc.queryForObject("Select id,number,content type from SO_TRUONG_THANH  where number=?", new Object[]{new Integer(number)},this::mapRow);
    }

    @Override
    public SoBase save(SoBase SoThaiDo) {
        jdbc.update("UPDATE  SO_TRUONG_THANH set content = ? where number=?",SoThaiDo.getContent(),SoThaiDo.getNumber());
        return SoThaiDo;
    }
}
