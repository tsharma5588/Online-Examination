public class Book {
    private int id;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public int getId() { return id; }

    public String getTitle() { return title; }

    public String getAuthor() { return author; }

    public boolean isIssued() { return isIssued; }

    public void setIssued(boolean issued) { isIssued = issued; }

    public void display() {
        System.out.println(id + " - " + title + " by " + author + (isIssued ? " [Issued]" : ""));
    }
}
