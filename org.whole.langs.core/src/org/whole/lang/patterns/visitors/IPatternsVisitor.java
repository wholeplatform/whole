package org.whole.lang.patterns.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.patterns.model.*;

/**
 *  @generator  Whole
 */
public interface IPatternsVisitor extends IVisitor {


    public void visit(PatternLanguage entity);

    public void visit(Patterns entity);

    public void visit(Library entity);

    public void visit(Pattern entity);

    public void visit(Repetition entity);

    public void visit(Choice entity);

    public void visit(Enumeration entity);

    public void visit(EnumValues entity);

    public void visit(EnumValue entity);

    public void visit(Data entity);

    public void visit(DataType entity);

    public void visit(PatternApplication entity);

    public void visit(Arguments entity);

    public void visit(Binding entity);

    public void visit(VariablePoint entity);

    public void visit(FunctionApplicationPoint entity);

    public void visit(Slot entity);

    public void visit(ResultPoint entity);

    public void visit(JoinPoint entity);

    public void visit(InsertionPoint entity);

    public void visit(ScopePoint entity);

    public void visit(TemplatePoint entity);

    public void visit(DerivationPoint entity);

    public void visit(SelectionPoint entity);

    public void visit(ConditionPoint entity);

    public void visit(IterationPoint entity);

    public void visit(SequencePoint entity);

    public void visit(InlinePoint entity);

    public void visit(Declarations entity);

    public void visit(FunctionDeclaration entity);

    public void visit(PointcutDeclaration entity);

    public void visit(JoinPointDeclaration entity);

    public void visit(VariableDeclaration entity);

    public void visit(Types entity);

    public void visit(ResultTypes entity);

    public void visit(Name entity);

    public void visit(PatternJoinPointStep entity);

    public void visit(JoinPointStep entity);

    public void visit(PointcutStep entity);

    public void visit(SlotStep entity);

    public void visit(OuterDefinitionStep entity);

    public void visit(Cut entity);

    public void visit(Insert entity);

    public void visit(SlotsDefined entity);

    public void visit(PatternTypeTest entity);

    public void visit(Placement entity);

    public void visit(URI entity);

    public void visit(Namespace entity);

    public void visit(Version entity);

    public void visit(BooleanValue entity);
}
