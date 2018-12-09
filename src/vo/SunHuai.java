package vo;

public class SunHuai {
	private int id;
	private String barcode;//条形码
    private String drugname;//商品名
    private float price;//进货价格
    
    private int amount;//数量
   
    private String type;//类型
    private String spec;//规格
    private String unit;//单位
   
    private String retime;//进货时间
    private String username;//操作员
    private String stype;
   
    
    public SunHuai(){}

    public int getId(){
    	return id;
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



    public String getStype() {
        return stype;
    }



    public float getPrice() {
        return price;
    }

    public String getUnit() {
        return unit;
    }

    public String getRetime() {
        return retime;
    }

  

    public String getDrugname() {
        return drugname;
    }

    public String getBarcode() {
        return barcode;
    }
    
    public int getAmount() {
        return amount;
    }

    public void setId(int id){
    	this.id = id;
    }
    
    public void setStype(String stype){
    	this.stype = stype;
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

  

 
    public void setPrice(float price) {
        this.price = price;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setRetime(String retime) {
        this.retime = retime;
    }



    public void setDrugname(String drugname) {
        this.drugname = drugname;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
}
}
