import java.util.ArrayList;

public class Borrower {
    private String name = "";
    private ArrayList<Book> borrowedBooks;

    public Borrower(String name){
        this.name = name;
        borrowedBooks = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public boolean setName(String name){
        if(name.isEmpty()) return false;
        this.name = name;
        return true;
    }

    public ArrayList<Book> getBorrowedBooks(){
        return this.borrowedBooks;
    }

    public void setBorrowedBooks(ArrayList<Book> newShelf){
        this.borrowedBooks = newShelf;
    }
    
    public boolean addBook(Book book){
        if(book == null || !(book instanceof Book)) return false;
        this.borrowedBooks.add(book);
        return true;
    }
    
    public boolean removeBook(Book book){
        if(book == null || !(book instanceof Book)) return false;
        this.borrowedBooks.remove(book);
        return true;
    }

    public void displayBorrowedBooks(){
        System.out.println("Alice's Borrowed Books:");
        for(Book book : this.borrowedBooks){
            book.printInfo();
            System.out.println("----------------------------------");
        }
    }
}
