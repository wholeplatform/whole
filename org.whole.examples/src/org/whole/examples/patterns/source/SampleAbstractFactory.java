package org.whole.examples.patterns.source;

public interface SampleAbstractFactory {
    public Statement createWhile(Expression exp, Statement stm);
    public Statement createIf(Expression exp, Statement thenStm, Statement elseStm);
    public Statement createEmpty();
    public Statement createAssignment(Expression var, Expression exp);
    public Statement createBlock(Statement[] stm);
    public Literal createBooleanLiteral(boolean val);
    public Literal createIntLiteral(int val);
    public Expression createVariable(String name);
    public Expression createAddition(Expression exp1, Expression exp2);
    public Expression createSubtraction(Expression exp1, Expression exp2);
    public Expression createMultiplication(Expression exp1, Expression exp2);
    public Expression createDivision(Expression exp1, Expression exp2);
    public Expression createAnd(Expression exp1, Expression exp2);
    public Expression createOr(Expression exp1, Expression exp2);
    public Expression createNot(Expression exp);
    public Expression createEquals(Expression exp1, Expression exp2);
    public Expression createLessThan(Expression exp1, Expression exp2);
    public Expression createGreaterThan(Expression exp1, Expression exp2);
}
