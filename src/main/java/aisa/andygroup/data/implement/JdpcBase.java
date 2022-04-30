package aisa.andygroup.data.implement;

import aisa.andygroup.data.data.SoBase;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.ParameterizedType;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdpcBase<T extends SoBase> {



    @SneakyThrows
    public  <T extends SoBase> T mapRow(ResultSet rs, int i) throws SQLException {
        Class<?> clazz = Class.forName(getGenericName());
        T  object  = (T) BeanUtils.instantiateClass(clazz);
        object.setId(rs.getInt("id"));
        object.setContent(rs.getString("content"));
        object.setNumber(rs.getInt("number"));
        return object;
    }

    protected String getGenericName() { return ((Class) ((ParameterizedType) getClass() .getGenericSuperclass()).getActualTypeArguments()[0]).getTypeName(); }



}
