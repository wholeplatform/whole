package org.whole.lang.artifacts.visitors;

import org.whole.lang.artifacts.model.*;

/** 
 * @generator Whole
 */
public class ArtifactsForwardStagedVisitor extends ArtifactsIdentityVisitor {
	public void visit(Workspace entity) {
		stagedVisit(entity);
	}

	public void visit(Projects entity) {
		stagedVisit(entity);
	}

	public void visit(Project entity) {
		stagedVisit(entity);
	}

	public void visit(Artifacts entity) {
		stagedVisit(entity);
	}

	public void visit(PackageArtifact entity) {
		stagedVisit(entity);
	}

	public void visit(FolderArtifact entity) {
		stagedVisit(entity);
	}

	public void visit(FileArtifact entity) {
		stagedVisit(entity);
	}

	public void visit(Natures entity) {
		stagedVisit(entity);
	}

	public void visit(Nature entity) {
		stagedVisit(entity);
	}

	public void visit(LocationURI entity) {
		stagedVisit(entity);
	}

	public void visit(Metadata entity) {
		stagedVisit(entity);
	}

	public void visit(Name entity) {
		stagedVisit(entity);
	}

	public void visit(NameWithExtension entity) {
		stagedVisit(entity);
	}

	public void visit(Copyright entity) {
		stagedVisit(entity);
	}

	public void visit(License entity) {
		stagedVisit(entity);
	}

	public void visit(Author entity) {
		stagedVisit(entity);
	}

	public void visit(Extension entity) {
		stagedVisit(entity);
	}

	public void visit(Attributes entity) {
		stagedVisit(entity);
	}

	public void visit(Attribute entity) {
		stagedVisit(entity);
	}

	public void visit(PersistenceKitId entity) {
		stagedVisit(entity);
	}
}
