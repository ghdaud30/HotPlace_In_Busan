package busan.food.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;



@Configuration
public class CustomConfig {
// CORS 보호 필터 설정 (React에서 호출 가능) : RestAPI로 호출할 때
	@Bean
	CorsFilter corsFilter() {
		CorsConfiguration config = new CorsConfiguration();
		config.addAllowedOrigin("http://localhost:3000"); // 교차를 허용할 Origin
		config.addAllowedMethod(CorsConfiguration.ALL); // 교차를 허용할 Method
		config.addAllowedHeader(CorsConfiguration.ALL); // 교차를 허용할 Header
		config.setAllowCredentials(true); // 요청/응답에 자격증명정보 포함을 허용
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		
		// 프론트와 통신을 위하여
		config.addExposedHeader("Authorization"); // "Authorization" 헤더를 클라이언트에게 노출하도록 설정
		source.registerCorsConfiguration("/**", config); // 교차를 허용할 Origin의 URL
		
		return new CorsFilter(source);
	}
}