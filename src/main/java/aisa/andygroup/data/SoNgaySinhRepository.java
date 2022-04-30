package aisa.andygroup.data;


import aisa.andygroup.data.data.SoBase;
import aisa.andygroup.data.data.SoNgaySinh;

public interface SoNgaySinhRepository {
    SoNgaySinh findOne(String number);
    SoBase save(SoBase soBase) ;
}
