package vo;


public class Supplier {
    private int sid;//供货商编号
    private String name;//供货商名字
    private String person;//法人
    private String phone;//电话
    private String tel;//手机
    private String telc;//传真
    private String addr;//地址
    private String remark;//备注

    public Supplier() {
    }

    public String getTelc() {
        return telc;
    }

    public String getTel() {
        return tel;
    }

    public int getSid() {
        return sid;
    }

    public String getRemark() {
        return remark;
    }

    public String getPhone() {
        return phone;
    }

    public String getPerson() {
        return person;
    }

    public String getName() {
        return name;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setTelc(String telc) {
        this.telc = telc;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

}
