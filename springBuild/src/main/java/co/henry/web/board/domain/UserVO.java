package co.henry.web.board.domain;

import java.util.Date;

//import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value={"password" ,"ssn"})  //여기서 설정할 수 있다.
//@JsonFilter("UserInfo")
public class UserVO {
	
	private Integer id;
//	@Size(min=2)
	private String name;
//	@Past
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date joinDate;
	private String password;
	private String ssn;

}
