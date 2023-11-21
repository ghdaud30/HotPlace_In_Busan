package busan.food.repogitory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import busan.food.domain.Member;

public interface MemberRepository extends JpaRepository<Member,Long>{
	// 아이디 중복 확인
	Optional<Member> findByUsername(String username);
	// 이메일 중복 확인
	Optional<Member> findByEmail(String email);
	// 닉네임 중복 확인
	Optional<Member> findByNickname(String nickname);
}
