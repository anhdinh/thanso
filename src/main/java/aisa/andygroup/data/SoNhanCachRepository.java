package aisa.andygroup.data;

import aisa.andygroup.data.data.SoBase;
import aisa.andygroup.data.data.SoNhanCach;
import aisa.andygroup.data.data.SoThaiDo;

public interface SoNhanCachRepository {
    SoNhanCach findOne(String number);
    SoBase save(SoBase soNhanCach) ;
}
