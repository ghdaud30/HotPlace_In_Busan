package busan.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import busan.food.domain.Member;
import busan.food.service.UpdateService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UpdateController {
	
	@Autowired
	private UpdateService updateService;
	
	// 회원 정보 수정 함수
	@PatchMapping("api/profile/update")
	public ResponseEntity<?> profileUpdate(@RequestBody Member member) {
		Member updateMember = updateService.profileUpdate(member);
		
		if(updateMember == null) {
			return ResponseEntity.badRequest().body("회원 정보 수정 실패");
		}
		else {
			return ResponseEntity.ok("회원 정보 수정 성공");
		}
	}
}
