package com.combitech.aircraft;

import com.combitech.aircraft.model.OwnerDto;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class OwnerValidationTest {

    private static Validator validator;

    @BeforeAll
    public static void setUp() {
        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            validator = factory.getValidator();
        }

    }

    @Test
    public void testCreateOwnerRequest_success() {
        OwnerDto request = new OwnerDto("SAS", "32123 Stockholm");
        Set<ConstraintViolation<OwnerDto>> validationErrors = validator.validate(request);
        Assertions.assertTrue(validationErrors.isEmpty());
    }

    @Test
    public void testCreateOwnerRequest_nameEmpty() {
        OwnerDto request = new OwnerDto("", "32123 Stockholm");
        Set<ConstraintViolation<OwnerDto>> validationErrors = validator.validate(request);
        Assertions.assertFalse(validationErrors.isEmpty());
    }

    @Test
    public void testCreateOwnerRequest_nameNull() {
        OwnerDto request = new OwnerDto(null, "32123 Stockholm");
        Set<ConstraintViolation<OwnerDto>> validationErrors = validator.validate(request);
        Assertions.assertFalse(validationErrors.isEmpty());
    }

    @Test
    public void testCreateOwnerRequest_addressEmpty() {
        OwnerDto request = new OwnerDto("SAS", "");
        Set<ConstraintViolation<OwnerDto>> validationErrors = validator.validate(request);
        Assertions.assertFalse(validationErrors.isEmpty());
    }

    @Test
    public void testCreateOwnerRequest_addressNull() {
        OwnerDto request = new OwnerDto("SAS", null);
        Set<ConstraintViolation<OwnerDto>> validationErrors = validator.validate(request);
        Assertions.assertFalse(validationErrors.isEmpty());
    }

    @Test
    public void testCreateOwnerRequest_addressTooShort() {
        OwnerDto request = new OwnerDto("SAS", "32123 S");
        Set<ConstraintViolation<OwnerDto>> validationErrors = validator.validate(request);
        Assertions.assertFalse(validationErrors.isEmpty());
    }

    @Test
    public void testCreateOwnerRequest_addressTooLong() {
        OwnerDto request = new OwnerDto("SAS",
                "32123 StockholmStockholmStockholmStockholmStockholmStockholmStockholmStockholm");
        Set<ConstraintViolation<OwnerDto>> violations = validator.validate(request);
        Assertions.assertFalse(violations.isEmpty());
    }
}

