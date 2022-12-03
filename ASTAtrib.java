public class ASTAtrib implements ASTNode{
    private Pair<ASTNode,ASTNode> info;
    @Override
    public IValue eval(Enviroment e) throws ParseException{
        IValue result = info.getKey().eval(e);
        if(result instanceof VCell RESULT){
            IValue value = info.getValue().eval(e);
            value = value instanceof VCell ? ((VCell) value).value : value;
            if(!(value instanceof VNull)){
                RESULT.value = value;
                return value;
            }
        }
        throw new ParseException("Invalid use of := operator");
    }
     public ASTAtrib(ASTNode id, ASTNode exp){
        this.info = new Pair<ASTNode,ASTNode>(id, exp);
     }

    @Override
    public void compile(CodeBlock c, Enviroment e) {

    }
}
