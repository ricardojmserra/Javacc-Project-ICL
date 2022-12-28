public class ASTString implements ASTNode {
    String b;
    public ASTString(String b) {
        this.b = b;
    }

    @Override
    public IValue eval(Enviroment e) throws Exception{
        return new VString(b.substring(1, b.length()-1));   //tirar as aspas da string
    }

    @Override
    public void compile(CodeBlock c, Enviroment e) {

    }
}
