package org.whole.lang.artifacts.visitors;

import org.whole.lang.artifacts.model.*;

/** 
 * @generator Whole
 */
public class ArtifactsIdentityDefaultVisitor extends ArtifactsIdentityVisitor {
	public void visit(IArtifactsEntity entity) {
	}

	public void visit(Workspace entity) {
		visit((IArtifactsEntity) entity);
	}

	public void visit(Projects entity) {
		visit((IArtifactsEntity) entity);
	}

	public void visit(Project entity) {
		visit((IArtifactsEntity) entity);
	}

	public void visit(Artifacts entity) {
		visit((IArtifactsEntity) entity);
	}

	public void visit(Artifact entity) {
	}

	public void visit(PackageArtifact entity) {
		visit((IArtifactsEntity) entity);
		visit((Artifact) entity);
	}

	public void visit(FolderArtifact entity) {
		visit((IArtifactsEntity) entity);
		visit((Artifact) entity);
	}

	public void visit(FileArtifact entity) {
		visit((IArtifactsEntity) entity);
		visit((Artifact) entity);
	}

	public void visit(Natures entity) {
		visit((IArtifactsEntity) entity);
	}

	public void visit(Nature entity) {
		visit((IArtifactsEntity) entity);
	}

	public void visit(LocationURI entity) {
		visit((IArtifactsEntity) entity);
	}

	public void visit(Metadata entity) {
		visit((IArtifactsEntity) entity);
	}

	public void visit(ProjectName entity) {
	}

	public void visit(Name entity) {
		visit((IArtifactsEntity) entity);
		visit((ProjectName) entity);
		visit((PackageName) entity);
		visit((FolderName) entity);
		visit((FileName) entity);
	}

	public void visit(PackageName entity) {
	}

	public void visit(FolderName entity) {
	}

	public void visit(FileName entity) {
	}

	public void visit(NameWithExtension entity) {
		visit((IArtifactsEntity) entity);
		visit((FileName) entity);
	}

	public void visit(Copyright entity) {
		visit((IArtifactsEntity) entity);
	}

	public void visit(License entity) {
		visit((IArtifactsEntity) entity);
	}

	public void visit(Author entity) {
		visit((IArtifactsEntity) entity);
	}

	public void visit(Extension entity) {
		visit((IArtifactsEntity) entity);
	}

	public void visit(Attributes entity) {
		visit((IArtifactsEntity) entity);
	}

	public void visit(Attribute entity) {
		visit((IArtifactsEntity) entity);
	}

	public void visit(PersistenceKitId entity) {
		visit((IArtifactsEntity) entity);
	}
}
