package aisa.andygroup.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class Ingredient {

    private Long lid;

    private Date createdAt;

    private final String id;
    private final String name;
    private final Type type;

        public  enum Type {
            WRAP,PROTEIN,VEGGIES,SAUCE,CHEESE
        }

}
