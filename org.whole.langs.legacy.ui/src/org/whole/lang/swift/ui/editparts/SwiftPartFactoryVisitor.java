/**
 *  Copyright 2004-2019 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.swift.ui.editparts;

import org.eclipse.gef.EditPart;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.*;
import org.whole.lang.swift.visitors.SwiftIdentityDefaultVisitor;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.notations.table.editparts.TablePartFactory;

/**
 *  @generator Whole
 */
public class SwiftPartFactoryVisitor extends SwiftIdentityDefaultVisitor implements IEditPartFactory {
    protected EditPart part, context;

    public EditPart createEditPart(EditPart context, Object modelEntity) {
        this.context = context;
        ((ISwiftEntity) modelEntity).accept(this);
        return part;
    }

    public void visit(ISwiftEntity entity) {
        part = TablePartFactory.instance().createEditPart(context, entity);
    }

    @Override
    public void visit(CodeBlockItemList entity) {
        part = new CodeBlockItemListPart();
    }

    @Override
    public void visit(InOutExpr entity) {
        part = new InOutExprPart();
    }

    @Override
    public void visit(PoundColumnExpr entity) {
        part = new PoundColumnExprPart();
    }

    @Override
    public void visit(FunctionCallArgumentList entity) {
        part = new FunctionCallArgumentListPart();
    }

    @Override
    public void visit(StringLiteralSegments entity) {
        part = new StringLiteralSegmentsPart();
    }

    @Override
    public void visit(TryExpr entity) {
        part = new TryExprPart();
    }

    @Override
    public void visit(DeclNameArgumentList entity) {
        part = new DeclNameArgumentListPart();
    }

    @Override
    public void visit(IdentifierExpr entity) {
        part = new IdentifierExprPart();
    }

    @Override
    public void visit(SuperRefExpr entity) {
        part = new SuperRefExprPart();
    }

    @Override
    public void visit(NilLiteralExpr entity) {
        part = new NilLiteralExprPart();
    }

    @Override
    public void visit(DiscardAssignmentExpr entity) {
        part = new DiscardAssignmentExprPart();
    }

    @Override
    public void visit(AssignmentExpr entity) {
        part = new AssignmentExprPart();
    }

    @Override
    public void visit(SequenceExpr entity) {
        part = new SequenceExprPart();
    }

    @Override
    public void visit(PoundLineExpr entity) {
        part = new PoundLineExprPart();
    }

    @Override
    public void visit(PoundFileExpr entity) {
        part = new PoundFileExprPart();
    }

    @Override
    public void visit(PoundFunctionExpr entity) {
        part = new PoundFunctionExprPart();
    }

    @Override
    public void visit(PoundDsohandleExpr entity) {
        part = new PoundDsohandleExprPart();
    }

    @Override
    public void visit(SymbolicReferenceExpr entity) {
        part = new SymbolicReferenceExprPart();
    }

    @Override
    public void visit(PrefixOperatorExpr entity) {
        part = new PrefixOperatorExprPart();
    }

    @Override
    public void visit(BinaryOperatorExpr entity) {
        part = new BinaryOperatorExprPart();
    }

    @Override
    public void visit(ArrowExpr entity) {
        part = new ArrowExprPart();
    }

    @Override
    public void visit(TupleExpr entity) {
        part = new TupleExprPart();
    }

    @Override
    public void visit(ArrayExpr entity) {
        part = new ArrayExprPart();
    }

    @Override
    public void visit(DictionaryExpr entity) {
        part = new DictionaryExprPart();
    }

    @Override
    public void visit(FunctionCallArgument entity) {
        part = new FunctionCallArgumentPart();
    }

    @Override
    public void visit(TupleElement entity) {
        part = new TupleElementPart();
    }

    @Override
    public void visit(DictionaryElement entity) {
        part = new DictionaryElementPart();
    }

