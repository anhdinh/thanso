package aisa.andygroup.data;

import aisa.andygroup.data.data.SoBase;
import aisa.andygroup.data.data.SoNhanCach;
import aisa.andygroup.data.data.SoSuMenh;
import aisa.andygroup.data.data.SoTruongThanh;

public interface SoTruongThanhRepository {
    SoTruongThanh findOne(String number);
    SoBase save(SoBase soTruongThanh) ;
}
