package guru.springframework.fruit.shop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import guru.springframework.fruit.shop.domains.Category;
import guru.springframework.fruit.shop.models.CategoryDTO;

@Mapper
public interface CategoryMapper {

	CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

	@Mapping(target = "categoryUrl", expression = "java(guru.springframework.fruit.shop.constants.ShopConstants.CATEGORY_URL+\"/\"+category.getName())")
    CategoryDTO categoryToCategoryDTO(Category category);
}
