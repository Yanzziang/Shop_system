package vo;

public class Log {
    private int id;//���
    //private String userid;//�û�id
    private String username;//�û���
    private String stime;
    private String etime;

    public Log() {
    }

    public String getUsername() {
        return username;
    }

   /* public String getUserid() {
        return userid;
    }*/

    public String getStime() {
        return stime;
    }

    public int getId() {
        return id;
    }

    public void setEtime(String etime) {
        this.etime = etime;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /*public void setUserid(String userid) {
        this.userid = userid;
    }*/

    public void setStime(String stime) {
        this.stime = stime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEtime() {
        return etime;
    }

}
