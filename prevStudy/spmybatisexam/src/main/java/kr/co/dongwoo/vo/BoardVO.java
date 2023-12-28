package kr.co.dongwoo.vo;

import java.util.Objects;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class BoardVO {
	private int board_num;
	private String board_name;
	private String board_pass;
	private String board_subject;
	private String board_content;
	private String board_file;
	private int board_re_ref;
	private int board_re_lev;
	private int board_re_seq;
	private int board_readcount;
	private String board_date;
	
	public BoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardVO(int board_num, String board_name, String board_pass, String board_subject, String board_content,
			int board_re_ref) {
		super();
		this.board_num = board_num;
		this.board_name = board_name;
		this.board_pass = board_pass;
		this.board_subject = board_subject;
		this.board_content = board_content;
		this.board_re_ref = board_re_ref;
	}

	public BoardVO(int board_num, String board_subject, String board_content) {
		super();
		this.board_num = board_num;
		this.board_subject = board_subject;
		this.board_content = board_content;
	}

	public BoardVO(int board_num, String board_name, String board_pass, String board_subject, String board_content,
			int board_re_ref, int board_re_lev, int board_re_seq, int board_readcount) {
		super();
		this.board_num = board_num;
		this.board_name = board_name;
		this.board_pass = board_pass;
		this.board_subject = board_subject;
		this.board_content = board_content;
		this.board_re_ref = board_re_ref;
		this.board_re_lev = board_re_lev;
		this.board_re_seq = board_re_seq;
		this.board_readcount = board_readcount;
	}

	public BoardVO(int board_re_ref, int board_re_seq) {
		super();
		this.board_re_ref = board_re_ref;
		this.board_re_seq = board_re_seq;
	}
	
	
	
}
