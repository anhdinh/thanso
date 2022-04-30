package aisa.andygroup.controller;

import aisa.andygroup.data.*;
import aisa.andygroup.data.data.SoBase;
import aisa.andygroup.data.data.SoChuDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class SoOperationsController {

    private final SoChuDaoRepository soChuDaoRepository;
    private final SoNgaySinhRepository soNgaySinhRepository;
    private final SoThaiDoRepository soThaiDoRepository;
    private final SoLinhHonRepository soLinhHonRepository;
    private final SoNhanCachRepository soNhanCachRepository;
    private final SoSuMenhRepository soSuMenhRepository;
    private final SoTruongThanhRepository soTruongThanhRepository;


    public SoOperationsController(SoChuDaoRepository soChuDaoRepository, SoNgaySinhRepository soNgaySinhRepository, SoThaiDoRepository soThaiDoRepository, SoLinhHonRepository soLinhHonRepository, SoNhanCachRepository soNhanCachRepository, SoSuMenhRepository soSuMenhRepository, SoTruongThanhRepository soTruongThanhRepository){
        this.soChuDaoRepository = soChuDaoRepository;
        this.soNgaySinhRepository = soNgaySinhRepository;
        this.soThaiDoRepository = soThaiDoRepository;
        this.soLinhHonRepository = soLinhHonRepository;
        this.soNhanCachRepository = soNhanCachRepository;
        this.soSuMenhRepository = soSuMenhRepository;
        this.soTruongThanhRepository = soTruongThanhRepository;
    }

    @GetMapping("/soChuDaoOperations")
    public String getPageSoChuaDaoForm(@RequestParam(value = "id") String number, Model model){

        SoChuDao soChuDao = soChuDaoRepository.findOne(number);
        if(soChuDao!=null){
          log.info(soChuDao.getContent());
          model.addAttribute("content",soChuDao.getContent());
          model.addAttribute("number",soChuDao.getNumber());
        }else{
            model.addAttribute("content","test content");
        }
        return "soChuDaoOperations";
    }

    @GetMapping("/soNgaySinhOperations")
    public String getPageSoNgaySinhForm(@RequestParam(value = "id") String number, Model model){

        SoBase soNgaySinh = soNgaySinhRepository.findOne(number);
        if(soNgaySinh!=null){
            log.info(soNgaySinh.getContent());
            model.addAttribute("content",soNgaySinh.getContent());
            model.addAttribute("number",soNgaySinh.getNumber());
        }else{
            model.addAttribute("content","test content");
        }
        return "soNgaySinhOperations";
    }


    @GetMapping("/soThaiDoOperations")
    public String getPageSoThaiDoForm(@RequestParam(value = "id") String number, Model model){

        SoBase soThaiDo = soThaiDoRepository.findOne(number);
        if(soThaiDo!=null){
            log.info(soThaiDo.getContent());
            model.addAttribute("content",soThaiDo.getContent());
            model.addAttribute("number",soThaiDo.getNumber());
        }else{
            model.addAttribute("content","test content");
        }
        return "soThaiDoOperations";
    }


    @GetMapping("/soLinhHonOperations")
    public String getPageLinhHonForm(@RequestParam(value = "id") String number, Model model){
        SoBase soLinhHon = soLinhHonRepository.findOne(number);
        if(soLinhHon!=null){
            log.info(soLinhHon.getContent());
            model.addAttribute("content",soLinhHon.getContent());
            model.addAttribute("number",soLinhHon.getNumber());
        }else{
            model.addAttribute("content","test content");
        }
        return "soLinhHonOperations";
    }


    @GetMapping("/soNhanCachOperations")
    public String getPageNhanCachForm(@RequestParam(value = "id") String number, Model model){
        SoBase soLinhHon = soNhanCachRepository.findOne(number);
        if(soLinhHon!=null){
            log.info(soLinhHon.getContent());
            model.addAttribute("content",soLinhHon.getContent());
            model.addAttribute("number",soLinhHon.getNumber());
        }else{
            model.addAttribute("content","test content");
        }
        return "soNhanCachOperations";
    }

    @GetMapping("/soSuMenhOperations")
    public String getPageSuMenhForm(@RequestParam(value = "id") String number, Model model){
        SoBase soLinhHon = soSuMenhRepository.findOne(number);
        if(soLinhHon!=null){
            log.info(soLinhHon.getContent());
            model.addAttribute("content",soLinhHon.getContent());
            model.addAttribute("number",soLinhHon.getNumber());
        }else{
            model.addAttribute("content","test content");
        }
        return "soSuMenhOperations";
    }


    @GetMapping("/soTruongThanhOperations")
    public String getPageTruongThanhForm(@RequestParam(value = "id") String number, Model model){
        SoBase soLinhHon = soTruongThanhRepository.findOne(number);
        if(soLinhHon!=null){
            log.info(soLinhHon.getContent());
            model.addAttribute("content",soLinhHon.getContent());
            model.addAttribute("number",soLinhHon.getNumber());
        }else{
            model.addAttribute("content","test content");
        }
        return "soTruongThanhOperations";
    }
}
