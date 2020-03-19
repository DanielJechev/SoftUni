package car.dealer.demo.service.partService;

import car.dealer.demo.model.dto.bindingModel.seedDataDtos.PartSeedDataBindingModel;
import car.dealer.demo.model.entity.Part;

public interface PartService {

    void saveAll(PartSeedDataBindingModel[] partsDtos);

    Part getOneById(Long id);
}
