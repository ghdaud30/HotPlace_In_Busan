package busan.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import busan.food.domain.Member;
import busan.food.domain.MemberFormDTO;
import busan.food.repogitory.MemberRepository;

@Service
public class HotPlaceServicelmpl implements HotPlaceService{
	@Autowired
	private MemberRepository memberRepository ;

	@Override
	public Member sign(MemberFormDTO MemberFormDTO) {
		Member member = Member.builder()
				.username(MemberFormDTO.getUsername())
				.password(MemberFormDTO.getPassword())
				.nickname(MemberFormDTO.getNickname())
				.telephone(MemberFormDTO.getTelephone())
				.email(MemberFormDTO.getEmail())
				.build();
		return memberRepository.save(member);
	}
}
