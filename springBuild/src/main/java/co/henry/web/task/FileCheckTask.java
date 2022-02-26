package co.henry.web.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import co.henry.web.task.FileCheckTask;

import lombok.extern.java.Log;
@Log
@Component
public class FileCheckTask {
	@Scheduled(cron = "0 10 * * * *")
	public void checkFile() {
		log.info("file----check!");
		log.info("==================");
	}
}
