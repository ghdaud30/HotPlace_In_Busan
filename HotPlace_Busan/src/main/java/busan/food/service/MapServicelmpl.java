package busan.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import busan.food.domain.GetFoodEng;
import busan.food.repogitory.GetFoodEngRepository;

@Service
public class MapServicelmpl implements MapService{
	@Autowired
	private GetFoodEngRepository getFoodEngRepository;
	
	// 지도에 맛집 정보(영어 버전) sending
	@Override
	public List<GetFoodEng> mapInfoEng() {
		
		List<GetFoodEng> foodlist = getFoodEngRepository.findAll();
		
		return getFoodEngRepository.saveAll(foodlist);
	}
}
