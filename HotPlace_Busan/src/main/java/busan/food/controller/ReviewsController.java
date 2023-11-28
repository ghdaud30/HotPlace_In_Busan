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
	public ResponseEntity<?> reviewsAdding(@RequestBody Reviews reviews) {
		try {
			Reviews review = reviewsService.reviewsAdding(reviews);
			if(review != null) {
				System.out.println("리뷰를 등록 하였습니다");
				return ResponseEntity.ok().body(review);
			}
			System.out.println("리뷰 등록에 실패 하였습니다");
			return ResponseEntity.badRequest().body("Adding Failure");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.badRequest().body("Adding Failure");
		}
	}
	
	// 리뷰 조회 메서드
	@GetMapping("/api/reviews/selecting")
	public ResponseEntity<?> reviewsSelecting() {
		try {
			List<Reviews> list = reviewsService.reviewsSelecting();
			return ResponseEntity.ok().body(list);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.badRequest().body("Selecting Failure");
		}
	}
}
