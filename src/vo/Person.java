package vo;

public class Person {

	private int pid;
	private String pname;
	private String age;
	private String sex;
	private String dept;
	
	public Person(){}
	
	public int getPid(){
		return pid;
	}
	
	public String getPname(){
		return pname;
	}
	
	public String getAge(){
		return age;
	}
	
	public String getSex(){
		return sex;
	}
	
	public String getDept(){
		return dept;
	}
	
	
	public void setPid(int pid){
		this.pid = pid;
	}
	
	public void setPname(String pname){
		this.pname = pname;
	}
	
	public void setAge(String age){
		this.age = age;
	}
	
	public void setSex(String sex){
		this.sex = sex;
	}
	
	public void setDept(String dept){
		this.dept = dept;
	}
}
