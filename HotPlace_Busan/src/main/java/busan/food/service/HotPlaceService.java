package busan.food.service;

import org.springframework.stereotype.Service;

import busan.food.domain.Member;

@Service
public interface HotPlaceService {
	
	 // 회원 가입 함수
	 public Member sign(Member MemberFormDTO);
	 
	 // 아이디 중복 여부 검증 함수
	 public boolean validatonID(Member MemberFormDTO);
	 
	 // 이메일 중복 여부 검증 함수
     public boolean validatonEmail(Member MemberFormDTO);
     
     // 닉네임 중복 여부 검증 함수
     public boolean validationNickname(Member MemberFormDTO);
     
}
