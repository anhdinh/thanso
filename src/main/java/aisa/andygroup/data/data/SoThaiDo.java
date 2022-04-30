package aisa.andygroup.data.data;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Data
public class SoThaiDo extends SoBase {
    public SoThaiDo(){

    }

    public SoThaiDo(int id, int number, String content) {
        super(id, number, content);
    }
}
