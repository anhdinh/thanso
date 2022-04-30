package aisa.andygroup.controller;

import aisa.andygroup.controller.dto.DtoSoBase;
import aisa.andygroup.controller.dto.ResponseDto;
import aisa.andygroup.data.*;
import aisa.andygroup.data.data.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping({"/submit"})
public class InputController {

    private final SoChuDaoRepository soChuDaoRepository;
    private final SoNgaySinhRepository soNgaySinhRepository;
    private final SoThaiDoRepository soThaiDoRepository;
    private final SoLinhHonRepository soLinhHonRepository;
    private final SoNhanCachRepository soNhanCachRepository;
    private final SoSuMenhRepository soSuMenhRepository;
    private final SoTruongThanhRepository soTruongThanhRepository;

    public InputController(SoChuDaoRepository soChuDaoRepository, SoNgaySinhRepository soNgaySinhRepository, SoThaiDoRepository soThaiDoRepository, SoLinhHonRepository soLinhHonRepository, SoNhanCachRepository soNhanCachRepository, SoSuMenhRepository soSuMenhRepository, SoTruongThanhRepository soTruongThanhRepository) {
        this.soChuDaoRepository = soChuDaoRepository;
        this.soNgaySinhRepository = soNgaySinhRepository;
        this.soThaiDoRepository = soThaiDoRepository;
        this.soLinhHonRepository = soLinhHonRepository;
        this.soNhanCachRepository = soNhanCachRepository;
        this.soSuMenhRepository = soSuMenhRepository;
        this.soTruongThanhRepository = soTruongThanhRepository;
    }

    @PostMapping(path = "/postSoChuDao")
    @ResponseBody
    public ResponseDto postSoChuDao(@RequestBody DtoSoBase dtoSoChuDao){
        SoChuDao soChuDao =  new SoChuDao(1,dtoSoChuDao.getNumber(),dtoSoChuDao.getContent());
        soChuDaoRepository.save(soChuDao);
        return new ResponseDto("done");
    }

    @PostMapping(path = "/postSoNgaySinh")
    @ResponseBody
    public ResponseDto postNgaySinh(@RequestBody DtoSoBase dtoSoChuDao){
        SoNgaySinh soChuDao =  new SoNgaySinh(1,dtoSoChuDao.getNumber(),dtoSoChuDao.getContent());
        soNgaySinhRepository.save(soChuDao);
        return new ResponseDto("done");
    }


    @PostMapping(path = "/postSoThaiDo")
    @ResponseBody
    public ResponseDto postThaiDo(@RequestBody DtoSoBase dtoSoChuDao){
        SoThaiDo soChuDao =  new SoThaiDo(1,dtoSoChuDao.getNumber(),dtoSoChuDao.getContent());
        soThaiDoRepository.save(soChuDao);
        return new ResponseDto("done");
    }


    @PostMapping(path = "/postSoLinhHon")
    @ResponseBody
    public ResponseDto postLinhHon(@RequestBody DtoSoBase dtoSoChuDao){
        SoLinhHon soLinhHon =  new SoLinhHon(1,dtoSoChuDao.getNumber(),dtoSoChuDao.getContent());
        soLinhHonRepository.save(soLinhHon);
        return new ResponseDto("done");
    }


    @PostMapping(path = "/postSoNhanCach")
    @ResponseBody
    public ResponseDto postNhanCach(@RequestBody DtoSoBase dtoSoChuDao){
        SoNhanCach soNhanCach =  new SoNhanCach(1,dtoSoChuDao.getNumber(),dtoSoChuDao.getContent());
        soNhanCachRepository.save(soNhanCach);
        return new ResponseDto("done");
    }


    @PostMapping(path = "/postSoSuMenh")
    @ResponseBody
    public ResponseDto postSuMenh(@RequestBody DtoSoBase dtoSoChuDao){
        SoSuMenh soSuMenh =  new SoSuMenh(1,dtoSoChuDao.getNumber(),dtoSoChuDao.getContent());
        soSuMenhRepository.save(soSuMenh);
        return new ResponseDto("done");
    }

    @PostMapping(path = "/postSoTruongThanh")
    @ResponseBody
    public ResponseDto postTruongThanh(@RequestBody DtoSoBase dtoSoChuDao){
        SoTruongThanh soLinhHon =  new SoTruongThanh(1,dtoSoChuDao.getNumber(),dtoSoChuDao.getContent());
        soTruongThanhRepository.save(soLinhHon);
        return new ResponseDto("done");
    }



}
