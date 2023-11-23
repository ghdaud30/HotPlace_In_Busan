package busan.food.service;

import org.springframework.stereotype.Service;

import busan.food.domain.Member;

@Service
public interface LoginService {
	
	// 로그인 처리 프로세스 함수
	public String loginProcess(Member member) throws Exception;
}
