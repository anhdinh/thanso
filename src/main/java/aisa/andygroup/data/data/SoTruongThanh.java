package aisa.andygroup.data.data;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class SoTruongThanh extends SoBase {
    public SoTruongThanh(){

    }

    public SoTruongThanh(int id, int number, String content) {
        super(id, number, content);
    }
}