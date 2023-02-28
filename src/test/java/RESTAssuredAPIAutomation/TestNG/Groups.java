package RESTAssuredAPIAutomation.TestNG;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Groups {

    @Test(groups="sanity")
    @Description("Test Description: Sanity")
    public void sanityRun1(){
        System.out.println("Sanity check test1");
    }
    @Test(groups="sanity")
    @Description("Test Description: Sanity")
    public void sanityRun2(){
        System.out.println("Sanity check test2");
    }

    @Test(groups={"reg","sanity","smoke"})
    @Description("Test Description: Regression")
    public void regRun1(){
        System.out.println("Regression check test1");
    }
    @Test(groups={"reg","sanity"})
    @Description("Test Description: Regression")
    public void regRun2(){
        System.out.println("Regression check test2");
    }
    @Test(groups={"reg","smoke"})
    @Description("Test Description: Regression")
    public void regRun3(){
        System.out.println("Regression check test3");
    }
    @Test(groups={"reg","sanity","smoke"})
    @Description("Test Description: Regression")
    public void regRun4(){
        System.out.println("Regression check test4");
    }

    @Test(groups={"smoke","sanity"})
    @Description("Test Description: Smoke")
    public void smokeRun1(){
        System.out.println("Smoke check test1");
        Assert.assertTrue(false);
    }
    @Test(groups={"smoke","reg"})
    @Description("Test Description: Smoke")
    public void smokeRun2(){
        System.out.println("Smoke check test2");
    }

}
