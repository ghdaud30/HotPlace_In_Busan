package busan.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import busan.food.domain.Reviews;
import busan.food.repogitory.ReviewsRepository;

@Service
public class ReviewsServicelmpl implements ReviewsService{

	@Autowired
	private ReviewsRepository reviewsRepository;
	
	public Reviews reviewsAdding(Reviews reviews) throws Exception{
		
		return reviewsRepository.save(reviews);
	}


}
