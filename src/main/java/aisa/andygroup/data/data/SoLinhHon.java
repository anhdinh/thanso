package aisa.andygroup.data.data;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class SoLinhHon extends SoBase {
    public SoLinhHon(){

    }

    public SoLinhHon(int id, int number, String content) {
        super(id, number, content);
    }
}
