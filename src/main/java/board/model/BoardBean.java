package board.model;

import java.sql.Timestamp;

import org.hibernate.validator.constraints.NotBlank;

public class BoardBean {
	
	private int num;
	
	@NotBlank(message = "반드시입력")
	private String writer;
	
	@NotBlank(message = "반드시입력")
	private String email;
	
	@NotBlank(message = "반드시입력")
	private String subject;
	
	@NotBlank(message = "반드시입력")
	private String passwd;
	
	private Timestamp regdate;		//기존에는 String을 사용했으나 Timestamp로 이용해보기
	private int readcount;
	private int ref;
	private int restep;
	private int relevel;
	
	@NotBlank(message = "반드시입력")
	private String content;
	private String ip;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRestep() {
		return restep;
	}
	public void setRestep(int restep) {
		this.restep = restep;
	}
	public int getRelevel() {
		return relevel;
	}
	public void setRelevel(int relevel) {
		this.relevel = relevel;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
}
