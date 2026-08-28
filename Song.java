import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Song {

    private final String title;
    private final String artist;
    private final List<String> tags;

    public Song(String title, String artist, List<String> tags) {
      
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title must not be null or empty");
        }
        if (artist == null || artist.trim().isEmpty()) {
            throw new IllegalArgumentException("Artist must not be null or empty");
        }
        if (tags == null) {
            throw new IllegalArgumentException("Tags list must not be null");
        }
        for (String tag : tags) {
            if (tag == null || tag.trim().isEmpty()) {
                throw new IllegalArgumentException("Tag element must not be null or empty");
            }
        }

        this.title = title;
        this.artist = artist;
        
      
        this.tags = new ArrayList<>(tags); 
    }

    // ---------- observers ----------

    public String title() {
        return title;
    }

    public String artist() {
        return artist;
    }

    public List<String> tags() {
      
        return new ArrayList<>(this.tags);
    }

    // ---------- producer ----------

   
    public Song withTag(String tag) {
       
        if (tag == null || tag.trim().isEmpty()) {
            throw new IllegalArgumentException("New tag must not be null or empty");
        }
        
      
        List<String> newTags = new ArrayList<>(this.tags);
        newTags.add(tag);
        
        return new Song(this.title, this.artist, newTags);
    }

    // ---------- equality ---------- // 
    
    @Override
    public boolean equals(Object o) {
       
        if (this == o) return true;
       
        if (!(o instanceof Song)) return false;
     
        Song song = (Song) o;
      
        return Objects.equals(title, song.title) &&
               Objects.equals(artist, song.artist) &&
               Objects.equals(tags, song.tags);
    }

   
    @Override
    public int hashCode() {
        return Objects.hash(title, artist, tags);
    }

    @Override
    public String toString() {
        return title + " — " + artist + " " + tags;
    }
}
