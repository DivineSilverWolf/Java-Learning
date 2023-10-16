package media;

import media.parent.Media;

public class Book extends Media {
    public Integer getPageCount() {
        return pageCount;
    }
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }
    private Integer pageCount;
    public Book(String name, String author, String genre, Integer pageCount) {
        super(author, genre, name);
        this.pageCount = pageCount;
    }
}
