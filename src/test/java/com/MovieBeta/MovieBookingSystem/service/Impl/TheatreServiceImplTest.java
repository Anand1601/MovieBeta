package com.MovieBeta.MovieBookingSystem.service.Impl;

import com.MovieBeta.MovieBookingSystem.Services.impl.TheatreServiceImpl;
import com.MovieBeta.MovieBookingSystem.daos.TheatreDao;
import com.MovieBeta.MovieBookingSystem.enteties.Theatre;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TheatreServiceImplTest {

    @Mock
    private TheatreDao theatreDao;

    @InjectMocks
    private TheatreServiceImpl theatreServiceImpl;

    Theatre theatre;


    @BeforeEach
    public void beforeTest() {

        theatre.setTheatreName("PVR");
        theatre.set

    }

    //Test acceptTheatre



    // Test getTheatreDetails
//Test updateTheatreDetails
//Test deleteTheatre
//Test getAllTheatreDetails


}
