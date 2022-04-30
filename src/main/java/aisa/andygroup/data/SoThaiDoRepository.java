package aisa.andygroup.data;

import aisa.andygroup.data.data.SoThaiDo;

public interface SoThaiDoRepository {
    SoThaiDo findOne(String number);
    SoThaiDo save(SoThaiDo soThaiDo) ;
}
