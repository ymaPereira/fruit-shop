package guru.springframework.fruit.shop.mapper;

import guru.springframework.fruit.shop.domains.Category;
import guru.springframework.fruit.shop.models.CategoryDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-28T10:02:30-0100",
    comments = "version: 1.2.0.CR2, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDTO categoryToCategoryDTO(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId( category.getId() );
        categoryDTO.setName( category.getName() );

        categoryDTO.setCategoryUrl( guru.springframework.fruit.shop.constants.ShopConstants.CATEGORY_URL+"/"+category.getName() );

        return categoryDTO;
    }
}
