package board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;
import utility.Paging;

//start> response로 이동
@Controller
public class BoardListController {
	
	private final String command = "/List.bd";
	private String getPage = "BoardList";
	
	@Autowired
	private BoardDao bdao;
	
	//list view
	@RequestMapping(value=command, method = RequestMethod.GET)
	public ModelAndView doAction(
			@RequestParam(value="pageNumber",required = false) String pageNumber,
			HttpServletRequest request) {
		
		//count값 호출용
		int totalCount = bdao.getTotalCount();
		
		String url=request.getContextPath()+command;
		Paging pageInfo=new Paging(pageNumber, null, totalCount, url, null, null);
		
		Map<String, String> map=new HashMap<String, String>();
		
		map.put(pageNumber, url);
		
		//list 보이기용
		List<BoardBean> list = bdao.getList(pageInfo,map);
		
		//전체글수 (count) 에서 -1씩 들어가는값
		int num = totalCount+1 - (pageInfo.getPageNumber()-1) * pageInfo.getPageSize();
		
		System.out.println("list : " + list);
		System.out.println(totalCount);
		System.out.println(pageInfo.getPageNumber());
		System.out.println(pageInfo.getPageSize());
		System.out.println(num);
		
		//보낼것들
		ModelAndView mav=new ModelAndView();
		mav.addObject("list",list);
		mav.addObject("totalCount",totalCount);
		mav.addObject("pageInfo",pageInfo);
		mav.addObject("num",num);
		mav.addObject("map",map);
		mav.setViewName(getPage);
		
		return mav;
	}


	
	
	
	
	
}
