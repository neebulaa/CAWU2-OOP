public class Author {
    private String name;
    private String biography;
    public Author(String name, String biography){
        this.name = name;
        this.biography = biography;
    }

    public String getName(){
        return this.name;
    }

    public String getBiography(){
        return this.biography;
    }

    public boolean setName(String name){
        if(name.isEmpty()) return false;
        this.name = name;
        return true;
    }
    
    public boolean getBiography(String biography){
        if(biography.isEmpty()) return false;
        this.biography = biography;
        return true;
    }
}
