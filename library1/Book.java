
public class Book {
    private String title;
    private String ISBN;
    private Author author;
    public Book(String title, String ISBN, Author author){
        this.title = title;
        this.ISBN = ISBN;
        this.author = author;
    }

    public String getTitle(){
        return this.title;
    }

    public boolean setTitle(String title){
        if(title.isEmpty()) return false;
        this.title = title;
        return true;
    }

    public String getISBN(){
        return this.ISBN;
    }

    public boolean setISBN(String ISBN){
        if(ISBN.isEmpty() || ISBN.length() != 9) return false;
        this.ISBN = ISBN;
        return true;
    }

    public Author getAuthor(){
        return this.author;
    }

    public boolean setAuthor(Author author){
        if(author == null || !(author instanceof Author)) return false;
        this.author = author;
        return true;
    }

    public void printInfo(){
        System.out.println("Title: " + this.getTitle());
        System.out.println("ISBN: " + this.getISBN());
        System.out.println("Author: " + this.getAuthor().getName());
        System.out.println("Biography: " + this.getAuthor().getBiography());
    }
}
