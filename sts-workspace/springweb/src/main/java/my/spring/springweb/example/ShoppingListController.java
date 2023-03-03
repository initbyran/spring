package my.spring.springweb.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import my.spring.springweb.example.vo.ShoppingList;

@Controller
@SessionAttributes(value= {"shoppingList"})
public class ShoppingListController {
	
	Logger log = LogManager.getLogger();
	
	@ModelAttribute("shoppingList")
	public ShoppingList createList() {
		
		ShoppingList list = new ShoppingList(null,0,0,0);
		return list;
	}
	
	@GetMapping(value="shoppingCartReset")
	public String clearMyCart() {
		return "example/shoppingCart";
	}
	
	@GetMapping(value="shoppingPage")
	public String myCart(@ModelAttribute("shoppingList") ShoppingList list) {
		
		String item = list.getItem();
	
		if(item.equals("apple")) {
			list.setApple(list.getApple()+1);
		} else if(item.equals("banana")) {
			list.setBanana(list.getBanana()+1);
		} else if(item.equals("halabong")) {
			list.setHalabong(list.getHalabong()+1);
		}
		
	    log.debug(list);
		
	    return "example/shoppingCart";
		
	}
	
	@PostMapping(value="shoppingListReset")
	public String myCart(@ModelAttribute("shoppingList") ShoppingList list,
			SessionStatus sessionStatus) {
		
		
		sessionStatus.setComplete();
		
//		return "redirect:/resources/example/shoppingPage.html";
		return "redirect:/shoppingCartReset";
		
	}

	
}
