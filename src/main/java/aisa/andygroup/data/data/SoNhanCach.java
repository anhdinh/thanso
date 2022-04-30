package aisa.andygroup.data.data;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class SoNhanCach extends SoBase {
    public SoNhanCach(){

    }

    public SoNhanCach(int id, int number, String content) {
        super(id, number, content);
    }
}