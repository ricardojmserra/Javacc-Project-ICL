public class Pair<T,B>{
    private T key;
    private B value;
    private boolean mut;
    public Pair(T key, B value){
        this.key = key;
        this.value = value;
    }
    public Pair(T key, B value, boolean mut){
        this(key, value);
        this.mut = mut;
    }
    public T getKey(){
        return this.key;
    }
    public B getValue(){
        return this.value;
    }
    public boolean isMut() { return this.mut; }
}
