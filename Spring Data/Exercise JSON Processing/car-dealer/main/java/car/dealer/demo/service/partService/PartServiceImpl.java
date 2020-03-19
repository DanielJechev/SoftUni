package car.dealer.demo.service.partService;

import car.dealer.demo.model.dto.bindingModel.seedDataDtos.PartSeedDataBindingModel;
import car.dealer.demo.model.entity.Part;
import car.dealer.demo.model.entity.Supplier;
import car.dealer.demo.repository.PartRepository;
import car.dealer.demo.service.supplierService.SupplierService;
import car.dealer.demo.utils.modelMapper.DtoConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Random;

@Service
@Transactional
public class PartServiceImpl implements PartService {

    private final PartRepository partRepository;
    private final SupplierService supplierService;

    @Autowired
    public PartServiceImpl(PartRepository partRepository,
                           SupplierService supplierService) {
        this.partRepository = partRepository;
        this.supplierService = supplierService;
    }

    @Override
    public void saveAll(PartSeedDataBindingModel[] partsDtos) {
        for (PartSeedDataBindingModel partDto : partsDtos) {
            Part part = DtoConvertUtil.convert(partDto, Part.class);
            setRandomSupplier(part);
            this.partRepository.saveAndFlush(part);
        }
    }

    @Override
    public Part getOneById(Long id) {
        return this.partRepository.getOne(id);
    }

    private void setRandomSupplier(Part part) {
        Random random = new Random();
        Integer id;
        do {
            id = random.nextInt(31);
        } while ((id == 0));
        Supplier supplier = this.supplierService.findOneById(Long.valueOf(id));
        String debug = "";
        part.setSupplier(supplier);
    }

}
