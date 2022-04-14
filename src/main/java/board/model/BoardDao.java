package board.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("myBoardDao")
public class BoardDao {
	
	@Autowired	//어디선가 만들어진 객체를 가져와서 넣어라
	private SqlSessionTemplate sqlSessionTemplate;
	
	private String namespace = "board.model.Board";

	
	//count용
	public int getTotalCount() {
		
		int count = sqlSessionTemplate.selectOne(namespace+".getTotalCount");
		
		return count;
	}
	
	//list 가져오기용
	public List<BoardBean> getList(Paging pageInfo, Map<String, String> map) {
		
		//시작
		int startRow = (pageInfo.getPageNumber()-1) * pageInfo.getPageSize()+1;
		//끝
		//int endRow = pageInfo.getPageNumber() * pageInfo.getPageSize();
		int endRow = pageInfo.getTotalCount();
		
		//int 문자열로 변환
		String StartRow = Integer.toString(startRow);
		String EndRow = Integer.toString(endRow);
		
		System.out.println("pageInfo.getPageNumber() : " + pageInfo.getPageNumber());
		System.out.println("pageInfo.getTotalCount() : "+pageInfo.getTotalCount());
		
		
		System.out.println("StartRow : " + StartRow);
		System.out.println("EndRow : " + EndRow);
		
		//map에 셋팅
		map.put("startRow",StartRow);
		map.put("endRow",EndRow);
		
		System.out.println("pageInfo.getPageNumber() : " + pageInfo.getPageNumber());
		System.out.println("pageInfo.getPageSize() : " + pageInfo.getPageSize());
		System.out.println("StartRow : " + StartRow);
		System.out.println("EndRow : " + EndRow);
		
		List<BoardBean> lists = new ArrayList<BoardBean>();
		
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		
		lists = sqlSessionTemplate.selectList(namespace+".getList",map,rowBounds);
		
		return lists;
	}

	//특정번호 조건으로 조회 readcount up
	public BoardBean getByNumView(String num) {
		
		sqlSessionTemplate.update(namespace+".countUp",num);
		BoardBean bean = sqlSessionTemplate.selectOne(namespace+".getByNumView",num);
		
		return bean;
	}

	//번호로 가져옴 password용
	public BoardBean deleteByNumBefore(int num) {
		
		BoardBean bean = sqlSessionTemplate.selectOne(namespace+".getByNumView",num);
		
	return bean;
	}

	//delete
	public void deleteByNumAfter(int num) {
		
		sqlSessionTemplate.delete(namespace+".delete",num);
		
	}

	//insert 진행
	public void setNewContent(BoardBean bean) {
		
		System.out.println("num : "+bean.getNum());
		System.out.println("writer : "+bean.getWriter());
		System.out.println("email : "+bean.getEmail());
		System.out.println("subject : "+bean.getSubject());
		System.out.println("password : "+bean.getPasswd());
		System.out.println("readcount : "+bean.getReadcount());
		System.out.println("ref : "+bean.getRef());
		System.out.println("restep : "+bean.getRestep());
		System.out.println("relevel : "+bean.getRelevel());
		System.out.println("content : "+bean.getContent());
		System.out.println("ip : "+bean.getIp());
		
		sqlSessionTemplate.insert(namespace+".setNewContent",bean);
		
	}

	//update진행
	public int update(BoardBean bean) {
		
		int cnt = sqlSessionTemplate.update(namespace+".update",bean);
		
		return cnt;
	}
	
	//답글 작성
	public void reply(BoardBean bean,int restep, int relevel) {
		
		sqlSessionTemplate.update(namespace+".replyUpdate",bean);
		bean.setRestep(restep+1);
		bean.setRelevel(relevel+1);
		sqlSessionTemplate.insert(namespace+".repInsert",bean);
		
	}
}
