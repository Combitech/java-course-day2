package com.combitech.aircraft.services;

import com.combitech.aircraft.model.Owner;
import com.combitech.aircraft.model.OwnerDto;
import jakarta.ws.rs.NotFoundException;

import java.util.HashMap;
import java.util.Map;

public class OwnerService {

    private static final Map<Long, Owner> owners = new HashMap<>();

    private static long nextId = 1;

    static {
        owners.put(nextId++, new Owner(1, "BRA", "Abcvägen 1, 30000 Stockholm"));
    }

    public Owner saveOwner(OwnerDto owner) {
        Owner newOwner = new Owner(nextId, owner.name(), owner.address());
        owners.put(nextId++, newOwner);
        return  newOwner;
    }

    public Owner updateOwner(OwnerDto owner, long id) {
        if(owners.get(id) == null) {
            throw new NotFoundException("No owner exists with id: " + id);
        }
        Owner updatedOwner = new Owner(id, owner.name(), owner.address());
        owners.put(id, updatedOwner);
        return  updatedOwner;
    }

    public Owner getOwner(long id) {
        return owners.get(id);
    }

    public Owner deleteOwner(long id) {
        Owner deleted = owners.remove(id);
        if(deleted== null) {
            throw new NotFoundException("No owner exists with id: " + id);
        }
        return deleted;
    }
}

