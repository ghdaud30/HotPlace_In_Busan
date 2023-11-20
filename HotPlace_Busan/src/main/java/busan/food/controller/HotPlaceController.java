package busan.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import busan.food.domain.Member;
import busan.food.domain.MemberFormDTO;
import busan.food.service.HotPlaceService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor	
public class HotPlaceController {
	
	@Autowired
	HotPlaceService hotPlaceService;
	
	// 기본 페이지
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	// 회원가입 페이지
	@GetMapping("/signUp")
	public String signUpForm() {
		return "signUp";
	}
	
	// 회원 가입 메소드
	@PostMapping("/signUp")
	public String singUp(MemberFormDTO memberFormDTO) {
		Member memberId = hotPlaceService.sign(memberFormDTO);
		
		if(memberId != null) {
			System.out.println("memberId : " + memberId);
		}
		else {
			System.out.println("Error");
		}
			
		return "redirect:/index";
	}
	
}
