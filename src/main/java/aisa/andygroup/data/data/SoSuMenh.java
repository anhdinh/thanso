package aisa.andygroup.data.data;

import lombok.Data;
import lombok.RequiredArgsConstructor;



@Data
public class SoSuMenh extends SoBase {
    public SoSuMenh(){

    }

    public SoSuMenh(int id, int number, String content) {
        super(id, number, content);
    }
}
