package co.henry.web.board.domain;

import java.util.Date;


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
@JsonFilter("UserInfoV2")
public class UserVOV2 extends UserVO{
	private String grade;


}
