package org.whole.lang.artifacts.visitors;

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.artifacts.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class ArtifactsForwardGenericVisitor extends
		AbstractUnaryVisitor<IVisitor> implements IArtifactsVisitor {
	public ArtifactsForwardGenericVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Workspace entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Projects entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Project entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Artifacts entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(PackageArtifact entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(FolderArtifact entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(FileArtifact entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Natures entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Nature entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(LocationURI entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Metadata entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Name entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(NameWithExtension entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Copyright entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(License entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Author entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Extension entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Attributes entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Attribute entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(PersistenceKitId entity) {
		wGetVisitor1().visit(entity);
	}
}
