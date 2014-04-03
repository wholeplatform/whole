package org.whole.lang.modules.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.modules.model.*;

/**
 *  @generator  Whole
 */
public interface IModulesVisitor extends IVisitor {


    public void visit(Module entity);

    public void visit(Include entity);

    public void visit(Reuse entity);

    public void visit(Resource entity);

    public void visit(WorkspacePath entity);

    public void visit(FileSystemPath entity);

    public void visit(ClassPathURI entity);

    public void visit(URI entity);

    public void visit(Persistence entity);

    public void visit(Registry entity);
}