    @Override
    public void visit(TernaryExpr entity) {
        part = new TernaryExprPart();
    }

    @Override
    public void visit(MemberAccessExpr entity) {
        part = new MemberAccessExprPart();
    }

    @Override
    public void visit(IsExpr entity) {
        part = new IsExprPart();
    }

    @Override
    public void visit(AsExpr entity) {
        part = new AsExprPart();
    }

    @Override
    public void visit(TypeExpr entity) {
        part = new TypeExprPart();
    }

    @Override
    public void visit(ClosureCaptureItem entity) {
        part = new ClosureCaptureItemPart();
    }

    @Override
    public void visit(ClosureCaptureItemList entity) {
        part = new ClosureCaptureItemListPart();
    }

    @Override
    public void visit(WildcardMarker entity) {
        part = new WildcardMarkerPart();
    }

    @Override
    public void visit(ClosureParamList entity) {
        part = new ClosureParamListPart();
    }

    @Override
    public void visit(ClosureSignature entity) {
        part = new ClosureSignaturePart();
    }

    @Override
    public void visit(ClosureExpr entity) {
        part = new ClosureExprPart();
    }

    @Override
    public void visit(UnresolvedPatternExpr entity) {
        part = new UnresolvedPatternExprPart();
    }

    @Override
    public void visit(FunctionCallExpr entity) {
        part = new FunctionCallExprPart();
    }

    @Override
    public void visit(SubscriptExpr entity) {
        part = new SubscriptExprPart();
    }

    @Override
    public void visit(OptionalChainingExpr entity) {
        part = new OptionalChainingExprPart();
    }

    @Override
    public void visit(ForcedValueExpr entity) {
        part = new ForcedValueExprPart();
    }

    @Override
    public void visit(PostfixUnaryExpr entity) {
        part = new PostfixUnaryExprPart();
    }

    @Override
    public void visit(SpecializeExpr entity) {
        part = new SpecializeExprPart();
    }

    @Override
    public void visit(ExpressionSegment entity) {
        part = new ExpressionSegmentPart();
    }

    @Override
    public void visit(StringLiteralExpr entity) {
        part = new StringLiteralExprPart();
    }

    @Override
    public void visit(KeyPathExpr entity) {
        part = new KeyPathExprPart();
    }

    @Override
    public void visit(KeyPathBaseExpr entity) {
        part = new KeyPathBaseExprPart();
    }

    @Override
    public void visit(ObjcKeyPathExpr entity) {
        part = new ObjcKeyPathExprPart();
    }

    @Override
    public void visit(ObjcSelectorExpr entity) {
        part = new ObjcSelectorExprPart();
    }

    @Override
    public void visit(EditorPlaceholderExpr entity) {
        part = new EditorPlaceholderExprPart();
    }

    @Override
    public void visit(ObjectLiteralExpr entity) {
        part = new ObjectLiteralExprPart();
    }

    @Override
    public void visit(TypealiasDecl entity) {
        part = new TypealiasDeclPart();
    }

    @Override
    public void visit(AssociatedtypeDecl entity) {
        part = new AssociatedtypeDeclPart();
    }

    @Override
    public void visit(FunctionParameterList entity) {
        part = new FunctionParameterListPart();
    }

    @Override
    public void visit(FunctionSignature entity) {
        part = new FunctionSignaturePart();
    }

    @Override
    public void visit(IfConfigClause entity) {
        part = new IfConfigClausePart();
    }

    @Override
    public void visit(IfConfigDecl entity) {
        part = new IfConfigDeclPart();
    }

    @Override
    public void visit(PoundErrorDecl entity) {
        part = new PoundErrorDeclPart();
    }

    @Override
    public void visit(PoundWarningDecl entity) {
        part = new PoundWarningDeclPart();
    }

    @Override
    public void visit(PoundSourceLocation entity) {
        part = new PoundSourceLocationPart();
    }

