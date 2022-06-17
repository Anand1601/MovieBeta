package com.MovieBeta.MovieBookingSystem.Services;

import com.MovieBeta.MovieBookingSystem.enteties.Language;
import com.MovieBeta.MovieBookingSystem.exceptions.LanguageDetailsNotFoundException;

import java.util.List;

public interface LanguageService {

    public Language acceptLanguageDetails(Language language);
    public Language getLanguageDetails(int id) throws LanguageDetailsNotFoundException;
    public Language getLanguageDetailsByLanguageName(String languageName) throws LanguageDetailsNotFoundException;
    public void deleteLanguage(int id) throws  LanguageDetailsNotFoundException;
    public List<Language> getAllLanguageDetails();

}
