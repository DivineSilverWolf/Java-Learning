package library;

import media.parent.Media;
import users.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Library {
    private Set<Media> mediaSet = new HashSet<>();
    private Map<Media, User> mediaForUser = new HashMap<>();
    public boolean addBook(Media media){
        return mediaSet.add(media);
    }
    public boolean removeBook(Media media){
        return mediaSet.remove(media);
    }
    public Set<Media> getAllBooks(){
        return new HashSet<>(mediaSet);
    }
    public boolean postBook(User user, Media media){
        if(removeBook(media)) {
            mediaForUser.put(media, user);
            user.addBook(media);
            return true;
        }
        return false;
    }

    public boolean getBook(User user, Media media){
        if(mediaForUser.remove(media, user)) {
            addBook(media);
            user.removeBook(media);
            return true;
        }
        return false;
    }

    public Set<Media> viewListBorrowedBooks(User user){
        return mediaForUser.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(user))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

}
