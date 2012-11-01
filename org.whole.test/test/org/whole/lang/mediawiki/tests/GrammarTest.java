package org.whole.lang.mediawiki.tests;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.whole.lang.tests.junit.EntityMatchers.*;
import org.junit.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.tests.junit.TestCase;

public class GrammarTest extends TestCase {

    @BeforeClass
    public static void wholeDeploy() {
        ReflectionFactory.deploy(new Deployer());
        bindGrammar();
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
        return GrammarTestTemplateManager.instance().create(templateName);
    }

    protected static IEntity evaluate(String templateName) {
        return evaluate(create(templateName));
    }

    /**
     *
     */
    static public void bindGrammar() {
        evaluate("fragment1");
    }

    /**
     *
     */
    @Test
    public void testTable() {
        bindings().wEnterScope();
        IEntity subject;
        subject = evaluate("fragment2");
        assertThat("at /testCases/0/tests/0/body/0", subject, matches(create("fragment3")));
        subject = evaluate("fragment4");
        assertThat("at /testCases/0/tests/0/body/1", subject, matches(create("fragment5")));
        subject = evaluate("fragment6");
        assertThat("at /testCases/0/tests/0/body/2", subject, matches(create("fragment7")));
        subject = evaluate("fragment8");
        assertThat("at /testCases/0/tests/0/body/3", subject, matches(create("fragment9")));
        subject = evaluate("fragment10");
        assertThat("at /testCases/0/tests/0/body/4", subject, matches(create("fragment11")));
        subject = evaluate("fragment12");
        assertThat("at /testCases/0/tests/0/body/5", subject, matches(create("fragment13")));
        subject = evaluate("fragment14");
        assertThat("at /testCases/0/tests/0/body/6", subject, matches(create("fragment15")));
        subject = evaluate("fragment16");
        assertThat("at /testCases/0/tests/0/body/7", subject, matches(create("fragment17")));
        subject = evaluate("fragment18");
        assertThat("at /testCases/0/tests/0/body/8", subject, matches(create("fragment19")));
        subject = evaluate("fragment20");
        assertThat("at /testCases/0/tests/0/body/9", subject, matches(create("fragment21")));
        subject = evaluate("fragment22");
        assertThat("at /testCases/0/tests/0/body/10", subject, matches(create("fragment23")));
        subject = evaluate("fragment24");
        assertThat("at /testCases/0/tests/0/body/11", subject, matches(create("fragment25")));
        subject = evaluate("fragment26");
        assertThat("at /testCases/0/tests/0/body/12", subject, matches(create("fragment27")));
        subject = evaluate("fragment28");
        assertThat("at /testCases/0/tests/0/body/13", subject, matches(create("fragment29")));
        subject = evaluate("fragment30");
        assertThat("at /testCases/0/tests/0/body/14", subject, matches(create("fragment31")));
        subject = evaluate("fragment32");
        assertThat("at /testCases/0/tests/0/body/15", subject, matches(create("fragment33")));
        bindings().wExitScope();
    }
}
