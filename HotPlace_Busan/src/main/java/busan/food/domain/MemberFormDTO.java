package busan.food.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberFormDTO {
	
	private String username;
	private String password;
	private String nickname;
	private String telephone;
	private String email;
}
