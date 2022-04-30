package aisa.andygroup.data;

import aisa.andygroup.data.data.SoChuDao;

public interface SoChuDaoRepository  {
    SoChuDao findOne(String number);
    SoChuDao save(SoChuDao soChuDao) ;
}
