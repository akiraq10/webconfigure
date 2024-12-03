package testClasses;

import com.google.common.reflect.ClassPath;
import driver.Browser;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Get all test classes
        final ClassLoader loader = Thread.currentThread().getContextClassLoader();
        List<Class<?>> testClasses = new ArrayList<>();

        for (ClassPath.ClassInfo info : ClassPath.from(loader).getTopLevelClasses()) {
            String classInfoName = info.getName();
            boolean startWithTestDot = classInfoName.startsWith("testClasses.");
            boolean isBaseTestClass = classInfoName.startsWith("testClasses.BaseTest");
            boolean isMainTestClass = classInfoName.startsWith("testClasses.Main");
            boolean isAddUserTestClass = classInfoName.startsWith("testClasses.AddUserTest");


            if (isAddUserTestClass && !isBaseTestClass && !isMainTestClass) {
                testClasses.add(info.load());
            }
        }

        //Get browser,url,admin, pwd info
        String browser = System.getProperty("browser");
        String url = System.getProperty("url");
        String adminUser = System.getProperty("adminUser");
        String adminPwd = System.getProperty("pwd");
//        String browser = System.getenv("browser");
//        String url=System.getenv("url");
//        String adminUser=System.getenv("adminUser");
//        String adminPwd=System.getenv("pwd");


        // Check if all required properties are set
        if (browser == null || browser.isEmpty()) {
            throw new IllegalArgumentException("[ERR] Please provide the browser via -Dbrowser");
        }

        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("[ERR] Please provide the SES web url via -Durl");

        }

        if (adminUser == null || adminUser.isEmpty()) {
            throw new IllegalArgumentException("[ERR] Please provide the admin user via -DadminUser");
        }

        if (adminPwd == null || adminPwd.isEmpty()) {
            throw new IllegalArgumentException("[ERR] Please provide the admin password via -Dpwd");
        }


        try {
            Browser.valueOf(browser);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERR] We don't support browser " + browser + ", supported browsers: " + Arrays.toString(Browser.values()));
        }

        //Assign test classes to browser
//        final int testNumForBrowser = testClasses.size();
        Map<String, List<Class<?>>> desireCaps = new HashMap<>();
        desireCaps.put(browser, testClasses);

        //Build Test suite
        TestNG testNG = new TestNG();
        XmlSuite suite = new XmlSuite();
        suite.setName("Add and set admin for new user");

        List<XmlTest> allTests = new ArrayList<>();
        for (String browserNames : desireCaps.keySet()) {
            XmlTest test = new XmlTest(suite);
            test.setName(browserNames);
            List<XmlClass> xmlClasses = new ArrayList<>();
            List<Class<?>> delicatedClasses = desireCaps.get(browserNames);
            for (Class<?> delicatedClass : delicatedClasses) {
                xmlClasses.add(new XmlClass(delicatedClass.getName()));
            }
            test.setXmlClasses(xmlClasses);
            test.addParameter("browser", browser);
            test.addParameter("url", url);
            test.addParameter("adminUser", adminUser);
            test.addParameter("pwd", adminPwd);
            allTests.add(test);
        }
        suite.setTests(allTests);
        System.out.println(suite.toXml());

        //Add Testsuite into suite list
        List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);

        //invoke run method
        testNG.setXmlSuites(suites);
        testNG.run();


    }
}
