package vo;

public class Cai {
	
    private int cid;
    private String drugname;//商品名
    private float price;//进货价格
    private int amount;//数量
    private String type;//类型
    private String spec;//规格
    private String unit;//单位
    //private String producer;//生产厂家
    private String caitime;//进货时间
    private String username;//操作员
    private String provider;//供应商
    private int expiredate;//有效期
    private boolean isnot;//权限

    public Cai(){}

    public int getCid(){
    	return cid;
    }
    public String getUsername() {
        return username;
    }

    public String getType() {
        return type;
    }

    public String getSpec() {
        return spec;
    }

    public String getProvider() {
        return provider;
    }

   /* public String getProducer() {
        return producer;
    }*/

    public float getPrice() {
        return price;
    }

    public String getUnit() {
        return unit;
    }

    public String getCaitime() {
        return caitime;
    }

    public int getExpiredate() {
        return expiredate;
    }

    public String getDrugname() {
        return drugname;
    }

    public boolean isnot() {
        return isnot;
    }
    
    public void setCid(int cid){
    	this.cid = cid ;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    

    public void setProvider(String provider) {
        this.provider = provider;
    }

    /*public void setProducer(String producer) {
        this.producer = producer;
    }*/

    public void setPrice(float price) {
        this.price = price;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setCaitime(String caitime) {
        this.caitime = caitime;
    }

    public void setExpiredate(int expiredate) {
        this.expiredate = expiredate;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname;
    }

  

    public int getAmount() {
        return amount;
    }
    
    public void setisnot(boolean isnot) {
        this.isnot = isnot;
    }

}
