public class Pair<T,B>{
    private T key;
    private B value;
    public Pair(T key, B value){
        this.key = key;
        this.value = value;
    }
    public T getKey(){
        return this.key;
    }
    public B getValue(){
        return this.value;
    }
}
