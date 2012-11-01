package org.whole.lang.visitors;

import java.util.List;

import org.whole.gen.JavaStoreBuilder;
import org.whole.lang.artifacts.model.Artifacts;
import org.whole.lang.artifacts.model.Attribute;
import org.whole.lang.artifacts.model.Attributes;
import org.whole.lang.artifacts.model.Author;
import org.whole.lang.artifacts.model.Copyright;
import org.whole.lang.artifacts.model.Extension;
import org.whole.lang.artifacts.model.FileArtifact;
import org.whole.lang.artifacts.model.FolderArtifact;
import org.whole.lang.artifacts.model.IArtifactsEntity;
import org.whole.lang.artifacts.model.License;
import org.whole.lang.artifacts.model.Metadata;
import org.whole.lang.artifacts.model.Name;
import org.whole.lang.artifacts.model.NameWithExtension;
import org.whole.lang.artifacts.model.Nature;
import org.whole.lang.artifacts.model.Natures;
import org.whole.lang.artifacts.model.PackageArtifact;
import org.whole.lang.artifacts.model.PackageName;
import org.whole.lang.artifacts.model.Project;
import org.whole.lang.artifacts.model.Projects;
import org.whole.lang.artifacts.model.Workspace;
import org.whole.lang.artifacts.visitors.ArtifactsIdentityVisitor;

/** 
 * @generator Whole
 */
public class ArtifactsJavaStoreGeneratorVisitor extends ArtifactsIdentityVisitor {
	private final JavaStoreBuilder builder;

	private final boolean isCompiling;

	public ArtifactsJavaStoreGeneratorVisitor(JavaStoreBuilder builder,
			boolean isCompiling) {
		this.builder = builder;
		this.isCompiling = isCompiling;
		builder.addLanguageFactory(this,
				"org.whole.lang.artifacts.model.ArtifactsLanguageFactory");
	}

	private final org.eclipse.jdt.core.dom.Expression astOf(
			IArtifactsEntity entity) {
		entity.accept(this);
		return builder.getExpression();
	}

	protected org.eclipse.jdt.core.dom.Expression astOf(Object entity) {
		return builder.newNullLiteral();
	}

	public void visit(Workspace entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createWorkspace");
		callExp.arguments().add(astOf(entity.getMetadata()));
		callExp.arguments().add(astOf(entity.getProjects()));
		builder.addSubtree(parentNestingSize, "Workspace", callExp);
	}

	public void visit(Projects entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createProjects");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("IProject", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IArtifactsEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "Projects", callExp);
	}

	public void visit(Project entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createProject");
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getNatures()));
		callExp.arguments().add(astOf(entity.getMetadata()));
		callExp.arguments().add(astOf(entity.getArtifacts()));
		builder.addSubtree(parentNestingSize, "Project", callExp);
	}

	public void visit(Artifacts entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createArtifacts");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("Artifact", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IArtifactsEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "Artifacts", callExp);
	}

	public void visit(FolderArtifact entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createFolderArtifact");
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getMetadata()));
		callExp.arguments().add(astOf(entity.getArtifacts()));
		builder.addSubtree(parentNestingSize, "FolderArtifact", callExp);
	}

	public void visit(PackageArtifact entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createPackageArtifact");
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getMetadata()));
		callExp.arguments().add(astOf(entity.getArtifacts()));
		builder.addSubtree(parentNestingSize, "PackageArtifact", callExp);
	}

	public void visit(FileArtifact entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createFileArtifact");
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getMetadata()));
		callExp.arguments().add(astOf(entity.getContent()));
		builder.addSubtree(parentNestingSize, "FileArtifact", callExp);
	}

	public void visit(Natures entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createNatures");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("INature", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IArtifactsEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "Natures", callExp);
	}

	public void visit(Nature entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createNature");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "Nature", callExp);
	}

	public void visit(Metadata entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createMetadata");
		callExp.arguments().add(astOf(entity.getCopyright()));
		callExp.arguments().add(astOf(entity.getLicense()));
		callExp.arguments().add(astOf(entity.getAuthor()));
		callExp.arguments().add(astOf(entity.getAttributes()));
		builder.addSubtree(parentNestingSize, "Metadata", callExp);
	}

	public void visit(Copyright entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createCopyright");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "Copyright", callExp);
	}

	public void visit(License entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createLicense");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "License", callExp);
	}

	public void visit(Author entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createAuthor");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "Author", callExp);
	}

	public void visit(PackageName entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createPackageName");
		callExp.arguments().add(builder.newLiteral(entity.wStringValue()));
		builder.addSubtree(parentNestingSize, "PackageName", callExp);
	}

	public void visit(Name entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createName");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "Name", callExp);
	}

	public void visit(NameWithExtension entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createNameWithExtension");
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getExtension()));
		builder.addSubtree(parentNestingSize, "NameWithExtension", callExp);
	}

	public void visit(Extension entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createExtension");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "Extension", callExp);
	}

	public void visit(Attributes entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createAttributes");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("IAttribute", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IArtifactsEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "Attributes", callExp);
	}

	public void visit(Attribute entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createAttribute");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "Attribute", callExp);
	}
}