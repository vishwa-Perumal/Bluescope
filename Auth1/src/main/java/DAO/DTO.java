package DAO;

public class DTO {
	
	private String ename;
	private String enpassword;
	
	public DTO(String ename,String enpassword) {
		this.ename=ename;
		this.enpassword=enpassword;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getPassword() {
		return enpassword;
	}

	public void setPassword(String enpassword) {
		this.enpassword = enpassword;
	}
	
	

}
