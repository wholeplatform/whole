package org.whole.lang.reusables.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.reusables.model.*;

/**
 *  @generator  Whole
 */
public interface IReusablesVisitor extends IVisitor {


    public void visit(Adapt entity);

    public void visit(Reuse entity);

    public void visit(Synch entity);

    public void visit(Include entity);

    public void visit(Reusables entity);

    public void visit(ReferenceStep entity);

    public void visit(Resource entity);

    public void visit(Registry entity);

    public void visit(WorkspacePath entity);

    public void visit(FileSystemPath entity);

    public void visit(ClassPathURI entity);

    public void visit(URI entity);

    public void visit(Persistence entity);
}