    @Override
    public void visit(PoundSourceLocationArgs entity) {
        part = new PoundSourceLocationArgsPart();
    }

    @Override
    public void visit(DeclModifier entity) {
        part = new DeclModifierPart();
    }

    @Override
    public void visit(InheritedTypeList entity) {
        part = new InheritedTypeListPart();
    }

    @Override
    public void visit(ClassDecl entity) {
        part = new ClassDeclPart();
    }

    @Override
    public void visit(StructDecl entity) {
        part = new StructDeclPart();
    }

    @Override
    public void visit(ProtocolDecl entity) {
        part = new ProtocolDeclPart();
    }

    @Override
    public void visit(ExtensionDecl entity) {
        part = new ExtensionDeclPart();
    }

    @Override
    public void visit(MemberDeclList entity) {
        part = new MemberDeclListPart();
    }

    @Override
    public void visit(SourceFile entity) {
        part = new SourceFilePart();
    }

    @Override
    public void visit(FunctionParameter entity) {
        part = new FunctionParameterPart();
    }

    @Override
    public void visit(ModifierList entity) {
        part = new ModifierListPart();
    }

    @Override
    public void visit(FunctionDecl entity) {
        part = new FunctionDeclPart();
    }

    @Override
    public void visit(InitializerDecl entity) {
        part = new InitializerDeclPart();
    }

    @Override
    public void visit(DeinitializerDecl entity) {
        part = new DeinitializerDeclPart();
    }

    @Override
    public void visit(SubscriptDecl entity) {
        part = new SubscriptDeclPart();
    }

    @Override
    public void visit(AccessLevelModifier entity) {
        part = new AccessLevelModifierPart();
    }

    @Override
    public void visit(AccessPath entity) {
        part = new AccessPathPart();
    }

    @Override
    public void visit(ImportDecl entity) {
        part = new ImportDeclPart();
    }

    @Override
    public void visit(AccessorDecl entity) {
        part = new AccessorDeclPart();
    }

    @Override
    public void visit(AccessorBlock entity) {
        part = new AccessorBlockPart();
    }

    @Override
    public void visit(PatternBinding entity) {
        part = new PatternBindingPart();
    }

    @Override
    public void visit(PatternBindingList entity) {
        part = new PatternBindingListPart();
    }

    @Override
    public void visit(VariableDecl entity) {
        part = new VariableDeclPart();
    }

    @Override
    public void visit(EnumCaseElement entity) {
        part = new EnumCaseElementPart();
    }

    @Override
    public void visit(EnumCaseElementList entity) {
        part = new EnumCaseElementListPart();
    }

    @Override
    public void visit(EnumCaseDecl entity) {
        part = new EnumCaseDeclPart();
    }

    @Override
    public void visit(EnumDecl entity) {
        part = new EnumDeclPart();
    }

    @Override
    public void visit(OperatorDecl entity) {
        part = new OperatorDeclPart();
    }

    @Override
    public void visit(IdentifierList entity) {
        part = new IdentifierListPart();
    }

    @Override
    public void visit(PrecedenceGroupDecl entity) {
        part = new PrecedenceGroupDeclPart();
    }

    @Override
    public void visit(PrecedenceGroupAttributeList entity) {
        part = new PrecedenceGroupAttributeListPart();
    }

    @Override
    public void visit(PrecedenceGroupRelation entity) {
        part = new PrecedenceGroupRelationPart();
    }

    @Override
    public void visit(PrecedenceGroupNameList entity) {
        part = new PrecedenceGroupNameListPart();
    }

    @Override
    public void visit(PrecedenceGroupAssignment entity) {
        part = new PrecedenceGroupAssignmentPart();
    }

    @Override
    public void visit(PrecedenceGroupAssociativity entity) {
        part = new PrecedenceGroupAssociativityPart();
    }

    @Override
    public void visit(CustomAttribute entity) {
        part = new CustomAttributePart();
    }

