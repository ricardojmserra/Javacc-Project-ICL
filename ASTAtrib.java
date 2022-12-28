public class ASTAtrib implements ASTNode{
    private ASTNode id,exp;
    @Override
    public IValue eval(Enviroment e) throws Exception{
        IValue result = id.eval(e);
        if(result instanceof VCell RESULT){
            IValue value = exp.eval(e);
            RESULT.setValue(value);
            return value;
        }
        throw new ParseException("Invalid use of := operator");
    }
     public ASTAtrib(ASTNode id, ASTNode exp){
        this.id = id;
        this.exp = exp;
     }

    @Override
    public void compile(CodeBlock c, Enviroment e) {

    }
}
