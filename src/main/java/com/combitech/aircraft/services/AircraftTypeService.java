package com.combitech.aircraft.services;

import com.combitech.aircraft.model.AircraftType;
import com.combitech.aircraft.model.AircraftTypeDto;
import jakarta.ws.rs.NotFoundException;

import java.util.HashMap;
import java.util.Map;

public class AircraftTypeService {

    private static final Map<Long, AircraftType> types = new HashMap<>();

    private static long nextId = 1;

    public AircraftTypeService() {
        types.put(nextId++, new AircraftType(1, "AT76", "202", 8568));
    }

    public AircraftType getType(long id) {
        return types.get(id);
    }

    public AircraftType saveType(AircraftTypeDto type) {
        AircraftType newAircraftType = new AircraftType(nextId, type.typeCode(), type.version(), type.mtow());
        types.put(nextId++, newAircraftType);
        return newAircraftType;
    }

    public AircraftType deleteAircraftType(long id) {
        AircraftType deleted = types.remove(id);
        if(deleted == null) {
            throw new NotFoundException("No AircraftType with id: " + id);
        }
        return deleted;
    }

    public AircraftType updateAircraftType(long id, AircraftTypeDto aircraftTypeDto) {
        if(!types.containsKey(id)) {
            throw new NotFoundException("No AircraftType with id: " + id);
        }
        AircraftType aircraftTypeUpdated = new AircraftType(id, aircraftTypeDto.typeCode(), aircraftTypeDto.version() , aircraftTypeDto.mtow());
        types.put(id, aircraftTypeUpdated);
        return aircraftTypeUpdated;
    }


}