    @Override
    public void visit(Attribute entity) {
        part = new AttributePart();
    }

    @Override
    public void visit(AttributeList entity) {
        part = new AttributeListPart();
    }

    @Override
    public void visit(SpecializeAttributeSpecList entity) {
        part = new SpecializeAttributeSpecListPart();
    }

    @Override
    public void visit(LabeledSpecializeEntry entity) {
        part = new LabeledSpecializeEntryPart();
    }

    @Override
    public void visit(NamedAttributeStringArgument entity) {
        part = new NamedAttributeStringArgumentPart();
    }

    @Override
    public void visit(DeclName entity) {
        part = new DeclNamePart();
    }

    @Override
    public void visit(ImplementsAttributeArguments entity) {
        part = new ImplementsAttributeArgumentsPart();
    }

    @Override
    public void visit(ObjCSelector entity) {
        part = new ObjCSelectorPart();
    }

    @Override
    public void visit(ContinueStmt entity) {
        part = new ContinueStmtPart();
    }

    @Override
    public void visit(WhileStmt entity) {
        part = new WhileStmtPart();
    }

    @Override
    public void visit(DeferStmt entity) {
        part = new DeferStmtPart();
    }

    @Override
    public void visit(SwitchCaseList entity) {
        part = new SwitchCaseListPart();
    }

    @Override
    public void visit(RepeatWhileStmt entity) {
        part = new RepeatWhileStmtPart();
    }

    @Override
    public void visit(GuardStmt entity) {
        part = new GuardStmtPart();
    }

    @Override
    public void visit(ForInStmt entity) {
        part = new ForInStmtPart();
    }

    @Override
    public void visit(SwitchStmt entity) {
        part = new SwitchStmtPart();
    }

    @Override
    public void visit(CatchClauseList entity) {
        part = new CatchClauseListPart();
    }

    @Override
    public void visit(DoStmt entity) {
        part = new DoStmtPart();
    }

    @Override
    public void visit(ReturnStmt entity) {
        part = new ReturnStmtPart();
    }

    @Override
    public void visit(YieldStmt entity) {
        part = new YieldStmtPart();
    }

    @Override
    public void visit(YieldList entity) {
        part = new YieldListPart();
    }

    @Override
    public void visit(FallthroughStmt entity) {
        part = new FallthroughStmtPart();
    }

    @Override
    public void visit(BreakStmt entity) {
        part = new BreakStmtPart();
    }

    @Override
    public void visit(AvailabilityCondition entity) {
        part = new AvailabilityConditionPart();
    }

    @Override
    public void visit(MatchingPatternCondition entity) {
        part = new MatchingPatternConditionPart();
    }

    @Override
    public void visit(OptionalBindingCondition entity) {
        part = new OptionalBindingConditionPart();
    }

    @Override
    public void visit(ConditionElementList entity) {
        part = new ConditionElementListPart();
    }

    @Override
    public void visit(ThrowStmt entity) {
        part = new ThrowStmtPart();
    }

    @Override
    public void visit(IfStmt entity) {
        part = new IfStmtPart();
    }

    @Override
    public void visit(SwitchCase entity) {
        part = new SwitchCasePart();
    }

    @Override
    public void visit(SwitchDefaultLabel entity) {
        part = new SwitchDefaultLabelPart();
    }

    @Override
    public void visit(CaseItem entity) {
        part = new CaseItemPart();
    }

    @Override
    public void visit(SwitchCaseLabel entity) {
        part = new SwitchCaseLabelPart();
    }

    @Override
    public void visit(CatchClause entity) {
        part = new CatchClausePart();
    }

    @Override
    public void visit(PoundAssertStmt entity) {
        part = new PoundAssertStmtPart();
    }

    @Override
    public void visit(GenericRequirementList entity) {
        part = new GenericRequirementListPart();
    }

