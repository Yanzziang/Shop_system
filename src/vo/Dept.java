package vo;

public class Dept {

	private int did;
	private String dept;
	private String manage;
	
	public Dept(){}
	
	public int getDid(){
		return did;
	}
	
	public String getDept(){
		return dept;
	}
	
	public String getManage(){
		return manage;
	}
	
	public void setManage(String manage){
		this.manage = manage;
	}
	
	public void setDid(int did){
		this.did = did;
	}
	
	public void setDept(String dept){
		this.dept = dept;
	}
}
