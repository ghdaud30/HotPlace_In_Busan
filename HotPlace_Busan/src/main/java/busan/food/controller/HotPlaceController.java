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
	
	// 회원 가입 메소드(JSON) - 2
	@PostMapping("/signUp")
	public ResponseEntity<?> singUp2(@RequestBody MemberFormDTO memberFormDTO){
		Member member = hotPlaceService.sign(memberFormDTO);
		
		if(member != null) {
			System.out.println("memberId : " + member);
			return ResponseEntity.ok("회원 가입 성공");
		}
		else {
			System.out.println("Error");
			return ResponseEntity.badRequest().body("회원 가입 실패");
		}
	}
	
	@PostMapping("/validationID")
	public ResponseEntity<?> validationID(@RequestBody MemberFormDTO memberFormDto){
		boolean valid = hotPlaceService.validatonID(memberFormDto);
		
		if(valid == true) {
			System.out.println("사용 할 수 있는 아이디 입니다");
			return ResponseEntity.ok("사용 할 수 있는 아이디 입니다");
		}
		else {
			System.out.println("중복된 아이디 입니다");
			return ResponseEntity.badRequest().body("중복된 아이디 입니다");
		}
	}
	
	@PostMapping("/validationEmail")
	public ResponseEntity<?> validationEmail(@RequestBody MemberFormDTO memberFormDto){
		boolean valid = hotPlaceService.validatonEmail(memberFormDto);
		
		if(valid == true) {
			System.out.println("사용 할 수 있는 이메일 입니다");
			return ResponseEntity.ok("사용 할 수 있는 이메일 입니다");
		}
		else {
			System.out.println("중복된 이메일 입니다");
			return ResponseEntity.badRequest().body("중복된 이메일 입니다");
		}
	}
	
	@PostMapping("/validationNickname")
	public ResponseEntity<?> validationNickname(@RequestBody MemberFormDTO memberFormDto){
		boolean valid = hotPlaceService.validationNickname(memberFormDto);
		
		if(valid == true) {
			System.out.println("사용 할 수 있는 닉네임 입니다");
			return ResponseEntity.ok("사용 할 수 있는 닉네임 입니다");
		}
		else {
			System.out.println("중복된 닉네임 입니다");
			return ResponseEntity.badRequest().body("중복된 닉네임 입니다");
		}
	}
	
}
