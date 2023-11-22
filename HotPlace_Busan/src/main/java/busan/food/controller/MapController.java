package busan.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import busan.food.domain.GetFoodEng;
import busan.food.service.MapService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MapController {
	
	@Autowired
	MapService mapService;
	
	//지도 맛집 정보(영어 버전) sending
	@GetMapping("/mapInfoEng")
	public List<GetFoodEng> mapInfoEng(){
		List<GetFoodEng> foodEngList = mapService.mapInfoEng();
		
		if(foodEngList != null) {
			System.out.println("지도 정보(영어 버전)" + foodEngList);
			return foodEngList;
		}
		else {
			System.out.println("지도 정보(영어버전) 출력 실패");
			return null;
		}
	}
}
