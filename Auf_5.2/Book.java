public class Book implements ISortable{
	public String title;
	public String author;
	public String publisher;
	public int price;
	public String ISBN;
	
	public Book(String title, String author, String publisher, int price, String ISBN){
		this.title= title;
		this.author= author;
		this.publisher= publisher;
		this.price= price;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getAuthor(){
		return author;
	}
	
	public String getPublisher(){
		return publisher;
	}
	
	public int getPrice(){
		return price;
	}
	
	public String getISBN(){
		return ISBN;
	}
	
	
	public String getSortString(SortMode mode){
		String s= "";
		switch(mode){
			case NAME : s= "${" + getTitle() + "}-${" + getAuthor() + "}-${" + getPublisher() + "}"; break;
			case PRICE: s= "${" + getPrice() + "}"; break;//hier noch die zusatzbedingung
			default   : s= "${" + getISBN() + "}"; break;
		}
	}
	
}