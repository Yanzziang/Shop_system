package vo;


public class User {
    //private int id;//���
    private String username;//�û���
    private String userpass;//����
    private String name;//����
    private String sex;//�Ա�
    private String birth;//����
    private String idcard;//���֤
    private String addr;//��ַ
    private String phone;//�绰
    private String remark;//��ע
    private boolean p1;//ϵͳȨ��
    private boolean p2;//���Ȩ��
    private boolean p3;//����Ȩ��
    private boolean p4;//����Ȩ��
    private boolean p5;//��ѯȨ��
    private boolean p6;
    public User() {
    }

    public String getUserpass() {
        return userpass;
    }

    public String getUsername() {
        return username;
    }

    public String getSex() {
        return sex;
    }

    public String getRemark() {
        return remark;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isP5() {
        return p5;
    }

    public boolean isP4() {
        return p4;
    }

    public boolean isP3() {
        return p3;
    }

    public boolean isP2() {
        return p2;
    }

    public boolean isP1() {
        return p1;
    }

    public boolean isP6() {
        return p6;
    }
    public String getName() {
        return name;
    }

    public String getIdcard() {
        return idcard;
    }

    /*public int getId() {
        return id;
    }*/

    public String getBirth() {
        return birth;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setP5(boolean p5) {
        this.p5 = p5;
    }

    public void setP4(boolean p4) {
        this.p4 = p4;
    }

    public void setP3(boolean p3) {
        this.p3 = p3;
    }

    public void setP6(boolean p6) {
        this.p6 = p6;
    }
    
    public void setP2(boolean p2) {
        this.p2 = p2;
    }

    public void setP1(boolean p1) {
        this.p1 = p1;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    /*public void setId(int id) {
        this.id = id;
    }*/

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getAddr() {
        return addr;
    }

}
