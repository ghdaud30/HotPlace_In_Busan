package busan.food.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString(exclude="ReviewsList") // 순환 참조 문제를 해결하기 위해서
public class Member {
	@Id
	private String username;
	
	private String password;
	private String nickname;
	private String telephone;
	private String email;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@Builder.Default
	private Date date = new Date();
	
	@OneToMany(mappedBy="member", fetch=FetchType.EAGER)
	private List<Reviews> ReviewsList = new ArrayList<>();
}