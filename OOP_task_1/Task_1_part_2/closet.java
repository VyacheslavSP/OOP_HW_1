import java.util.ArrayList;

enum StatusDoor {
    open, closet
}

public class closet {
    private byte capacity;
    private StatusDoor statusDoor;
    private ArrayList<String> item;
    public closet(byte capacity) {
        this.capacity=capacity;
        this.statusDoor=StatusDoor.closet;
        ArrayList<String> item =new ArrayList<>(capacity);
        this.item=item;
    }
    public byte getCapacity() {
        return capacity;
    }
    public StatusDoor getStatusDoor() {
        return statusDoor;
    }
    public ArrayList<String> getItems() {
        return item;
    }
    public void setStatusDoor(StatusDoor statusDoor ) {
        this.statusDoor=statusDoor;
    }
    public void setElement (ArrayList<String> item) {
        this.item=item;
    }
    public String toStringDoor(){
        return String.format("%s", getStatusDoor());
    }
    public StringBuilder toStringAllItems(){
      StringBuilder tmp_str= new StringBuilder();
      tmp_str.append("[");
        for (String string : item) {
           tmp_str.append(string+",");
       }
       if(tmp_str.length()!=1){
       tmp_str.replace( tmp_str.length()-1, tmp_str.length(), "]");
       }else{
        tmp_str.replace(0, 6, "пусто");
       }
        return  tmp_str;
   }
}
