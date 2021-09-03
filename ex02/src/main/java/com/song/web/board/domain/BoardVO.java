/**
 * 
 */
package com.song.web.board.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
	@DateTimeFormat(pattern = "yyyy-MM-dd")		//작성일자
	private Date regdate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")		//수정일자
	private Date updatedate;
}
