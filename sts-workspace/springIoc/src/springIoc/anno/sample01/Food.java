package springIoc.anno.sample01;

public class Food {

	private String foodName;
	private String foodPrice;
	
	public Food() {
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
		System.out.println("setFood()");
	}

	public void setFoodPrice(String foodPrice) {
		this.foodPrice = foodPrice;
		System.out.println("setFoodprice()");
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return foodName+" : "+foodPrice;
	}
	
}
