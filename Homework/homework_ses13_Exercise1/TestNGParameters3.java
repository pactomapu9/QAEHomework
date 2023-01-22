package homework_ses13_Exercise1;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParameters3
{

    @Test
    @Parameters ({"val1", "val2"})
    public void mul(int v1, int v2) {
    	int prod = v1*v2;
        System.out.println("The Product Of Value 1 and 2 is " + prod);
    }

    @Test
    @Parameters ({"val1", "val2"})
    public void divide(int v1, int v2) {
    	int div;
    	try {
    		div = v1/v2;
    		System.out.println("The ratio of Value 1 and 2 is " + div);
    	} catch (Exception e) {
    		System.out.println("Can't divide by zero");
    	}
    }
}