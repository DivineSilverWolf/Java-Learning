package users;

import media.parent.Media;

import java.util.HashSet;
import java.util.Set;

public class User {
    private Set<Media> mediaSet = new HashSet<>();
    public boolean addBook(Media media){
        return mediaSet.add(media);
    }
    public boolean removeBook(Media media){
        return mediaSet.remove(media);
    }
    public Set<Media> getMediaSet() {
        return new HashSet<>(mediaSet);
    }

    public void setMediaSet(Set<Media> mediaSet) {
        this.mediaSet = mediaSet;
    }
}
