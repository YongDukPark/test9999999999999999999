package board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;

//BoardList에서 이동
@Controller
public class BoardDetailViewController {
	
	private final String command = "detailContent.bd";
	private String getPage = "DetailView";
	
	@Autowired
	private BoardDao bdao;
	
	//글 보기
	@RequestMapping(value=command, method = RequestMethod.GET)
	public ModelAndView doAction(@RequestParam(value="num", required = true) String num,
								 @RequestParam(value="pageNumber", required = true)int pageNumber
								) {
		
		ModelAndView mav = new ModelAndView();
		
		BoardBean bean = bdao.getByNumView(num);
		
		mav.addObject("bean", bean);
		mav.addObject("pageNumber", pageNumber);
		
		mav.setViewName(getPage);
		
		return mav;
	}
}
