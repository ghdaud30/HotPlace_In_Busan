package busan.food.service;

import org.springframework.stereotype.Service;

import busan.food.domain.Member;

@Service
public interface UpdateService {
	
	// 회원 정보 수정 함수
	public Member profileUpdate(Member member);
	
}
