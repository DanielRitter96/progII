public class BluRay implements ISortable{
	public String title;
	public int price;
	public String publisher;
	public String ASIN;
	
	public BluRay(String title, int price, String publisher, String ASIN){
		this.title= title;
		this.price= price;
		this.publisher= publisher;
		this.ASIN= ASIN;
	}
	public String getTitle(){
		return title;
	}
	
	public String getPublisher(){
		return publisher;
	}
	
	public int getPrice(){
		return price;
	}
	
	public String getASIN(){
		return ASIN;
	}
	
	public String getSortString(SortMode mode){
		String s= "";
		switch(mode){
			case NAME : s= "${" + getTitle() + "}-${" + getPublisher() + "}"; break;
			case PRICE: s= "${" + getPrice() + "}"; break;//hier noch die zusatzbedingung
			default   : s= "${" + getASIN() + "}"; break;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} 