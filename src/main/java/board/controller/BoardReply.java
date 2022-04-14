package board.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
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
public class BoardReply {
	
	private final String command = "reply.bd";
	private String getPage = "Reply";
	private String gotoPage = "redirect:/List.bd";
	
	@Autowired
	BoardDao bdao;
	
	//reply form
	@RequestMapping(value=command, method = RequestMethod.GET)
	public ModelAndView doAction(
								@RequestParam(value = "ref")int ref,
								@RequestParam(value = "restep")int restep,
								@RequestParam(value = "relevel")int relevel) {
		
		System.out.println("ref : "+ref);
		System.out.println("restep : " + restep );
		System.out.println("relevel : " + relevel);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("ref",ref);
		mav.addObject("restep",restep);
		mav.addObject("relevel",relevel);
		mav.setViewName(getPage);
		
		return mav;
	}
	
	//reply submit 진행
	@RequestMapping(value=command, method = RequestMethod.POST)
	public ModelAndView doAction(@ModelAttribute("bean") @Valid BoardBean bean ,BindingResult result , 
							@RequestParam("ref")int ref,
							@RequestParam("restep")int restep,
							@RequestParam("relevel")int relevel,
							HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.addObject("ref", ref);
			mav.addObject("restep",restep);
			mav.addObject("relevel",relevel);
			
			mav.setViewName(getPage);
			return mav;
		}
		
		//상단 시간 데이터 가져오기용, 하단 ip뽑아오기용
		bean.setRegdate(new Timestamp(System.currentTimeMillis()));
		bean.setIp(request.getRemoteAddr());
		
		bean.setRef(ref);
		
		
		System.out.println("bean.getNum() : "+bean.getNum());
		System.out.println("bean.getWriter() : "+bean.getWriter());
		System.out.println("bean.getEmail() : "+bean.getEmail());
		System.out.println("bean.getSubject() : "+bean.getSubject());
		System.out.println("bean.getPasswd() : "+bean.getPasswd());
		System.out.println("bean.getRegdate() : "+bean.getRegdate());
		System.out.println("bean.getReadcount() : "+bean.getReadcount());
		System.out.println("bean.getRef() : "+bean.getRef());
		System.out.println("bean.getRestep() : "+bean.getRestep());
		System.out.println("bean.getRelevel() : "+bean.getRelevel());
		System.out.println("bean.getContent() : "+bean.getContent());
		System.out.println("bean.getIp() : "+bean.getIp());
		
		bdao.reply(bean,restep,relevel);
		
		mav.setViewName(gotoPage);
		
		return mav; 
	}
	
}
