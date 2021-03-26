import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass
{
    @Test
    public void testGetLocalNumber()
    {
        Assert.assertTrue("getLocalNumber not return 14", this.getLocalNumber() == 14);
    }

    @Test
    public void  testGetClassNumber()
    {
        if (this.getClassNumber() > 45){
            System.out.println("ok");
        }else if(this.getClassNumber() < 45) {
            System.out.println("getClassNumber < 45");
        }else{
            System.out.println("getClassNumber == 45");
        }

        Assert.assertTrue("getClassNumber !> 45",this.getClassNumber() > 45);
    }

    @Test
    public void testGetClassString()
    {
        String substring = "hello";
        Assert.assertTrue("Не содержит подстроки - hello ", this.getClass_string().toLowerCase().contains(substring));
    }
}
