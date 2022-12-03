public interface ASTNode {

    IValue eval(Enviroment e) throws ParseException;
    void compile(CodeBlock c, Enviroment e);
        //estou a fazer typechecking no eval mas devia de ser feito aqui e então o eval não iria precisas de qualquer tipo de typechecking
    //IType typecheck(Enviroment e);
	
}

