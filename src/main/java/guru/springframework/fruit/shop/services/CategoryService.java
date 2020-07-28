package guru.springframework.fruit.shop.services;

import java.util.List;
import guru.springframework.fruit.shop.models.CategoryDTO;

public interface CategoryService {

	public List<CategoryDTO> getAllCategory();
	
	public CategoryDTO findCategoryByName(String name);
}
