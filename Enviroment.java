import java.util.HashMap;

public class Enviroment {
    HashMap<String,IValue> Scope;
    Enviroment lastScope;
    int depth;
    public Enviroment(){
        this.Scope = new HashMap<>();
        this.lastScope = null;
        this.depth = 0;
    }
    public Enviroment(Enviroment lastScope){
        this.Scope = new HashMap<>();
        this.lastScope = lastScope;
        this.depth = lastScope.depth+1;
    }

    public int depth(){
        return this.depth;
    }

    public Enviroment beginScope(){
        return new Enviroment(this);
    }

    public Enviroment endScope(){
        this.Scope.clear();
        return this.lastScope;
    }
    public IValue find(String id){
        if(Scope.containsKey(id)){
            return Scope.get(id);
        }
        else if(lastScope == null) {
            System.err.println(id + " Not Defined.");
        }
        return lastScope.find(id);
    }

    public void define(String ID, IValue value){
        this.Scope.put(ID, value);
    }
}
