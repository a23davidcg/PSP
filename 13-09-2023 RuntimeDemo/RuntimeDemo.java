import java.util.*;


class RuntimeDemo
{
    public static void main(String args[])

    Scanne


        {
            Runtime Objrun=Runtime.getRuntime();//LINE A
            Process Objprocess=null;// LINE B
            try
            {
                Objprocess=Objrun.exec("notepad.exe");//LINE C
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
}
[[[[[[[[[[[[[[[[]]]]]]]]]]]]]]]]