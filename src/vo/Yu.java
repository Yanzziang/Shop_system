package vo;

public class Yu {
	private int yid;
    private String drugname;//��Ʒ��
    private int amount;//����
    private int samount;
    private String barcode;
    private String username;//����Ա
    private String provider;//��Ӧ��
    public Yu(){}

    public int getYid(){
    	return yid;
    }
    public String getBarcode(){
    	return barcode;
    }
    public String getUsername() {
        return username;
    }
    public int getAmount(){
    	return amount;
    }
    public int getSamount(){
    	return samount;
    }
    public String getDrugname(){
    	return drugname;
    }
    public String getProvider(){
    	return provider;
    }
    
    public void setYid(int yid){
    	this.yid = yid;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setAmount(int amount){
    	this.amount = amount;
    }
    public void setSamount(int samount){
    	this.samount = samount;
    }
    public void setDrugname(String drugname){
    	this.drugname = drugname;
    }
    public void setProvider(String provider){
    	this.provider = provider;
    }
    
    public void setBarcode(String barcode){
    	this.barcode = barcode;
    }
}
