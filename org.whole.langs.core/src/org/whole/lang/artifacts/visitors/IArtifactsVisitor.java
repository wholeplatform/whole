package org.whole.lang.artifacts.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.artifacts.model.*;

/** 
 * @generator Whole
 */
public interface IArtifactsVisitor extends IVisitor {
	public void visit(Workspace entity);

	public void visit(Projects entity);

	public void visit(Project entity);

	public void visit(Artifacts entity);

	public void visit(PackageArtifact entity);

	public void visit(FolderArtifact entity);

	public void visit(FileArtifact entity);

	public void visit(Natures entity);

	public void visit(Nature entity);

	public void visit(LocationURI entity);

	public void visit(Metadata entity);

	public void visit(Name entity);

	public void visit(NameWithExtension entity);

	public void visit(Copyright entity);

	public void visit(License entity);

	public void visit(Author entity);

	public void visit(Extension entity);

	public void visit(Attributes entity);

	public void visit(Attribute entity);

	public void visit(PersistenceKitId entity);
}
