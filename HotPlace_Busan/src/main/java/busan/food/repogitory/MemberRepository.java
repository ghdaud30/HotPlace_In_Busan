package busan.food.repogitory;

import org.springframework.data.jpa.repository.JpaRepository;

import busan.food.domain.Member;

public interface MemberRepository extends JpaRepository<Member,Long>{

}
