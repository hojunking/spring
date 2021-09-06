/**
 * 
 */
package com.song.web.board.domain;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author admin
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {
	private long bno;							//게시글번호
	private String title;						//제목
	private String content;						//내용
	private String writer;						//작성자
	@JsonFormat  (pattern = "yyyy/MM/dd")		//작성일자
	private Date regdate;
	@JsonIgnore 								//수정일자
	private Date updatedate;
	
	//값을 안불러 오고 싶을땐 JsonIgnore
}
 