package guru.springframework.fruit.shop.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import guru.springframework.fruit.shop.domains.Category;
import guru.springframework.fruit.shop.repositories.CategoryRepository;

@Component
public class BootstrapDataCategory implements ApplicationListener<ContextRefreshedEvent>{

	private final CategoryRepository categoryRespository;
	
	
	public BootstrapDataCategory(CategoryRepository categoryRespository) {
		super();
		this.categoryRespository = categoryRespository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("Bootstrap Data Categories...");
		saveCategories();
	}

	private void saveCategories() {
		Category fruits = new Category();
		fruits.setName("Fruits");

		Category dried = new Category();
		dried.setName("Dried");

		Category fresh = new Category();
		fresh.setName("Fresh");

		Category exotic = new Category();
		exotic.setName("Exotic");

		Category nuts = new Category();
		nuts.setName("Nuts");

		categoryRespository.save(fruits);
		categoryRespository.save(dried);
		categoryRespository.save(fresh);
		categoryRespository.save(exotic);
		categoryRespository.save(nuts);

		System.out.println("Total Categories: " + categoryRespository.count());
	}

}
