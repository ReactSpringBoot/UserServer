package Pack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Apple {
	@GetMapping("/")
	public String func00() {
		System.out.println("Apple class Call");
		return "index";
	}
	
	@GetMapping("/t1")
	public String func01() {
		System.out.println("func01 Call");
		
		return "AppleView";
	}
}
