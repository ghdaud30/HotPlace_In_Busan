package busan.food.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import busan.food.domain.Member;
import busan.food.repogitory.MemberRepository;

@Service
public class HotPlaceServicelmpl implements HotPlaceService {
	@Autowired
	private MemberRepository memberRepository;

	// 비밀번호 암호화
	@Autowired
	private PasswordEncoder encoder;

	// 회원 가입 함수
	@Override
	public Member sign(Member MemberFormDTO) {
		String password = MemberFormDTO.getPassword();
		String userName = MemberFormDTO.getUsername();
		Optional<Member> memberUserName = memberRepository.findByUsername(userName);
		
		if(memberUserName.isPresent()) {
			System.out.println("아이디가 이미 등록되어 있습니다");
			return null;
		}
		
		Member member = Member.builder().username(MemberFormDTO.getUsername()).password(encoder.encode(password))
				.nickname(MemberFormDTO.getNickname()).telephone(MemberFormDTO.getTelephone())
				.email(MemberFormDTO.getEmail()).build();
		return memberRepository.save(member);
	}

	// 아이디 중복 검증 함수
	@Override
	public boolean validatonID(Member MemberFormDTO) {
		String userName = MemberFormDTO.getUsername();
		Optional<Member> member = memberRepository.findByUsername(userName);

		if (member.isPresent()) {
			//System.out.println("아이디가 중복됩니다");
			return false;
		} else {
			//System.out.println("사용 하실 수 있는 아이디 입니다");
			return true;
		}
	}
	
	// 이메일 중복 검증 함수
	@Override
	public boolean validatonEmail(Member MemberFormDTO) {
		String email = MemberFormDTO.getEmail();
		Optional<Member> member = memberRepository.findByEmail(email);

		if (member.isPresent()) {
			//System.out.println("이메일이 중복됩니다");
			return false;
		} else {
			//System.out.println("사용 하실 수 있는 이메일 입니다");
			return true;
		}
	}
	
	// 닉네임 중복 검증 함수
	@Override
	public boolean validationNickname(Member MemberFormDTO) {
		String nickname = MemberFormDTO.getNickname();
		Optional<Member> member = memberRepository.findByNickname(nickname);

		if (member.isPresent()) {
			//System.out.println("닉네임이 중복됩니다");
			return false;
		} else {
			//System.out.println("사용 하실 수 있는 닉네임 입니다");
			return true;
		}
	}
}
