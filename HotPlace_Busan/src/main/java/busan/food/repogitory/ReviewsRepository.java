package busan.food.repogitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import busan.food.domain.Reviews;

public interface ReviewsRepository extends JpaRepository<Reviews, Integer>{
	 
	 
}
