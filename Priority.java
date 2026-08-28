public enum Priority {

   
    LOW(1), 
    NORMAL(2), 
    URGENT(3);

   
    private final int level;

    Priority(int level) {
        this.level = level;
    }

  
    public int level() {
    
        return this.level;
    }


    public boolean isAtLeast(Priority other) {
     
        return this.level >= other.level();
    }
}
