package busan.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import busan.food.domain.Member;
import busan.food.domain.MemberFormDTO;
import busan.food.service.HotPlaceService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor	
public class HotPlaceController {
	
	@Autowired
	HotPlaceService hotPlaceService;
	
	// PostMan 으로 확인
	
//	// 회원 가입 메소드(Parameter) - 1
//	@PostMapping("/signUp")
//	public ResponseEntity<?> singUp(MemberFormDTO memberFormDTO) {
//		Member member = hotPlaceService.sign(memberFormDTO);
//		
//		if(member != null) {
//			System.out.println("memberId : " + member);
//			return ResponseEntity.ok("success");
//		}
//		System.out.println("Error");
//			
//		return ResponseEntity.badRequest().body("fail");
//	}
	
	// 회원 가입 메소드(Json) - 2
	@PostMapping("/signUp")
	public ResponseEntity<?> singUp2(@RequestBody MemberFormDTO memberFormDTO){
		Member member = hotPlaceService.sign(memberFormDTO);
		
		if(member != null) {
			System.out.println("memberId : " + member);
			return ResponseEntity.ok("success");
		}
		System.out.println("Error");
			
		return ResponseEntity.badRequest().body("fail");
	}
	
	
}
