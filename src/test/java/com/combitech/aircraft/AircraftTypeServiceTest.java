package com.combitech.aircraft;

import com.combitech.aircraft.model.AircraftType;
import com.combitech.aircraft.model.AircraftTypeDto;
import com.combitech.aircraft.services.AircraftTypeService;
import jakarta.ws.rs.NotFoundException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AircraftTypeServiceTest {


    private AircraftTypeService aircraftTypeService
            = new AircraftTypeService();


    @Test
    public void testCreateAircraftType_successful() {
        AircraftType type = aircraftTypeService.saveType(
                new AircraftTypeDto("AT80",
                "300", 9500));
        Assertions.assertEquals("AT80", type.getTypeCode());
        Assertions.assertEquals("300", type.getVersion());
        Assertions.assertEquals(9500, type.getMtow());
    }

    @Test
    public void testDeleteAircraftType_successful(){
        AircraftType type = aircraftTypeService.deleteAircraftType(1);
        Assertions.assertNotNull(type);
    }

    @Test
    public void testDeleteAircraftType_notFound(){
        Assertions.assertThrows(NotFoundException.class,
                () -> aircraftTypeService.deleteAircraftType(3));
    }





}
