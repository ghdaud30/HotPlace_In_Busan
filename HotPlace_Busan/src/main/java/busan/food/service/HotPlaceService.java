package busan.food.service;

import org.springframework.stereotype.Service;

import busan.food.domain.Member;
import busan.food.domain.MemberFormDTO;

@Service
public interface HotPlaceService {
	
	 // 회원 가입 함수
	 public Member sign(MemberFormDTO MemberFormDTO);
	 
	 // 아이디 중복 여부 검증 함수
	 public boolean validatonID(MemberFormDTO MemberFormDTO);
	 
	 // 이메일 중복 여부 검증 함수
     public boolean validatonEmail(MemberFormDTO MemberFormDTO);
     
     // 닉네임 중복 여부 검증 함수
     public boolean validationNickname(MemberFormDTO MemberFormDTO);
}
