package com.example.JB.service;

import com.example.JB.model.Cafe;
import com.example.JB.repos.CafeRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class CafeService {

    private CafeRepo cafeRepo;

    private Logger log = LogManager.getLogger();

    @Autowired
    public CafeService(@Qualifier("CafeDao") CafeRepo cafeRepo) {
        this.cafeRepo = cafeRepo;
    }

    public Iterable<Cafe> findAll(){
        return cafeRepo.findAll();
    }

    public List<Cafe> findByName(String name){
        if(name != null && !name.isEmpty() ) {
            List<Cafe> allCafess = (List<Cafe>) this.findAll();
            List<Cafe> cafess = new ArrayList<>();
            for (Cafe allCafes : allCafess) {
                if (allCafes.getName().toLowerCase().contains(name.toLowerCase())) {
                    cafess.add(allCafes);
                }
            }
            return cafess;
        }else{
            Iterable<Cafe> cafess = this.findAll();
            return (List<Cafe>) cafess;

        }
    }

    public void save(Cafe cafe){
        if(cafe != null && cafeRepo.findByName(cafe.getName()) == null){
            log.info("Cafe created");
            cafeRepo.save(cafe);
        }else {
            log.warn("The cafe already exists or the data is incorrect");
        }
    }

    public void delete(Cafe cafe){
        if(cafe != null){
            log.info("Cafe deleted");
            cafeRepo.delete(cafe);
        }else{
            log.warn("The cafe is NOT removed!");
        }
    }

    public void update(Cafe cafe, String name, String text,String description, String phone, String googleMap ){
        if(cafe != null && !name.isEmpty() && !text.isEmpty() && !description.isEmpty() && !phone.isEmpty()){
            cafe.setText(text);
            cafe.setName(name);
            cafe.setDescription(description);
            cafe.setPhoneNumber(phone);
            if(!cafe.getGoogleMap().equals(googleMap) && googleMap != null && !googleMap.isEmpty()){
                cafe.setGoogleMap(googleMap);
            }
            cafeRepo.save(cafe);
            log.info("Cafe updated");
        }else{
            log.warn("The data entered is incorrect");
        }
    }


    public void addCafe(String uploadPath, MultipartFile file, String name, String text, String description, String phone, String map) throws IOException { //добавить логи
        if( !name.isEmpty() && !text.isEmpty() && !description.isEmpty() && !phone.isEmpty()) {
            Cafe cafe = new Cafe(name, text);
            cafe.setDescription(description);
            cafe.setPhoneNumber(phone);
            cafe.setGoogleMap(map);
            if(file != null){
                File uploadDir = new File(uploadPath);
                if(!uploadDir.exists()) {
                    uploadDir.mkdir();
                }

                String universalFileName = UUID.randomUUID().toString();
                String resultFileName =  universalFileName + "." + file.getOriginalFilename();
                file.transferTo(new File(uploadPath + "/" + resultFileName));
                cafe.setFilename(resultFileName);
            }
            this.save(cafe);
        }
    }

    public Cafe find(String name) {
        if (name != null && !name.isEmpty()) {
            log.info("Cafe found");
            return cafeRepo.findByName(name);
        }else{
            log.info("Cafe not found");
            return null;
        }
    }
}