package busan.food.service;

import java.util.List;

import org.springframework.stereotype.Service;

import busan.food.domain.GetFoodEng;

@Service
public interface MapService {
	
	// 지도에 맛집 정보(영어 버전) sending
	public List<GetFoodEng> mapInfoEng();

}
