package com.MovieBeta.MovieBookingSystem.controllers;

import com.MovieBeta.MovieBookingSystem.Services.LanguageService;
import com.MovieBeta.MovieBookingSystem.daos.LanguageDao;
import com.MovieBeta.MovieBookingSystem.dtos.LanguageDTO;
import com.MovieBeta.MovieBookingSystem.enteties.Language;
import com.MovieBeta.MovieBookingSystem.exceptions.LanguageDetailsNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/language")
public class LanguageController {

     @Autowired
    private ModelMapper modelMapper;

    @Autowired
    LanguageService languageService;


    /*
    * add new language
    * PUT 127.0.0.1.:8081/mbs/v1/language
    * */
    @PostMapping
    public ResponseEntity addLanguage(@RequestBody LanguageDTO languageDTO){
        Language language = languageService.acceptLanguageDetails(modelMapper.map(languageDTO,Language.class));
        return new ResponseEntity(modelMapper.map(language,LanguageDTO.class), HttpStatus.CREATED);
    }


     /*
    * get language with language_id
    * GET 127.0.0.1.:8081/mbs/v1/language/{language_id}
    * */
    @GetMapping("/{language_id}")
    public ResponseEntity getLanguageById(@PathVariable("language_id")int languageId) throws LanguageDetailsNotFoundException {
        Language language = languageService.getLanguageDetails(languageId);
        return new ResponseEntity(modelMapper.map(language,LanguageDTO.class),HttpStatus.OK);
    }

     /*
    * get all language
    * GET 127.0.0.1.:8081/mbs/v1/language
    * */
    @GetMapping
    public ResponseEntity getAllLanguages(){
        List<Language> languages = languageService.getAllLanguageDetails();
        List<LanguageDTO> response = new ArrayList<>();
        for(Language language: languages)
        {
            response.add(modelMapper.map(language,LanguageDTO.class));
        }
        return new ResponseEntity(response,HttpStatus.OK);
    }

     /*
    * Delete language by language id
    * DELETE 127.0.0.1.:8081/mbs/v1/language/{language_id}
    * */
    @DeleteMapping("/{language_id}")
    public ResponseEntity deleteLanguageById(@PathVariable("language_id") int languageId) throws LanguageDetailsNotFoundException {
        languageService.deleteLanguage(languageId);
        return new ResponseEntity("DELETED",HttpStatus.OK);
    }



}
