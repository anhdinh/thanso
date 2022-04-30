package aisa.andygroup.data.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SoBase {
    SoBase(){}
    private   int id;
    private  int number;
    private  String content;
}
