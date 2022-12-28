public class ASTId implements ASTNode{
    private String id;
    @Override
    public IValue eval(Enviroment e) throws Exception {
        IValue value = e.find(id);
        if(value != null)
            return value;
        throw new ParseException("ID '" + id + "' not defined.");
    }
    public ASTId(String id){
        this.id = id;
    }

    @Override
    public void compile(CodeBlock c, Enviroment e) {

    }
}
