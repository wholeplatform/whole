package org.whole.lang.artifacts.visitors;

import org.whole.lang.artifacts.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/** 
 * @generator Whole
 */
public class ArtifactsFailureVisitor extends ArtifactsIdentityVisitor {
	public boolean visitAdapter(IEntityAdapter entity) {
		throw new VisitException();
	}

	public void visit(Workspace entity) {
		throw new VisitException();
	}

	public void visit(Projects entity) {
		throw new VisitException();
	}

	public void visit(Project entity) {
		throw new VisitException();
	}

	public void visit(Artifacts entity) {
		throw new VisitException();
	}

	public void visit(PackageArtifact entity) {
		throw new VisitException();
	}

	public void visit(FolderArtifact entity) {
		throw new VisitException();
	}

	public void visit(FileArtifact entity) {
		throw new VisitException();
	}

	public void visit(Natures entity) {
		throw new VisitException();
	}

	public void visit(Nature entity) {
		throw new VisitException();
	}

	public void visit(LocationURI entity) {
		throw new VisitException();
	}

	public void visit(Metadata entity) {
		throw new VisitException();
	}

	public void visit(Name entity) {
		throw new VisitException();
	}

	public void visit(NameWithExtension entity) {
		throw new VisitException();
	}

	public void visit(Copyright entity) {
		throw new VisitException();
	}

	public void visit(License entity) {
		throw new VisitException();
	}

	public void visit(Author entity) {
		throw new VisitException();
	}

	public void visit(Extension entity) {
		throw new VisitException();
	}

	public void visit(Attributes entity) {
		throw new VisitException();
	}

	public void visit(Attribute entity) {
		throw new VisitException();
	}

	public void visit(PersistenceKitId entity) {
		throw new VisitException();
	}
}
