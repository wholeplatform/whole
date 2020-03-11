package org.whole.lang.swift.tabularui.editparts;

import org.eclipse.gef.EditPart;
import org.whole.lang.swift.model.ClassDecl;
import org.whole.lang.swift.model.CodeBlockItemList;
import org.whole.lang.swift.model.DeinitializerDecl;
import org.whole.lang.swift.model.ExtensionDecl;
import org.whole.lang.swift.model.FunctionCallArgument;
import org.whole.lang.swift.model.FunctionCallArgumentList;
import org.whole.lang.swift.model.FunctionDecl;
import org.whole.lang.swift.model.FunctionParameter;
import org.whole.lang.swift.model.FunctionParameterList;
import org.whole.lang.swift.model.ISwiftEntity;
import org.whole.lang.swift.model.InitializerDecl;
import org.whole.lang.swift.model.MemberDeclList;
import org.whole.lang.swift.model.ProtocolDecl;
import org.whole.lang.swift.model.StructDecl;
import org.whole.lang.swift.model.VariableDecl;
import org.whole.lang.swift.ui.editparts.SwiftPartFactoryVisitor;
import org.whole.lang.swift.visitors.SwiftIdentityDefaultVisitor;
import org.whole.lang.ui.editparts.IEditPartFactory;

public class SwiftTabularPartFactoryVisitor extends SwiftIdentityDefaultVisitor implements IEditPartFactory {
    protected EditPart part, context;

    public EditPart createEditPart(EditPart context, Object modelEntity) {
        this.context = context;
        ((ISwiftEntity) modelEntity).accept(this);
        return part;
    }

    public void visit(ISwiftEntity entity) {
        part = new SwiftPartFactoryVisitor().createEditPart(context, entity);
    }

    @Override
    public void visit(CodeBlockItemList entity) {
        part = new CodeBlockItemListPart();
    }

    @Override
    public void visit(MemberDeclList entity) {
        part = new MemberDeclListPart();
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
    public void visit(InitializerDecl entity) {
        part = new InitializerDeclPart();
    }

    @Override
    public void visit(DeinitializerDecl entity) {
        part = new DeinitializerDeclPart();
    }

    @Override
    public void visit(FunctionDecl entity) {
        part = new FunctionDeclPart();
    }

    @Override
    public void visit(VariableDecl entity) {
        part = new VariableDeclPart();
    }

    @Override
    public void visit(FunctionParameterList entity) {
        part = new FunctionParameterListPart();
    }

    @Override
    public void visit(FunctionParameter entity) {
        part = new FunctionParameterPart();
    }

    @Override
    public void visit(FunctionCallArgumentList entity) {
        part = new FunctionCallArgumentListPart();
    }

    @Override
    public void visit(FunctionCallArgument entity) {
        part = new FunctionCallArgumentPart();
    }
}
