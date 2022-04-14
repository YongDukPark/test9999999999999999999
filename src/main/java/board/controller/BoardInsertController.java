package board.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;

//BoardList에서 이동
@Controller
public class BoardInsertController {
	
	private final String command = "write.bd";
	private String getPage = "Insert";
	private String gotoPage = "redirect:/List.bd";
	
	@Autowired
	BoardDao bdao;
	
	//insert form 이동
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String doAction(@RequestParam(value = "pageNumber" , required = false) String pageNumber, Model model) {
		
		model.addAttribute("pageNumber",pageNumber);
		
		return getPage;
	}
	
	//submit insert 진행
	@RequestMapping(value=command, method = RequestMethod.POST)
	public ModelAndView doAction(@Valid BoardBean bean, BindingResult result, HttpServletRequest request, 
			@RequestParam(value = "pageNumber" , required = false) String pageNumber) {
		
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.addObject("pageNumber",pageNumber);
			mav.setViewName(getPage);
			return mav;
		}
		
		//상단 시간 데이터 가져오기용, 하단 ip뽑아오기용
		bean.setRegdate(new Timestamp(System.currentTimeMillis()));
		bean.setIp(request.getRemoteAddr());
		
		bdao.setNewContent(bean);
		mav.setViewName(gotoPage);
		
		return mav;
	}
	
}
