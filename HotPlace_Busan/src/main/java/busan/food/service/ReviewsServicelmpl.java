package busan.food.service;

import java.util.ArrayList;
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
	public List<Reviews> reviewsSelecting (){
		
		List<Reviews> list = reviewsRepository.findAll();
		
		if(list != null) {
			System.out.println("리뷰가 DB에 있습니다");
			return list;
		}
		System.out.println("리뷰가 DB에 없습니다");
		return null;
	}
}
