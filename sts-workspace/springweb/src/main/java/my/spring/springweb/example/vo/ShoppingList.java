package my.spring.springweb.example.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingList {

	private String item;
	
	private int banana;
	private int apple;
	private int halabong;
	
}
