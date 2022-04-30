package aisa.andygroup.data;

import aisa.andygroup.data.data.SoBase;
import aisa.andygroup.data.data.SoLinhHon;

public interface SoLinhHonRepository {
    SoLinhHon findOne(String number);
    SoBase save(SoBase soLinhHon) ;
}
