public final class CountingNotifier implements Notifier {

  
    private final Notifier inner;
    private int count;

  
    public CountingNotifier(Notifier inner) {
     
        if (inner == null) {
            throw new IllegalArgumentException("Inner notifier must not be null");
        }
        this.inner = inner;
        this.count = 0; // เริ่มต้นตัวนับที่ 0
    }

    @Override
    public void send(String message) {
      
        this.count++;
        this.inner.send(message);
    }

  
    public int sendCount() {
  
        return this.count;
    }
}
