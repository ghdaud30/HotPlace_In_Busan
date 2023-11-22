package busan.food.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="getfoodkor")
public class GetFoodKor {
	@Id
	private int ucSeq;
	
	private String gugunNm;
	
	private double lat;
	private double lng;
	
	private String title;
	private String addr1;
	private String cntctTel;
	private String homepageUrl;
	private String usageDayWeekAndTime;
	private String rprsntvMenu;
	private String mainImgNormal;
	private String mainImgThumb;
	private String itemcntnts;
}
