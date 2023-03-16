public class human {
    private String fullName;

    public human(String fullName) {
        this.fullName = fullName;
    }
    
    public String getFullName() {
        return fullName;
    }
    public String toString(){
        return String.format("%s", getFullName());
    }
}
