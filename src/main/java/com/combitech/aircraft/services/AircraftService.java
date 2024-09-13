package com.combitech.aircraft.services;

import com.combitech.aircraft.model.Aircraft;
import com.combitech.aircraft.model.AircraftDto;
import com.combitech.aircraft.model.AircraftType;
import com.combitech.aircraft.model.Owner;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;

import java.util.HashMap;
import java.util.Map;

public class AircraftService {

    private static final Map<String, Aircraft> aircrafts = new HashMap<>();

    private final AircraftTypeService aircraftTypeService = new AircraftTypeService();

    private final OwnerService ownerService = new OwnerService();

    private static long nextId = 1;



    public AircraftService() {
        aircrafts.put("SEMKA", new Aircraft(nextId++, "SEMKA", new Owner(1, "Braathens Regional", "Abcvägen 123, Stockholm" )
                , new AircraftType(1, "AT76", "202", 8000)));
        aircrafts.put("SEMKB", new Aircraft(nextId++, "SEMKB", new Owner(1, "Braathens Regional", "Abcvägen 123, Stockholm" )
                , new AircraftType(2, "AT72", "204", 9856)));
    }

    public Aircraft getAircraft(String reg) {
        Aircraft aircraft = aircrafts.get(reg);
        if(aircraft == null) {
            throw new NotFoundException("No aircraft with reg found: " + reg);
        }
        return aircraft;
    }

    public Aircraft deleteAircraft(String reg) {
        Aircraft deleted = aircrafts.remove(reg);
        if(deleted == null) {
            throw new NotFoundException("No aircraft with reg found: " + reg);
        }
        return deleted;
    }

    public Aircraft createAircraft(AircraftDto aircraftDto) {
        AircraftType type = aircraftTypeService.getType(aircraftDto.typeId());
        Owner owner = ownerService.getOwner(aircraftDto.ownerId());

        if (type == null) {
            throw new BadRequestException("No type exists with id: " + aircraftDto.typeId());
        }
        if(owner == null) {
            throw new BadRequestException("No owner exists with id: " + aircraftDto.ownerId());
        }
        Aircraft createdAircraft = new Aircraft(nextId++, aircraftDto.reg(), owner, type);
        aircrafts.put(createdAircraft.getReg(), createdAircraft);
        return createdAircraft;
    }

    public Aircraft updateAircraft(String reg, AircraftDto aircraftDto) {
        AircraftType type = aircraftTypeService.getType(aircraftDto.typeId());
        Owner owner = ownerService.getOwner(aircraftDto.ownerId());

        if (type == null) {
            throw new BadRequestException("No type exists with id: " + aircraftDto.typeId());
        }
        if(owner == null) {
            throw new BadRequestException("No owner exists with id: " + aircraftDto.ownerId());
        }

        Aircraft aircraft = aircrafts.get(reg);

        if(aircraft == null) {
            throw new NotFoundException("No aircraft exists with reg: " + reg);
        }
        Aircraft updatedAircraft = new Aircraft(aircraft.getId(), aircraftDto.reg(), owner, type);
        aircrafts.put(reg, updatedAircraft);
        return updatedAircraft;
    }

}
