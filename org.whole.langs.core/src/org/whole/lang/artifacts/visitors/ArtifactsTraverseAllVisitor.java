package org.whole.lang.artifacts.visitors;

import org.whole.lang.artifacts.visitors.ArtifactsIdentityUnaryVisitor;
import org.whole.lang.artifacts.visitors.IArtifactsVisitor;
import org.whole.lang.artifacts.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class ArtifactsTraverseAllVisitor extends
		ArtifactsIdentityUnaryVisitor<IArtifactsVisitor> {
	public ArtifactsTraverseAllVisitor() {
		wSetVisitor1(this);
	}

	public ArtifactsTraverseAllVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Workspace entity) {
		entity.getMetadata().accept(wGetVisitor1());
		entity.getProjects().accept(wGetVisitor1());
	}

	public void visit(Projects entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Project entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getNatures().accept(wGetVisitor1());
		entity.getMetadata().accept(wGetVisitor1());
		entity.getArtifacts().accept(wGetVisitor1());
		entity.getLocationURI().accept(wGetVisitor1());
	}

	public void visit(Artifacts entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(PackageArtifact entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getMetadata().accept(wGetVisitor1());
		entity.getArtifacts().accept(wGetVisitor1());
	}

	public void visit(FolderArtifact entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getMetadata().accept(wGetVisitor1());
		entity.getArtifacts().accept(wGetVisitor1());
	}

	public void visit(FileArtifact entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getMetadata().accept(wGetVisitor1());
		entity.getContent().accept(wGetVisitor1());
	}

	public void visit(Natures entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Metadata entity) {
		entity.getCopyright().accept(wGetVisitor1());
		entity.getLicense().accept(wGetVisitor1());
		entity.getAuthor().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getPersistenceKitId().accept(wGetVisitor1());
	}

	public void visit(NameWithExtension entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getExtension().accept(wGetVisitor1());
	}

	public void visit(Attributes entity) {
		for (Attribute child : entity)
			child.accept(wGetVisitor1());
	}
}
