package busan.food.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

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
		AuthenticationManager authManager = authConfig.getAuthenticationManager();
		
		// 인증 진행
		Authentication auth = authManager.authenticate(authToken);
		
		System.out.println("auth:" + auth);
		
		// 토큰 만들기
		try {
			String token = JWT.create()
					.withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 10)) // 유효시간 (10 분
					.withClaim("username",member.getUsername()) // 토큰에 등록할 데이터
					.withClaim("password",member.getPassword())
					.sign(Algorithm.HMAC256("busan.food.jwt")); // 토큰 암호화 알고리즘 및 암호화 키
			return "login " + token;
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		return "login Failure";
	}
}
