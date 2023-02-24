package springIoc.sample04;

import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class AbstractDay {

    public abstract String dayInfo();
    
    // factory method - abstract class이지만 instance를 생성할 수 있다
    public static AbstractDay getInstance() {
    	
    	// 오늘 날짜의 요일 - calendar 객체를 통해
    	GregorianCalendar cal = new GregorianCalendar();
    	// 해당 날짜에 대한 요일을 숫자로 알려준다 ; 1=>일, 2=>월, 3=>화,...
    	int day = cal.get(Calendar.DAY_OF_WEEK);
    	
    	AbstractDay my_day = null;
    	switch(day) {
    	
    	case 1: 	
    		my_day = new Sunday();
    		break;
    	case 2: 	
    		my_day = new Monday();
    		break;
    	case 3: 	
    		my_day = new Tuesday();
    		break;
    	}
    	
		return my_day;
    	
    }
}
