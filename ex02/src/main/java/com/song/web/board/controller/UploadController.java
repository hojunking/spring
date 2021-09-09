package com.song.web.board.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.song.web.board.domain.BoardAttachVO;
import com.song.web.board.domain.BoardVO;

import lombok.extern.java.Log;

@Log
@Controller
public class UploadController {

	@PostMapping("/uploadFormAction")

	public void uploadFormAction(MultipartFile[] uploadFile) throws IllegalStateException, IOException {
		for (int i = 0; i < uploadFile.length; i++) {
			MultipartFile ufile = uploadFile[i];
			if (!ufile.isEmpty() && ufile.getSize() > 0) {
				String filename = ufile.getOriginalFilename();
				String saveName = System.currentTimeMillis() + ""; //
				File file = new File("D:/download", saveName);
				ufile.transferTo(file);

			}
		}

	}

	@PostMapping("/uploadAjaxAction")
	@ResponseBody //ajax 요청은 reponsebody로 return값을 넘ㄱ니다.
	public List<BoardAttachVO> uploadAjaxAction(MultipartFile[] uploadFile,
									BoardVO vo) throws IllegalStateException, IOException {
		List<BoardAttachVO> list = new ArrayList<BoardAttachVO>();
		String path ="d:/download";
		for (int i = 0; i < uploadFile.length; i++) {
			MultipartFile ufile = uploadFile[i];
			if (!ufile.isEmpty() && ufile.getSize() > 0) {

				String filename = ufile.getOriginalFilename();
				UUID uuid = UUID.randomUUID();
				// String saveName = System.currentTimeMillis() + "";
				File file = new File(path, uuid + filename);
				ufile.transferTo(file);
				BoardAttachVO attachvo = new BoardAttachVO();
				attachvo.setUuid(uuid.toString());
				attachvo.setFileName(filename);
				attachvo.setUploadPath(path);
				list.add(attachvo);
			}
		}
		return list;
	}	
	@GetMapping("page1")
	public void page1(HttpServletResponse response) throws IOException{
//		String mimeType = "application/x-msdownload"; 
//		response.setContentType(mimeType);   
		// ㄷ다운로드 해버린다.
		response.setContentType("text/html; charset=UTF-8"); //jsp 위에 있는 친구들, text환경설정 타입을 정해줄 수 있다.
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<div>텥슼트입닏ㅇ</div>");
		out.println("</body>");
		out.println("</html>");
	}
	@GetMapping("page2")
	public ResponseEntity<BoardVO> page2(@RequestParam int h){
		//참고페이지 364
		ResponseEntity<BoardVO> result = null;
		if(h<10) {
			result = ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new BoardVO());
		}else {
			result = ResponseEntity.status(HttpStatus.OK).body(new BoardVO());
		}
		return result;
		
	}
	
	
	
	
	
	
}
