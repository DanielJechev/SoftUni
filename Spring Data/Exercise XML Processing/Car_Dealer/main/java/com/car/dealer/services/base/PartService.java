package com.car.dealer.services.base;

import com.car.dealer.domain.dtos.bindings.PartsDto;

public interface PartService {
    void seedParts(PartsDto partsDto);
}
