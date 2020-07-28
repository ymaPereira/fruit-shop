package guru.springframework.fruit.shop.services.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import guru.springframework.fruit.shop.domains.Category;
import guru.springframework.fruit.shop.mapper.CategoryMapper;
import guru.springframework.fruit.shop.models.CategoryDTO;
import guru.springframework.fruit.shop.repositories.CategoryRepository;
import guru.springframework.fruit.shop.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	private final CategoryRepository categoryRepository;
	private final CategoryMapper categoryMapper;
	
	public CategoryServiceImpl(CategoryMapper categoryMapper,CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.categoryMapper = categoryMapper;
	}

	@Override
	public List<CategoryDTO> getAllCategory() {
		List<Category> categories = categoryRepository.findAll();
		/*List<CategoryDTO> categoriesDTO = categories.stream()
													.map(categoryMapper::categoryToCategoryDTO)
													.collect(Collectors.toList());
		categoriesDTO.stream().forEach(c -> {
			c.setCategoryUrl(ShopConstants.CATEGORY_URL+"/"+c.getName());
		});*/
		return categories.stream()
				.map(categoryMapper::categoryToCategoryDTO)
				.collect(Collectors.toList());
	}

	@Override
	public CategoryDTO findCategoryByName(String name) {
		Category category = categoryRepository.findByName(name);
		return categoryMapper.categoryToCategoryDTO(category);
	}

}
