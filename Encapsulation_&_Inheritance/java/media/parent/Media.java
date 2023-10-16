package media.parent;

public abstract class Media {
    protected String author;
    protected String name;
    protected String genre;

    public Media(String name, String author, String genre) {
        this.author = author;
        this.genre = genre;
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
