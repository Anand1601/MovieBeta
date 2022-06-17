package com.MovieBeta.MovieBookingSystem.Services.impl;

import com.MovieBeta.MovieBookingSystem.daos.LanguageDao;
import com.MovieBeta.MovieBookingSystem.enteties.Language;
import com.MovieBeta.MovieBookingSystem.exceptions.LanguageDetailsNotFoundException;
import com.MovieBeta.MovieBookingSystem.Services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    LanguageDao languageDao;

    @Override
    public Language acceptLanguageDetails(Language language) {
        return languageDao.save(language);
    }

    @Override
    public Language getLanguageDetails(int id) throws LanguageDetailsNotFoundException {
        return languageDao.findById(id).orElseThrow(()->new LanguageDetailsNotFoundException("language not found by the id:"+id));
    }

    @Override
    public Language getLanguageDetailsByLanguageName(String languageName) throws LanguageDetailsNotFoundException {
        return languageDao.findByLanguageName(languageName).orElseThrow(()->new LanguageDetailsNotFoundException("Language not found by the languageName:"+languageName));
    }

    @Override
    public void deleteLanguage(int id) throws LanguageDetailsNotFoundException {
        Language savedLanguage=getLanguageDetails(id);
        languageDao.delete(savedLanguage);
    }

    @Override
    public List<Language> getAllLanguageDetails() {
        return languageDao.findAll();
    }
}
