package busan.food.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import busan.food.domain.Member;
import busan.food.domain.Reviews;
import busan.food.repogitory.MemberRepository;
import busan.food.repogitory.ReviewsRepository;

@Service
public class ReviewsServicelmpl implements ReviewsService{

	@Autowired
	private ReviewsRepository reviewsRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	// 맛집 리뷰 생성 메서드
	@Override
	public Reviews reviewsAdding(Reviews reviews) throws Exception{
		String userName = reviews.getMember().getUsername();
		Optional<Member> member = memberRepository.findByUsername(userName);
		
		if(member.isPresent()) {
			System.out.println("아이디가 있습니다");
			return reviewsRepository.save(reviews);
		}
		System.out.println("아이디가 없습니다");
		return null;
	}

	// 맛집 리뷰 조회 메서드
	@Override
	public List<Reviews> reviewsSelecting (){
		
		List<Reviews> list = reviewsRepository.findAll();
		
		if(list != null) {
			System.out.println("리뷰가 DB에 있습니다");
			return list;
		}
		System.out.println("리뷰가 DB에 없습니다");
		return null;
	}
	
	// 맛집 리뷰 수정 메서드
	@Override
	public int reviewsUpdating(Reviews reviews){
		Optional<Reviews> optionalReview = reviewsRepository.findById(reviews.getIdx());
	    
	    if (optionalReview.isPresent()) {
	        Reviews findReview = optionalReview.get();
	        findReview.setContent(reviews.getContent());
	        findReview.setPicture(reviews.getPicture());
	        findReview.setScore(reviews.getScore());
	        findReview.setDate(new Date());
	        
	        reviewsRepository.save(findReview);
	        
	        System.out.println("리뷰 수정에 성공하였습니다");
	        return 1;
	    }
		System.out.println("리뷰 수정에 실패하였습니다");
		return -1;
	}
	
	// 맛집 리뷰 삭제 메서드
	@Override
	public int reviewsDeleting(Reviews reviews) {
		Optional<Reviews> idx = reviewsRepository.findById(reviews.getIdx());
		
		if(idx.isPresent()){
			reviewsRepository.deleteById(reviews.getIdx());
			return 1;
		}
		
		return -1;
	}
}
