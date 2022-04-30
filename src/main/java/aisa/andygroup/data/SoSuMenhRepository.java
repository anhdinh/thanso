package aisa.andygroup.data;

import aisa.andygroup.data.data.SoBase;
import aisa.andygroup.data.data.SoSuMenh;

public interface SoSuMenhRepository {
    SoSuMenh findOne(String number);
    SoBase save(SoBase SoBase) ;
}
