package org.whole.lang.patterns.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.patterns.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator  Whole
 */
public class PatternsForwardStrategyVisitor extends GenericForwardStrategyVisitor<IPatternsVisitor> implements IPatternsVisitor {

    public PatternsForwardStrategyVisitor() {
        this(new PatternsIdentityVisitor());
    }

    public PatternsForwardStrategyVisitor(IPatternsVisitor... initialStrategies) {
        super(initialStrategies);
    }

    public void visit(IEntity entity) {
        ((IPatternsEntity) entity).accept(this);
    }

    public void visit(PatternLanguage entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Patterns entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Library entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Pattern entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Repetition entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Choice entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Enumeration entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(EnumValues entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(EnumValue entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Data entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DataType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PatternApplication entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Arguments entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Binding entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(VariablePoint entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FunctionApplicationPoint entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Slot entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ResultPoint entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(JoinPoint entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(InsertionPoint entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ScopePoint entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TemplatePoint entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DerivationPoint entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SelectionPoint entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ConditionPoint entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IterationPoint entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SequencePoint entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(InlinePoint entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Declarations entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FunctionDeclaration entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PointcutDeclaration entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(JoinPointDeclaration entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(VariableDeclaration entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Types entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ResultTypes entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Name entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PatternJoinPointStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(JoinPointStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PointcutStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SlotStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(OuterDefinitionStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Cut entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Insert entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SlotsDefined entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PatternTypeTest entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Placement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(URI entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Namespace entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Version entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(BooleanValue entity) {
        wGetStrategy().visit(entity);
    }
}
