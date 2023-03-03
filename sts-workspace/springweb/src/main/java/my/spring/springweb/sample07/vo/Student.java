package my.spring.springweb.sample07.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	private int studentNumber;
	private String studentName;
	private String studentDept;
	
	
}
