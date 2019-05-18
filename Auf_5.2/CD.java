public class CD implements ISortbale{
	public String title;
	public String artist;
	public String publisher;
	public int price;
	public String ASIN;
	
	public CD(String title, String artist, String publisher, int price, String ASIN){
		this.title= title;
		this.artist= artist;
		this.publisher= publisher;
		this.price= price;
		this.ASIN= ASIN;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getArtist(){
		return artist;
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
			case NAME : s= "${" + getTitle() + "}-${" + getArtist() + "}-${" + getPublisher() + "}"; break;
			case PRICE: s= "${" + getPrice() + "}"; break;//hier noch die zusatzbedingung
			default   : s= "${" + getASIN() + "}"; break;
		}
	}
	
}