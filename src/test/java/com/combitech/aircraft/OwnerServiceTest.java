package com.combitech.aircraft;

import com.combitech.aircraft.model.Owner;
import com.combitech.aircraft.model.OwnerDto;
import com.combitech.aircraft.services.OwnerService;
import jakarta.ws.rs.NotFoundException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OwnerServiceTest {


    private final OwnerService ownerService = new OwnerService();

    @BeforeAll
    public static void initialize(){
        System.out.println("Körs först av allt innan alla test-metoder körs");
    }

    @AfterAll
    public static void tearDown(){
        System.out.println("Körs sist av allt efter att tester körts");
    }

    @AfterEach
    public void runAfterEachTest(){
        System.out.println("Körs efter varje enskilt test");
    }

    @BeforeEach
    public void setup(){
        System.out.println("Körs före varje enskild test metod körs");
    }


    @Test
    public void testCreateOwner_succesful() {
        ownerService.saveOwner(new OwnerDto("SAS", "32123 Stockholm"));
        Owner owner = ownerService.getOwner(2);
        Assertions.assertEquals( "SAS", owner.name());
        Assertions.assertEquals( "32123 Stockholm", owner.adress());
    }

    @Test
    public void testDeleteOwner_succesful() {
        Owner owner = ownerService.deleteOwner(1);
        Assertions.assertNotNull(owner);
    }

    @Test
    public void testDeleteOwner_notFound() {
        Assertions.assertThrows(NotFoundException.class, () -> ownerService.deleteOwner(3));
    }

}
