package my.spring.springweb.sample07.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

	private String memberId;
	private String memberName;
	private String memberAddr;
	private String memberHobby;
	private String memberContent;
	
}
