package com.song.web.task;

import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Component
@Log
public class FileCheckTask {

	/*
	 * @Scheduled(cron = "0/10 * * * *") (fixedDelay = 5000) /->기간, ,는 1분기준 public
	 * void checkFile() { log.info("file----check!");
	 * log.info("=================="); }
	 */
}
