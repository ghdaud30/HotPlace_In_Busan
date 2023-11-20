package busan.food.service;

import org.springframework.stereotype.Service;

import busan.food.domain.Member;
import busan.food.domain.MemberFormDTO;

@Service
public interface HotPlaceService {
	 public Member sign(MemberFormDTO MemberFormDTO);
}
