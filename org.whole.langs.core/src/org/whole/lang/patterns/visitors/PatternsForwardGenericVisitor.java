package org.whole.lang.patterns.visitors;

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.patterns.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator  Whole
 */
public class PatternsForwardGenericVisitor extends AbstractUnaryVisitor<IVisitor> implements IPatternsVisitor {

    public PatternsForwardGenericVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(IEntity entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PatternLanguage entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Patterns entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Library entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Pattern entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Repetition entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Choice entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Enumeration entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(EnumValues entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(EnumValue entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Data entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(DataType entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PatternApplication entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Arguments entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Binding entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(VariablePoint entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(FunctionApplicationPoint entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Slot entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ResultPoint entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(JoinPoint entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(InsertionPoint entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ScopePoint entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(TemplatePoint entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(DerivationPoint entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SelectionPoint entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ConditionPoint entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(IterationPoint entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SequencePoint entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(InlinePoint entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Declarations entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(FunctionDeclaration entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PointcutDeclaration entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(JoinPointDeclaration entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(VariableDeclaration entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Types entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ResultTypes entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Name entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PatternJoinPointStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(JoinPointStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PointcutStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SlotStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(OuterDefinitionStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Cut entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Insert entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SlotsDefined entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PatternTypeTest entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Placement entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(URI entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Namespace entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Version entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(BooleanValue entity) {
        wGetVisitor1().visit(entity);
    }
}
