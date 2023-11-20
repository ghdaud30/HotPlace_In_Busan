package busan.food.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	PasswordEncoder encoder() {
	return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.csrf(csrf->csrf.disable()); // CSRF 보호 비활성화 (JS에서 호출 가능)
		http.formLogin(frmLogin->frmLogin.disable()); // Form을 이용한 로그인을 사용하지 않겠다는 설정
		http.httpBasic(basic->basic.disable()); // Http Basic인증 방식을 사용하지 않겠다는 설정
		
 
		return http.build();
	}
}
