package com.combitech.aircraft;

import com.combitech.aircraft.model.AircraftTypeDto;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class AircraftTypeValidationTest {

    private static Validator validator;

    @BeforeAll
    public static void setUpValidator() {
        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            validator = factory.getValidator();
        }
    }

    @Test
    public void testCreateAircraftTypeDto_success() {
        AircraftTypeDto aircraftTypeDto = new AircraftTypeDto("AT76", "200", 5000);
        Set<ConstraintViolation<AircraftTypeDto>> validatorErrors = validator.validate(aircraftTypeDto);
        Assertions.assertTrue(validatorErrors.isEmpty());
    }

    @Test
    public void testCreateAircraftTypeDto_typeCodeTooLong() {
        AircraftTypeDto aircraftTypeDto = new AircraftTypeDto("AT7689", "200", 5000);
        Set<ConstraintViolation<AircraftTypeDto>> validatorErrors =  validator.validate(aircraftTypeDto);
        Assertions.assertFalse(validatorErrors.isEmpty());
    }

    @Test
    public void testCreateAircraftTypeDto_typeCodeNull() {
        AircraftTypeDto aircraftTypeDto = new AircraftTypeDto(null, "200", 5000);
        Set<ConstraintViolation<AircraftTypeDto>> validatorErrors =  validator.validate(aircraftTypeDto);
        Assertions.assertFalse(validatorErrors.isEmpty());
    }



}
