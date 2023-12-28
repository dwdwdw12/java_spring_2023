package net.board.action;

public class ActionForward {
	private boolean isRedirect=false;	//false이면 forwarding, true이면 sendredirect를 하는 값을 가진다. //기본값으로 false 설정	
	private String path=null;			//경로(연결될 페이지)
	
	public boolean isRedirect(){
		return isRedirect;
	}
	
	public String getPath(){
		return path;
	}
	
	public void setRedirect(boolean b){	//true로 설정하면
		isRedirect=b;					//redirect하겠다.
	}
	
	public void setPath(String string){
		path=string;
	}
}