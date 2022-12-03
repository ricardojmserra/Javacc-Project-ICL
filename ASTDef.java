import java.util.List;
public class ASTDef implements ASTNode{
    private ASTNode Body;
    private List<Pair<String,ASTNode>> l;
    @Override
    public IValue eval(Enviroment e) throws ParseException{
        e = e.beginScope();
        for(Pair<String, ASTNode> i : l){
            IValue value = i.getValue().eval(e);
            value = value instanceof VCell ? ((VCell) value).value : value;
            if(value instanceof VNull)
                throw new ParseException("Can't define value in function");
            e.define(i.getKey(), new VCell(value));
        }


        IValue result = Body.eval(e);
        e = e.endScope();
        return new VNull();
    }

    public ASTDef(List l, ASTNode t){
        this.l = l;
        this.Body = t;
    }

    @Override
    public void compile(CodeBlock c, Enviroment e) {
        e = e.beginScope();
        String frame = "frame_" + e.depth();
        for(Pair<String, ASTNode> i : l){
            c.emit("aload 3");
            i.getValue().compile(c, e);

            //e.define(i.getKey(), i.getValue().eval(e));
        }
        Body.compile(c, e);
        e = e.endScope();
    }
}
