package repository;

public class DTOobject {

    String uname;
    String upassword;
    String  urole;

    DTOobject(){

    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUrole() {
        return urole;
    }

    public void setUrole(String urole) {
        this.urole = urole;
    }

    public DTOobject(String uname, String upassword, String urole) {
        this.uname = uname;
        this.upassword = upassword;
        this.urole = urole;
    }
}
