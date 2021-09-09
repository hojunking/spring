package com.song.web.board.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.song.web.board.domain.BoardAttachVO;
import com.song.web.board.domain.BoardVO;
import com.song.web.board.domain.Criteria;
import com.song.web.board.domain.PageVO;
import com.song.web.board.service.BoardAttachSerivce;
import com.song.web.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
//@SessionAttributes("cri") //cri가 있다면 session 태운다
public class BoardController {

	@Autowired
	BoardService boardService;
	@Autowired BoardAttachSerivce attachSerivce;
	// 전체조회
	@GetMapping("/list")
	public void list(Model model, @ModelAttribute("cri") Criteria cri) {
		System.out.println("cri===" + cri);
		int total = boardService.getTotalCount(cri);
		model.addAttribute("list", boardService.getList(cri));
		model.addAttribute("pageMaker", new PageVO(total, cri));

	}

	// 단건조회(수정페이지)
	@GetMapping("/get")
	public void get(Model model, BoardVO vo, @ModelAttribute("cri") Criteria cri) { // bno 파라미터 던져주기 커맨드객체(vo)

		model.addAttribute("board", boardService.read(vo)); // modelAttribute -> 이름설정 해줄 때
	}

	// 수정처리
	@PostMapping("/modify")
	public String modify(BoardVO vo, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		int result = boardService.update(vo);
		if (result == 1) {
			rttr.addFlashAttribute("result", "성공!!");
		}
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		return "redirect:/board/list";
	}

	// 등록페이지
	@GetMapping("/register")
	public void registerForm() {

	}

	String path = "D:/download";

	// 등록처리
	@PostMapping("/register")
	public String register(BoardVO vo, RedirectAttributes rttr, MultipartFile[] uploadFile)
			throws IllegalStateException, IOException {
		// httpservletrequest 객체를 불러 올수도 있다.
		// parameter 값 전달이 되지 않아서 RedirectAttributes라는 객체를 이용해 값을 담아 전달한다

//		List<BoardAttachVO> list = new ArrayList<BoardAttachVO>();
//		for (int i = 0; i < uploadFile.length; i++) {
//			MultipartFile ufile = uploadFile[i];
//			if (!ufile.isEmpty() && ufile.getSize() > 0) {
//
//				UUID uuid = UUID.randomUUID();
//				String filename = ufile.getOriginalFilename();
//
//				// String saveName = System.currentTimeMillis() + "";
//				File file = new File(path, uuid + filename);
//				ufile.transferTo(file);
//
//				BoardAttachVO attachvo = new BoardAttachVO();
//				attachvo.setUuid(uuid.toString());
//				attachvo.setFileName(filename);
//				attachvo.setUploadPath(path);
//				list.add(attachvo);
//			}
//		}
//		vo.setAttachList(list);

		boardService.insert(vo);
		rttr.addFlashAttribute("result", vo.getBno());
		return "redirect:/board/list"; // redirect는 parameter 전달 X
	}

	@RequestMapping(value = "/download")
	public void cvplFileDownload(@RequestParam Map<String, Object> commandMap, HttpServletRequest
	request, HttpServletResponse response) throws Exception {
		String uuid = (String) commandMap.get("uuid");
	
		//uuid로 첨부파일 검색
	BoardAttachVO attachVO = attachSerivce.read(uuid);
	String fileName ="";
		if(attachVO !=null) {
			fileName =attachVO.getFileName();
		}
	File uFile = new File("d:/download", uuid+fileName);
	long fSize = uFile.length();
	if (fSize > 0) {
	String mimetype = "application/x-msdownload";
	response.setContentType(mimetype);
	response.setHeader("Content-Disposition", "attachment; filename=\"" + 
						URLEncoder.encode(fileName, "utf-8") + "\"");
//	setDisposition(atchFileId, request, response);
	BufferedInputStream in = null;
	BufferedOutputStream out = null;
	try {
	in = new BufferedInputStream(new FileInputStream(uFile)); //서버에서 파일 열기
	out = new BufferedOutputStream(response.getOutputStream()); // 파일 챙기고 나오기
	FileCopyUtils.copy(in, out);
	out.flush();
	} catch (IOException ex) {
	} finally {
	in.close(); response.getOutputStream().flush(); response.getOutputStream().close();
	}
	} else { //파일이 없을 경우 메시지들
	response.setContentType("application/x-msdownload");
	PrintWriter printwriter = response.getWriter();
	printwriter.println("<html>");
	printwriter.println("<h2>Could not get file name:<br>" + fileName + "</h2>");
	printwriter.println("<center><h3><a href='javascript: history.go(-1)'>Back</a></h3></center>");
	printwriter.println("&copy; webAccess");
	printwriter.println( "</html>");
	printwriter.flush();
	printwriter.close();
	}
	}

	// 삭제처리
	@PostMapping("/delete")
	public String delete(BoardVO vo, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		int result = boardService.delete(vo);
		if (result == 1) {
			rttr.addFlashAttribute("result", "삭제성공!!");
		}
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount()); // 세션사용으로 없어도 된다.
		return "redirect:/board/list";
	}

}
