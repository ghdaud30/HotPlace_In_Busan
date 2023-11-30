package busan.food.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import busan.food.domain.Member;
import busan.food.repogitory.MemberRepository;

@Service
public class UpdateServicelmpl implements UpdateService{
	
	// 비밀번호 암호화
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private MemberRepository memberRepository;
	
	// 회원 정보 수정 함수
	public Member profileUpdate(Member member) {
		
		String nickname = member.getNickname();
		String email = member.getEmail();
		
		// 기존에 존재하는 회원 정보 조회
        Member existingMember = memberRepository.findByUsername(member.getUsername()).orElse(null);
		
		Optional<Member> memberNickName = memberRepository.findByNickname(nickname);
		Optional<Member> memberEmail = memberRepository.findByEmail(email);
		
		if(memberNickName.isPresent()) {
			System.out.println("중복된 닉네임이 존재합니다");
			return null;
		}
		else if(memberEmail.isPresent()) {
			System.out.println("중복된 이메일이 존재합니다");
			return null;
		}
		else {
			try {
				existingMember.setNickname(nickname);
				existingMember.setEmail(email);
				existingMember.setPassword(encoder.encode(member.getPassword()));
				existingMember.setTelephone(member.getTelephone());
				existingMember.setDate(new Date());
				
				memberRepository.save(existingMember);
				
				System.out.println("회원 정보 수정에 성공 하였습니다");
				return existingMember;
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				System.out.println("회원 정보 수정에 실패 하였습니다");
				return null;
			}
		}
		

	}
}
