package busan.food.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import busan.food.domain.Member;

@Service
public class LoginServicelmpl implements LoginService{
	
	@Autowired
	private AuthenticationConfiguration authConfig;
	
	// 로그인 처리 프로세스 함수
	public String loginProcess(Member member) throws Exception{
		
		// Security에게 로그인 요청에 필요한 객체 생성
		Authentication authToken = new UsernamePasswordAuthenticationToken(member.getUsername(), member.getPassword());
		
		// 로그인을 실행하는 Security 객체 생성
		AuthenticationManager authenticationManager = authConfig.getAuthenticationManager();
		
		// 인증 진행
		Authentication auth = authenticationManager.authenticate(authToken);
		
		System.out.println(" auth:"+ auth);
		return "login"; // 인증 토큰 대신 임시로 리턴
	}
}
