package org.whole.lang.artifacts.visitors;

import org.whole.lang.artifacts.visitors.ArtifactsIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.artifacts.model.*;

/** 
 * @generator Whole
 */
public class ArtifactsTraverseAllSwitchVisitor extends
		ArtifactsIdentityUnaryVisitor<IVisitor> {
	public ArtifactsTraverseAllSwitchVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Workspace entity) {
		wGetVisitor1().visit(entity.getMetadata());
		wGetVisitor1().visit(entity.getProjects());
	}

	public void visit(Projects entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Project entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getNatures());
		wGetVisitor1().visit(entity.getMetadata());
		wGetVisitor1().visit(entity.getArtifacts());
		wGetVisitor1().visit(entity.getLocationURI());
	}

	public void visit(Artifacts entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(PackageArtifact entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getMetadata());
		wGetVisitor1().visit(entity.getArtifacts());
	}

	public void visit(FolderArtifact entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getMetadata());
		wGetVisitor1().visit(entity.getArtifacts());
	}

	public void visit(FileArtifact entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getMetadata());
		wGetVisitor1().visit(entity.getContent());
	}

	public void visit(Natures entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Metadata entity) {
		wGetVisitor1().visit(entity.getCopyright());
		wGetVisitor1().visit(entity.getLicense());
		wGetVisitor1().visit(entity.getAuthor());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getPersistenceKitId());
	}

	public void visit(NameWithExtension entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getExtension());
	}

	public void visit(Attributes entity) {
		for (Attribute child : entity)
			wGetVisitor1().visit(child);
	}
}
