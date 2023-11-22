package busan.food;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import busan.food.domain.GetFoodEng;
import busan.food.repogitory.GetFoodEngRepository;

@SpringBootTest
class HotPlaceBusanApplicationTests {

	@Autowired
	GetFoodEngRepository getFoodEngRepository;
	
	@Test
	@Order(1)
	@DisplayName("DB에서 맛집 정보 영어 데이터 가져오기")
	void DBdata() {
		List<GetFoodEng> foodlist = getFoodEngRepository.findAll();
		for(GetFoodEng food : foodlist) {
			System.out.println(food.getUcSeq());
		}
	}
	
}
