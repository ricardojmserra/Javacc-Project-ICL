public class ASTId implements ASTNode{
    private String id;
    @Override
    public IValue eval(Enviroment e) throws ParseException {
        IValue value = e.find(id);  //Teoricamente tem sempre que ser VCell mas posso eventualmente mudar
        if(value != null && !(value instanceof VNull))
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
