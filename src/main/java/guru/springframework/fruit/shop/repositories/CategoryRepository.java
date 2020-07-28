package guru.springframework.fruit.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import guru.springframework.fruit.shop.domains.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

	public Category findByName(String name);
}
