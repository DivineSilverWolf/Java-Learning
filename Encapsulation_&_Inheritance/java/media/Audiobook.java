package media;

import media.parent.Media;

public class Audiobook extends Media {
    private Integer duration;
    public Audiobook(String name, String author, String genre, Integer duration) {
        super(name, author, genre);
        this.duration = duration;
    }
    public Integer getDuration() {
        return duration;
    }
    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
