package guru.springframework.fruit.shop.api;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.fruit.shop.constants.ShopConstants;
import guru.springframework.fruit.shop.models.CategoryDTO;
import guru.springframework.fruit.shop.services.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Category API")
@RestController
@RequestMapping(ShopConstants.CATEGORY_URL)
public class CategoryApi {

	private final CategoryService categoryService;
	
	
	public CategoryApi(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}


	@ApiOperation(value = "List of all categories")
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping
	public List<CategoryDTO> getCategories(){
		return categoryService.getAllCategory();
	}
	

	@ApiOperation(value = "Find category by name")
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping("{name}")
	public CategoryDTO findCategory(@PathVariable String name){
		return categoryService.findCategoryByName(name);
	}
}
