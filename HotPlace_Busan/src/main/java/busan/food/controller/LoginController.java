package busan.food.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import busan.food.domain.Member;
import busan.food.service.LoginService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	// 로그인 처리 메소드
	@PostMapping("/api/login")
	public ResponseEntity<?> loginProcess(@RequestBody Member member){
		try {
			String token = loginService.loginProcess(member);
			return ResponseEntity.ok()
									.header(HttpHeaders.AUTHORIZATION, token)
									.body("Login Success");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
									.body("Login Failure");
		}
	}
}
