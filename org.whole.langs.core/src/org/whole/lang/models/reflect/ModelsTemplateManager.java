package org.whole.lang.models.reflect;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.models.codebase.ActionsModel;
import org.whole.lang.models.codebase.ArtifactsModel;
import org.whole.lang.models.codebase.BPELModel;
import org.whole.lang.models.codebase.BPMModel;
import org.whole.lang.models.codebase.ClassModel;
import org.whole.lang.models.codebase.DBCFGModel;
import org.whole.lang.models.codebase.DataModel;
import org.whole.lang.models.codebase.ECoreModel;
import org.whole.lang.models.codebase.EditorsModel;
import org.whole.lang.models.codebase.EntitiesModel;
import org.whole.lang.models.codebase.FactoriesModel;
import org.whole.lang.models.codebase.FeatureModelModel;
import org.whole.lang.models.codebase.FirstOrderLogicModel;
import org.whole.lang.models.codebase.FlowchartModel;
import org.whole.lang.models.codebase.FramesModel;
import org.whole.lang.models.codebase.GrammarBasedModel;
import org.whole.lang.models.codebase.GrammarsModel;
import org.whole.lang.models.codebase.ILModel;
import org.whole.lang.models.codebase.JavaPatternsModel;
import org.whole.lang.models.codebase.JavaScriptModel;
import org.whole.lang.models.codebase.LangGenModel;
import org.whole.lang.models.codebase.LibrariesModel;
import org.whole.lang.models.codebase.MapsModel;
import org.whole.lang.models.codebase.MathModel;
import org.whole.lang.models.codebase.MathPresentationModel;
import org.whole.lang.models.codebase.MbedModel;
import org.whole.lang.models.codebase.MediaWikiModel;
import org.whole.lang.models.codebase.MiscModel;
import org.whole.lang.models.codebase.ModelsInfoModel;
import org.whole.lang.models.codebase.ModelsModel;
import org.whole.lang.models.codebase.ORMModel;
import org.whole.lang.models.codebase.OperationsModel;
import org.whole.lang.models.codebase.PojoModel;
import org.whole.lang.models.codebase.PresentationModel;
import org.whole.lang.models.codebase.ProcessGraphModel;
import org.whole.lang.models.codebase.PropertiesModel;
import org.whole.lang.models.codebase.RDBModel;
import org.whole.lang.models.codebase.RDFModel;
import org.whole.lang.models.codebase.SQLModel;
import org.whole.lang.models.codebase.SchemeModel;
import org.whole.lang.models.codebase.ScriptsModel;
import org.whole.lang.models.codebase.StatusModel;
import org.whole.lang.models.codebase.TemplatesModel;
import org.whole.lang.models.codebase.TestEntities;
import org.whole.lang.models.codebase.TestEvents;
import org.whole.lang.models.codebase.TestORM;
import org.whole.lang.models.codebase.TestsModel;
import org.whole.lang.models.codebase.TextModel;
import org.whole.lang.models.codebase.TopicMapsModel;
import org.whole.lang.models.codebase.TopicsModel;
import org.whole.lang.models.codebase.TransformersModel;
import org.whole.lang.models.codebase.TypesModel;
import org.whole.lang.models.codebase.UnifiedLambdaDeltaModel;
import org.whole.lang.models.codebase.VariantsModel;
import org.whole.lang.models.codebase.VersionsModel;
import org.whole.lang.models.codebase.VisitorsModel;
import org.whole.lang.models.codebase.WorkflowsModel;
import org.whole.lang.models.codebase.XmlModel;
import org.whole.lang.models.codebase.XsdMappingModel;
import org.whole.lang.models.codebase.XsdModel;
import org.whole.lang.models.model.Model;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;

/** 
 * @generator Whole
 */
public class ModelsTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final ModelsTemplateManager instance = new ModelsTemplateManager();
	}

	public static ModelsTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private ModelsTemplateManager() {
		put("empty", new AbstractTemplateFactory<Model>() {
			public Model create() {
				return GenericEntityFactory.instance
						.create(ModelsEntityDescriptorEnum.Model);
			}
		});

		
		put("Test Events model", new TestEvents());
		put("Test Entities model", new TestEntities());
		put("Test ORM model", new TestORM());

		put("LangGen model", new LangGenModel());
		put("ORM model", new ORMModel());
		put("RDB model", new RDBModel());
		put("SQL model", new SQLModel());
		put("DBCFG model", new DBCFGModel());

		put("Actions", new ActionsModel());
		put("Artifacts model", new ArtifactsModel());
		put("Math model", new MathModel());
		put("Models model", new ModelsModel());
		put("Models Info model", new ModelsInfoModel());
		put("Pojo model", new PojoModel());
		put("ECore model", new ECoreModel());
		put("Misc model", new MiscModel());
		put("Templates model", new TemplatesModel());
		put("Factories model", new FactoriesModel());
		put("Visitors model", new VisitorsModel());
		put("Operations model", new OperationsModel());
		put("Versions model", new VersionsModel());
		put("Editors model", new EditorsModel());
		put("Presentation model", new PresentationModel());
		put("Mbed model", new MbedModel());
		put("Tests model", new TestsModel());
		put("Types model", new TypesModel());
		put("Libraries model", new LibrariesModel());

		put("Maps model", new MapsModel());
		put("Topics model", new TopicsModel());
		put("Class model", new ClassModel());
		put("Entities model", new EntitiesModel());
		put("FeatureModel model", new FeatureModelModel());
		put("Frames model", new FramesModel());
		put("Variants model", new VariantsModel());

		put("Process Graph model", new ProcessGraphModel());
		put("BPEL model", new BPELModel());
		put("Business Process Model model", new BPMModel());
		put("Flowchart model", new FlowchartModel());
		put("Workflows model", new WorkflowsModel());
//		put("Workflow model", new WorkflowModel());
//		put("Workflow model old", new WorkflowModelOld());
		put("IL model", new ILModel());

		put("First Order Logic model", new FirstOrderLogicModel());
		put("Unified Lambda Delta Model", new UnifiedLambdaDeltaModel());
		put("RDF model", new RDFModel());
		put("TopicMaps model", new TopicMapsModel());

		put("Java Patterns model", new JavaPatternsModel());
		put("Xml model", new XmlModel());
		put("Xsd model", new XsdModel());
		put("Xsd Mapping model", new XsdMappingModel());
		put("Properties model", new PropertiesModel());
		put("Text model", new TextModel());
		put("Grammars model", new GrammarsModel());
		put("Grammar Based Notation model", new GrammarBasedModel());
		put("Data model", new DataModel());
		put("MediaWiki model", new MediaWikiModel());
		put("Status model", new StatusModel());

		put("Math Presentation model", new MathPresentationModel());
		put("Scheme model", new SchemeModel());

		put("Transformers model", new TransformersModel());

		put("Scripts model", new ScriptsModel());
		put("JavaScript model", new JavaScriptModel());
	}
}