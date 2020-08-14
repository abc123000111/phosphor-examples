package com.josecambronero;
import edu.columbia.cs.psl.phosphor.runtime.MultiTainter;
import java.lang.reflect.Method;

class Demo{
    public int test(int x){
        return x;
    }
}
public class ReflectionExamples
{
    public static void main(String[] args) {
        try {
            int x = 0;
            x = MultiTainter.taintedInt(x, "tag");
            Demo demo = new Demo();
            Class clazz = demo.getClass();
            Method m1 = clazz.getDeclaredMethod("test",int.class);
            int ret=(int)m1.invoke(demo,x);
            System.out.println("Reflect: " + MultiTainter.getTaint(ret).toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
