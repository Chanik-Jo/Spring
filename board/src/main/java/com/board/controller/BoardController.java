package com.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.domain.BoardVO;
import com.board.domain.Page;
import com.board.domain.ReplyVO;
import com.board.service.BoardService;
import com.board.service.ReplyService;

@Controller
//@RequestMapping("/board/*")
@RequestMapping("/forum/*")
public class BoardController {

	@Inject
	private BoardService service;

	@Inject
	private ReplyService replyService;

	// 게시물 전체 목록
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getList(Model model) throws Exception {

		List<BoardVO> list = null;
		list = service.list();//boradmapper 전체목록 출력
		model.addAttribute("list", list);
		return "redirect:/forum/listPageSearch?num=1&searchType=title&keyword=";
	}

	// 특정 게시물 조회
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String getView(@RequestParam("bno") int bno, Model model) throws Exception {

		BoardVO vo = service.view(bno);//bno에 맞는 값 유일한 BoardVO만 준다. 위의 목록은 BoardVO의 list.
		service.viewCountIncrease(vo);
		model.addAttribute("view", vo);

		// 댓글 조회
		List<ReplyVO> reply = null;
		reply = replyService.list(bno);//bno로 미루어보아 "이 글에 마련된 전체 댓글의 리스트"를 불러오고 있는 중이다.
		model.addAttribute("reply", reply);
		return "nicePage/postShow";

	}

	// 게시물 작성 창 열기
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String getWirte() throws Exception {
		return "nicePage/newPost";
	}

	// 게시물 작성 실제로 저장
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String posttWirte(BoardVO vo) throws Exception {
		service.write(vo);//db저장후

		return "redirect:/forum/";//리다이렉트
	}

	// 게시물 수정창 열기
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String getModify(@RequestParam("bno") int bno, Model model) throws Exception {

		BoardVO vo = service.view(bno);//일단 옛날에 저장된값을 불러와서

		model.addAttribute("view", vo);//보여줘야 할거 아니냐
		return "nicePage/editPost";
	}

	// 게시물 수정 저장하기
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String postModify(BoardVO vo/*jsp form에 있는 boardVo와 일치하는 name값들을 인식후 자동으로 불러와 저장.*/) throws Exception {

		service.modify(vo);//modify하는 건 좋은데 bno가 어디에 있어서????

		return "redirect:/forum/view?bno=" + vo.getBno();//수정된 결과 보여주기
	}

	// 게시물 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String getDelete(@RequestParam("bno") int bno) throws Exception {

		service.delete(bno);

		return "redirect:/forum/";
	}

	// 게시물 목록 + 페이징 추가
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public String getListPage(Model model, @RequestParam("num") int num) throws Exception {
		// Model 은 request.setAttribute()와 동일하다.
		Page page = new Page();// Page 계산용(예를 들어 41이 시작페이지면 50까지 보여주거나 혹은 이전/다음 페이지 10단위로 존재여부)
		if(num<=0)
			page.setNum(1);
		page.setNum(num);
		page.setCount(service.count());//페이지 카운트 전용.

		List<BoardVO> list = null;
		list = service.listPage(page.getDisplayPost(), page.getPostNum());// Board service를 거쳐 BoardDAOImpl를 최종호출.

		model.addAttribute("list", list); // 모델 객체에 등록하는것 만으로도 오토로 등록된다.
		// service.listpage가 단계적으로 들어가서 결국 sql문으로 반환한다.

		/*
		 * model.addAttribute("pageNum", page.getPageNum());
		 * 
		 * model.addAttribute("startPageNum", page.getStartPageNum());
		 * model.addAttribute("endPageNum", page.getEndPageNum());
		 * 
		 * model.addAttribute("prev", page.getPrev()); model.addAttribute("next",
		 * page.getNext());
		 */

		model.addAttribute("page", page);

		model.addAttribute("select", num);

		/*
		 * // 게시물 총 갯수 int count = service.count();
		 * 
		 * // 한 페이지에 출력할 게시물 갯수 int postNum = 10;
		 * 
		 * // 하단 페이징 번호 ([ 게시물 총 갯수 ÷ 한 페이지에 출력할 갯수 ]의 올림) int pageNum =
		 * (int)Math.ceil((double)count/postNum);
		 * 
		 * // 출력할 게시물 int displayPost = (num - 1) * postNum;
		 * 
		 * 
		 * // 한번에 표시할 페이징 번호의 갯수 int pageNum_cnt = 10;
		 * 
		 * // 표시되는 페이지 번호 중 마지막 번호 int endPageNum = (int)(Math.ceil((double)num /
		 * (double)pageNum_cnt) * pageNum_cnt);
		 * 
		 * // 표시되는 페이지 번호 중 첫번째 번호 int startPageNum = endPageNum - (pageNum_cnt - 1);
		 * 
		 * // 마지막 번호 재계산 int endPageNum_tmp = (int)(Math.ceil((double)count /
		 * (double)pageNum_cnt));
		 * 
		 * if(endPageNum > endPageNum_tmp) { endPageNum = endPageNum_tmp; }
		 * 
		 * boolean prev = startPageNum == 1 ? false : true; boolean next = endPageNum *
		 * pageNum_cnt >= count ? false : true;
		 * 
		 * List<BoardVO> list = null; list = service.listPage(displayPost, postNum);
		 * model.addAttribute("list", list); model.addAttribute("pageNum", pageNum);
		 * 
		 * // 시작 및 끝 번호 model.addAttribute("startPageNum", startPageNum);
		 * model.addAttribute("endPageNum", endPageNum);
		 * 
		 * // 이전 및 다음 model.addAttribute("prev", prev); model.addAttribute("next",
		 * next);
		 * 
		 * // 현재 페이지 model.addAttribute("select", num);
		 */return "nicePage/forum";
	}

	// 게시물 목록 + 페이징 추가 + 검색
	@RequestMapping(value = "/listPageSearch", method = RequestMethod.GET)
	public String getListPageSearch(Model model, @RequestParam("num") int num,
			@RequestParam(value = "searchType", required = false, defaultValue = "title") String searchType,
			@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword // 검색 명령을 사이트 주소에 박아서
																									// 가져온다.
	) throws Exception {

		Page page = new Page();
		if(num<=0)
			page.setNum(1);
		page.setNum(num);
		// page.setCount(service.count());
		page.setCount(service.searchCount(searchType, keyword));

		// 검색 타입과 검색어
		// page.setSearchTypeKeyword(searchType, keyword);
		page.setSearchType(searchType);
		page.setKeyword(keyword);
		model.addAttribute("page", page);
		List<BoardVO> list = null;
		// list = service.listPage(page.getDisplayPost(), page.getPostNum());
		list = service.listPageSearch(page.getDisplayPost(), page.getPostNum(), searchType, keyword);

		model.addAttribute("list", list);

		model.addAttribute("select", num);

		// model.addAttribute("searchType", searchType);
		// model.addAttribute("keyword", keyword);
		return "nicePage/forum";
	}

}
