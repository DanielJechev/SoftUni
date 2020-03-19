package com.car.dealer.services.base;

import com.car.dealer.domain.dtos.bindings.PartDto;

public interface PartService {
    void seedParts(PartDto[] partsDto);
}
