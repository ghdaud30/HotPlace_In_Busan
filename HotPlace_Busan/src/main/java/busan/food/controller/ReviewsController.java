package busan.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import busan.food.domain.Reviews;
import busan.food.service.ReviewsService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ReviewsController {
	
	@Autowired
	private ReviewsService reviewsService;
	
	// 리뷰 생성 메서드
	@PostMapping("/api/reviews/adding")
	public ResponseEntity<?> reviewsCreating(@RequestBody Reviews reviews) {
		try {
			Reviews review = reviewsService.reviewsAdding(reviews);
			return ResponseEntity.ok().body("Creating Success");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.badRequest().body("Creating Failure");
		}
	}
	
}
