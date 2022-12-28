public class ASTWhile implements ASTNode {
    private ASTNode exp, body;
    public ASTWhile(ASTNode t, ASTNode z) {
        this.exp = t;
        this.body = z;
    }

    @Override
    public IValue eval(Enviroment e) throws Exception {
        IValue condition = exp.eval(e);
        if(condition instanceof VBool CONDITION) outLabel: {
            while(CONDITION.value){
                Enviroment actual = e.beginScope();
                body.eval(actual);
                condition = exp.eval(e);
                if(!(condition instanceof VBool)) break outLabel;
                CONDITION = (VBool) condition;
            }
            return new VNull();
        }
        throw new Exception("Condition does not evaluate to boolean");
    }

    @Override
    public void compile(CodeBlock c, Enviroment e) {

    }
}
