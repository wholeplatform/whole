package org.whole.lang.grammars.util.tests;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.whole.lang.tests.junit.EntityMatchers.*;

import org.junit.*;
import org.junit.experimental.categories.Category;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.tests.junit.TestCase;
import org.whole.test.SlowTests;

@Category(SlowTests.class)
public class GenericPredictiveParserTest extends TestCase {

    @BeforeClass
    public static void wholeDeploy() {
        ReflectionFactory.deploy(new Deployer());
    }

    @AfterClass
    public static void wholeUndeploy() {
        ReflectionFactory.undeploy(new Deployer());
    }

    protected static class Deployer extends org.whole.lang.reflect.AbstractContributionDeployer {

        public void deploy(ReflectionFactory platform) {
            evaluate("fragment");
        }
    }

    protected static IEntity create(String templateName) {
        return GenericPredictiveParserTestTemplateManager.instance().create(templateName);
    }

    protected static IEntity evaluate(String templateName) {
        return evaluate(create(templateName));
    }

    /**
     *
     */
    @Test
    public void testParseDataTypesGrammar() {
        bindings().wEnterScope();
        IEntity subject;
        evaluate("fragment1");
        subject = evaluate("fragment2");
        assertThat("at /testCases/2/tests/0/body/1", subject, matches(create("fragment3")));
        bindings().wExitScope();
    }

    /**
     *
     */
    @Test
    public void testParseMessagesGrammar() {
        bindings().wEnterScope();
        IEntity subject;
        evaluate("fragment4");
        subject = evaluate("fragment5");
        assertThat("at /testCases/2/tests/1/body/1", subject, matches(create("fragment6")));
        bindings().wExitScope();
    }

    /**
     *
     */
	@Test
    public void testParseStateMachineGrammar() {
        bindings().wEnterScope();
        IEntity subject;
        evaluate("fragment7");
        subject = evaluate("fragment8");
        assertThat("at /testCases/2/tests/2/body/1", subject, matches(create("fragment9")));
        bindings().wExitScope();
    }

    /**
     *
     */
	@Test
    public void testParseStateMachine2Grammar() {
        bindings().wEnterScope();
        IEntity subject;
        evaluate("fragment10");
        subject = evaluate("fragment11");
        assertThat("at /testCases/2/tests/3/body/1", subject, matches(create("fragment12")));
        bindings().wExitScope();
    }

    /**
     *
     */
    @Test
    public void testParseFamilyGrammar() {
        bindings().wEnterScope();
        IEntity subject;
        evaluate("fragment13");
        subject = evaluate("fragment14");
        assertThat("at /testCases/2/tests/4/body/1", subject, matches(create("fragment15")));
        bindings().wExitScope();
    }

    /**
     *
     */
    @Test
    public void testParseMT3Grammar() {
        bindings().wEnterScope();
        IEntity subject;
        evaluate("fragment16");
        subject = evaluate("fragment17");
        assertThat("at /testCases/2/tests/5/body/1", subject, matches(create("fragment18")));
        bindings().wExitScope();
    }

    /**
     *
     */
	@Test
    public void testParseDTAUSGrammar() {
        bindings().wEnterScope();
        IEntity subject;
        evaluate("fragment19");
        subject = evaluate("fragment20");
        assertThat("at /testCases/2/tests/6/body/1", subject, matches(create("fragment21")));
        bindings().wExitScope();
    }

    /**
     *
     */
    @Test
    public void testParseMotoGPCSVGrammar() {
        bindings().wEnterScope();
        IEntity subject;
        evaluate("fragment22");
        subject = evaluate("fragment23");
        assertThat("at /testCases/2/tests/7/body/1", subject, matches(create("fragment24")));
        bindings().wExitScope();
    }

    /**
     *
     */
    @Test
    public void testParseMotoGPFLFGrammar() {
        bindings().wEnterScope();
        IEntity subject;
        evaluate("fragment25");
        subject = evaluate("fragment26");
        assertThat("at /testCases/2/tests/8/body/1", subject, matches(create("fragment27")));
        bindings().wExitScope();
    }
}
