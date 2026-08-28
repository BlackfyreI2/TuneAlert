import java.util.ArrayList;
import java.util.List;

public final class NotificationService {

    private final List<Notifier> channels;
    private final Priority threshold;

  
    public NotificationService(List<Notifier> channels, Priority threshold) {
       
            throw new IllegalArgumentException("Channels list must not be null");
        }
        for (Notifier n : channels) {
            if (n == null) {
                throw new IllegalArgumentException("Channel element must not be null");
            }
        }
        if (threshold == null) {
            throw new IllegalArgumentException("Threshold must not be null");
        }

       
        this.channels = new ArrayList<>(channels);
        this.threshold = threshold;
    }

  
    public int channelCount() {
        return channels.size();
    }

   
    public boolean broadcast(String message, Priority priority) {
   
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("Message must not be null or empty");
        }
        if (priority == null) {
            throw new IllegalArgumentException("Priority must not be null");
        }

        
        if (!priority.isAtLeast(this.threshold)) {
            return false;
        }

        for (Notifier n : channels) {
            n.send(message);    // polymorphism — ไม่สน concrete type เลย (OCP)
        }
        return true;
    }

  
    public boolean announceNewSong(Song song, Priority priority) {
        if (song == null) {
            throw new IllegalArgumentException("song must not be null");
        }
        return broadcast("New release: " + song.title() + " by " + song.artist(),
                priority);
    }
}
