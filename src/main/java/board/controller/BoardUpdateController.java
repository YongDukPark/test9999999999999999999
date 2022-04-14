package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;

//detailView에서 이동
@Controller
public class BoardUpdateController {
	
	private final String command = "update.bd";
	private String getPage = "Update";
	private String gotoPage = "redirect:/List.bd";
	
	@Autowired
	BoardDao bdao;
	
	//update Form 이동
	@RequestMapping(value=command, method = RequestMethod.GET)
	public ModelAndView doAction(@RequestParam("num")int num,
						   @RequestParam("pageNumber")int pageNumber) {
		
		ModelAndView mav = new ModelAndView();
		
		BoardBean bean = bdao.deleteByNumBefore(num);
		
		
		mav.addObject("pageNumber", pageNumber);
		mav.addObject("num", num);	
		mav.addObject("bean", bean);
		mav.setViewName(getPage);
		
		return mav;
	}
	
	//update submit 진행
	@RequestMapping(value=command, method = RequestMethod.POST)
	public ModelAndView doAction(@ModelAttribute("bean") @Valid BoardBean bean,  BindingResult result,
						   HttpServletResponse response, HttpServletRequest request,
						   @RequestParam("pageNumber")int pageNumber ) {
		
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.addObject("num", bean.getNum());
			mav.addObject("pageNumber", pageNumber);
			mav.setViewName(getPage);
			return mav;
		}
		
		
		
		BoardBean beancheck = bdao.deleteByNumBefore(bean.getNum());
		
		//입력한 pass랑 기존 pass랑 비교하는 작업
		if(bean.getPasswd().equals(beancheck.getPasswd())) {
			bdao.update(bean);
			
			mav.addObject("pageNumber",pageNumber);
			mav.setViewName(gotoPage);
			return mav;
		}
		
		
		else {
			
			mav.addObject("bean", beancheck);
			
			mav.addObject("num",bean.getNum());
			mav.addObject("pageNumber", pageNumber);
			
			//한글패치
			response.setContentType("text/html; charset=UTF-8");
			
			//프린트용
			PrintWriter pw = null;
				
			try {
				pw = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}	
			
			pw.println("<script> alert('비밀번호 확인 요망 ^^;;;;;;'); </script>");
			pw.flush();
			
			mav.setViewName(getPage);
			return mav;
		}
		
	}
}
