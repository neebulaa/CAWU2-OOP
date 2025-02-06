import java.util.ArrayList;
public class Library {
    private ArrayList<Book> shelf;

    public Library(){
        this.shelf = new ArrayList<>();
    }

    public ArrayList<Book> getAllBooks(){
        return this.shelf;
    }

    public void setShelf(ArrayList<Book> newShelf){
        this.shelf = newShelf;
    }

    public boolean addBook(Book book){
        if(book == null || !(book instanceof Book)) return false;
        this.shelf.add(book);
        System.out.println("Book added to library: " + book.getTitle());
        return true;
    }

    public boolean borrowBook(Borrower borrower, Book book){
        if(book == null || !(book instanceof Book) || !this.shelf.contains(book)) return false;
        System.out.println("Alice borrowed: " + book.getTitle());
        this.shelf.remove(book);
        borrower.addBook(book);
        return true;
    }

    public boolean returnBook(Borrower borrower, Book book){
        if(book == null || !(book instanceof Book) || this.shelf.contains(book)) return false;
        System.out.println("Alice returned: " + book.getTitle());
        this.shelf.add(book);
        borrower.removeBook(book);
        return true;
    }

    public void displayLibraryBooks(){
        System.out.println("Books in Library:");
        for(Book book : this.shelf){
            book.printInfo();
            System.out.println("----------------------------------");
        }
    }
}
