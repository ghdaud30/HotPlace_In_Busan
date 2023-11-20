package busan.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import busan.food.domain.Member;
import busan.food.domain.MemberFormDTO;
import busan.food.repogitory.MemberRepository;

@Service
public class HotPlaceServicelmpl implements HotPlaceService{
	@Autowired
	private MemberRepository memberRepository ;

	// 비밀번호 암호화
	@Autowired
	private PasswordEncoder encoder;
		
	@Override
	public Member sign(MemberFormDTO MemberFormDTO) {
		String password = MemberFormDTO.getPassword();
		
		Member member = Member.builder()
				.username(MemberFormDTO.getUsername())
				.password(encoder.encode(password))
				.nickname(MemberFormDTO.getNickname())
				.telephone(MemberFormDTO.getTelephone())
				.email(MemberFormDTO.getEmail())
				.build();
		return memberRepository.save(member);
	}
}
