package busan.food.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberFormDTO {
	
	private String account;
	private String password;
	private String nickname;
	private String telephone;
	private String email;
}
