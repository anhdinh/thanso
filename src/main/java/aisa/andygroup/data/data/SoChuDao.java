package aisa.andygroup.data.data;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SoChuDao {
    private final  int id;
    private final int number;
    private final String content;
}
