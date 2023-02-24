package springIoc.anno.sample01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myFood") // default : myFoodMgr
public class MyFoodMgr {

	@Autowired // 하나만 적용 -type기반
	@Qualifier(value="unFavoriteFood") // 이름 지정 bean 설정 
	private Food favoriteFood;
	@Autowired
	private Food unFavoriteFood;
	
	
	
	public MyFoodMgr() {
		System.out.println("MyFoodMgr default constructor");
		
	}
	
	
	@Autowired
	public MyFoodMgr(Food favoriteFood) {
		super();
		this.favoriteFood = favoriteFood;
		System.out.println("toString :"+favoriteFood);
	}



	@Override
	public String toString() {
		return favoriteFood+", " +unFavoriteFood;
	    
	}
	
	
}
