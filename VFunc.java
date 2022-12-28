import java.util.LinkedList;
import java.util.List;

public class VFunc {
    private String[] argName;
    private Enviroment functionScope;
    private ASTNode funcBody;
    public VFunc(List<String> argName, ASTNode funcBody){
        this.funcBody = funcBody;
        this.argName = (String[])argName.toArray();
    }
}