    @Override
    public void visit(SameTypeRequirement entity) {
        part = new SameTypeRequirementPart();
    }

    @Override
    public void visit(GenericParameterList entity) {
        part = new GenericParameterListPart();
    }

    @Override
    public void visit(GenericParameter entity) {
        part = new GenericParameterPart();
    }

    @Override
    public void visit(ConformanceRequirement entity) {
        part = new ConformanceRequirementPart();
    }

    @Override
    public void visit(SimpleTypeIdentifier entity) {
        part = new SimpleTypeIdentifierPart();
    }

    @Override
    public void visit(MemberTypeIdentifier entity) {
        part = new MemberTypeIdentifierPart();
    }

    @Override
    public void visit(ClassRestrictionType entity) {
        part = new ClassRestrictionTypePart();
    }

    @Override
    public void visit(ArrayType entity) {
        part = new ArrayTypePart();
    }

    @Override
    public void visit(DictionaryType entity) {
        part = new DictionaryTypePart();
    }

    @Override
    public void visit(MetatypeType entity) {
        part = new MetatypeTypePart();
    }

    @Override
    public void visit(OptionalType entity) {
        part = new OptionalTypePart();
    }

    @Override
    public void visit(SomeType entity) {
        part = new SomeTypePart();
    }

    @Override
    public void visit(ImplicitlyUnwrappedOptionalType entity) {
        part = new ImplicitlyUnwrappedOptionalTypePart();
    }

    @Override
    public void visit(CompositionTypeElement entity) {
        part = new CompositionTypeElementPart();
    }

    @Override
    public void visit(CompositionType entity) {
        part = new CompositionTypePart();
    }

    @Override
    public void visit(TupleTypeElement entity) {
        part = new TupleTypeElementPart();
    }

    @Override
    public void visit(TupleTypeElementList entity) {
        part = new TupleTypeElementListPart();
    }

    @Override
    public void visit(TupleType entity) {
        part = new TupleTypePart();
    }

    @Override
    public void visit(FunctionType entity) {
        part = new FunctionTypePart();
    }

    @Override
    public void visit(AttributedType entity) {
        part = new AttributedTypePart();
    }

    @Override
    public void visit(GenericArgumentList entity) {
        part = new GenericArgumentListPart();
    }

    @Override
    public void visit(EnumCasePattern entity) {
        part = new EnumCasePatternPart();
    }

    @Override
    public void visit(IsTypePattern entity) {
        part = new IsTypePatternPart();
    }

    @Override
    public void visit(OptionalPattern entity) {
        part = new OptionalPatternPart();
    }

    @Override
    public void visit(IdentifierPattern entity) {
        part = new IdentifierPatternPart();
    }

    @Override
    public void visit(SelfMarker entity) {
        part = new SelfMarkerPart();
    }

    @Override
    public void visit(AsTypePattern entity) {
        part = new AsTypePatternPart();
    }

    @Override
    public void visit(WildcardPattern entity) {
        part = new WildcardPatternPart();
    }

    @Override
    public void visit(TuplePatternElement entity) {
        part = new TuplePatternElementPart();
    }

    @Override
    public void visit(ExpressionPattern entity) {
        part = new ExpressionPatternPart();
    }

    @Override
    public void visit(TuplePatternElementList entity) {
        part = new TuplePatternElementListPart();
    }

    @Override
    public void visit(ValueBindingPattern entity) {
        part = new ValueBindingPatternPart();
    }

    @Override
    public void visit(AvailabilitySpecList entity) {
        part = new AvailabilitySpecListPart();
    }

    @Override
    public void visit(AvailabilityLabeledArgument entity) {
        part = new AvailabilityLabeledArgumentPart();
    }

    @Override
    public void visit(AvailabilityVersionRestriction entity) {
        part = new AvailabilityVersionRestrictionPart();
    }

    @Override
    public void visit(VersionTuple entity) {
        part = new VersionTuplePart();
    }
}
