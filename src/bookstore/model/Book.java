package bookstore.model;

public class Book {
	
	private int book_id;
	private String ISBN;
	private String title;
	private int author_id;
	private float price;
	private int category_id;
	
	public Book(){
		
	}
	
	public int getBookId()
	{
		return this.book_id;
	}
	public void setBookId(int bookId){
		this.book_id = bookId;
	}
	
	public String getISBN(){
		return this.ISBN;
	}
	public void setISBN(String isbn){
		this.ISBN = isbn;
	}
	
	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title){
		this.title = title;
	}
	
	public int getAuthorId(){
		return this.author_id;
	}
	public void setAuthorId(int authorId){
		this.author_id = authorId;
	}
	
	public float getPrice(){
		return this.price;
	}
	public void setPrice(float price){
		this.price = price;
	}
	
	public int getCategoryId(){
		return this.category_id;
	}
	public void setCategoryId(int categoryId){
		this.category_id = categoryId;
	}
}





