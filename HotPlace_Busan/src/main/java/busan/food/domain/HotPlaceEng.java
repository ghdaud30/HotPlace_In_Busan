package busan.food.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class HotPlaceEng {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int UC_SEQ;
	
	private String GUGUN_NM;
	
	private float LAT;
	private float LNG;
	
	private String TITLE;
	private String ADDR1;
	private String CNTCT_TEL;
	private String HOMEPAGE_URL;
	private String USAGE_DAY_WEEK_AND_TIME;
	private String RPRSNTV_MENU;
	private String MAIN_IMG_NORMAL;
	private String MAIN_IMG_THUMB;
	private String ITEMCNTNTS;
}
