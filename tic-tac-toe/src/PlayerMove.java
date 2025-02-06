public class PlayerMove {
    private char type;
    private String name;
    private int id;

    public PlayerMove(char type, String name, int id){
        this.type = type;
        this.name = name;
        this.id = id;
    }

    public char getType(){
        return this.type;
    }

    public String getName(){
        return this.name;
    }

    public int getId(){
        return this.id;
    }

    public void setType(char type){
        if(type != 'X' || type != 'O') return;
        this.type = type;
    }

    public void setName(String name){
        if(name.isEmpty()) return;
        this.name = name;
    }
}
