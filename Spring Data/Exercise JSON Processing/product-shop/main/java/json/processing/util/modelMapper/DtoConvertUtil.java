package json.processing.util.modelMapper;

import json.processing.model.dto.view.jsonViewModels.CategoryByProductsCountViewModel;
import json.processing.model.entity.Category;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.*;

public class DtoConvertUtil {

    private static ModelMapper mapper = new ModelMapper();

    public DtoConvertUtil() {
    }

    public static <S, D> D convert(S source, Class<D> destinationClass) {
        return mapper.map(source, destinationClass);
    }

    public static <S, D> List<D> convert(Iterable<S> source, Class<D> destinationClass) {
        List<D> resultList = new ArrayList<>();
        for (S s : source) {
            D d = convert(s, destinationClass);
            resultList.add(d);
        }
        return resultList;
    }

    public static <S, D> Set<D> convertToSet(Iterable<S> sourceIter, Class<D> destinationClass) {
        Set<D> resultSet = new HashSet<>();
        for (S s : sourceIter) {
            D d = convert(s, destinationClass);
            resultSet.add(d);
        }

        return resultSet;
    }

    public static List<CategoryByProductsCountViewModel> convertTest(Iterable<Category> source, Class<CategoryByProductsCountViewModel> destinationClass) {
        List<CategoryByProductsCountViewModel> resultList = new ArrayList<>();

        mapper.addMappings(new PropertyMap<Category, CategoryByProductsCountViewModel>() {
            @Override
            protected void configure() {
                map().setId(source.getId());
                map().setName(source.getName());
                map().setProductsCount(source.getProducts().size());
            }
        });

        for (Category category : source) {
            CategoryByProductsCountViewModel viewModel = convert(category, destinationClass);
            resultList.add(viewModel);
        }

        return resultList;
    }
}
