package vo;


public class Supplier {
    private int sid;//�����̱��
    private String name;//����������
    private String person;//����
    private String phone;//�绰
    private String tel;//�ֻ�
    private String telc;//����
    private String addr;//��ַ
    private String remark;//��ע

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
