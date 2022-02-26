package com.song.web.board.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyVO {
	private long rno;
	private	long bno;
	private String reply;
	private String replyer;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date replydate;
	private Date updatedate;
}
