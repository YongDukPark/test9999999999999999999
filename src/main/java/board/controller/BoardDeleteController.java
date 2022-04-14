package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import board.model.BoardBean;
import board.model.BoardDao;

//DetailView ���� �̵�
@Controller
public class BoardDeleteController {

	private final String command = "delete.bd";
	private String getPage = "Delete";
	private String gotoPage;
	
	@Autowired
	private BoardDao bdao;
	
	//delete form �̵�
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String doAction(
							@RequestParam("num") int num,
							@RequestParam("pageNumber") int pageNumber,
							Model model
			) {
		
		model.addAttribute("num",num);
		model.addAttribute("pageNumber",pageNumber);
		
		return getPage;
	}
	
	//submit delete ����
	@RequestMapping(value=command, method = RequestMethod.POST)
	public String doAction(
							@RequestParam("num") int num,
							@RequestParam("pageNumber") int pageNumber,
							@RequestParam("password") String password,
							BoardBean bean, Model model, HttpServletResponse response) {
		
		
		
		bean = bdao.deleteByNumBefore(num);
		
		if(bean.getPasswd().equals(password)) {
			
			bdao.deleteByNumAfter(num);
			
			model.addAttribute("pageNumber",pageNumber);
			
			gotoPage = "redirect:/List.bd";
		}
		else {
			
			model.addAttribute("num",num);
			model.addAttribute("pageNumber",pageNumber);
			
			//�ѱ���ġ
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter pw = null;
				
			try {
				pw = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}	
			pw.println("<script> alert('��й�ȣ Ȯ�� ��� ^^'); </script>");
			pw.flush();
			
			return getPage;
		}
		
		return gotoPage;
	}
	
}
