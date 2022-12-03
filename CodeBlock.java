import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

public class CodeBlock {
   List<String> code = new LinkedList<>();
    void emit(String opcode){
        code.add(opcode);
    }
    void dump(PrintStream f){
        for (String i : code)
            f.println(i);
    }
}
