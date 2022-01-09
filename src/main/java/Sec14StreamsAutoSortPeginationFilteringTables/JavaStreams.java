package Sec14StreamsAutoSortPeginationFilteringTables;

import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.stream.*;

public class JavaStreams {

    //Count the number of names starting with letter A

    @Test
    public void regular(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("Abigail");
        names.add("Don");
        names.add("Alexis");
        names.add("Adam");
        names.add("Robert");

        int count =0;

        for (int i = 0; i < names.size(); i++) {
            String actual = names.get(i);
            if(actual.startsWith("A"))
                count++;
        }
        System.out.println(count);
    }

    @Test
    public void streamFilter(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("Abigail");
        names.add("Don");
        names.add("Alexis");
        names.add("Adam");
        names.add("Robert");

        //The following operation is called an intermediate operation. Terminal operation will execute only if
        // intermediate operation(filter) returns true.
        Long c =names.stream().filter(s ->s.startsWith("A")).count();
        System.out.println(c);

       Long d= Stream.of("Abigail","Don","Alexis","Adam","Robert").filter(s-> {
        s.startsWith("A");
        return true;  //return false; This does not work. It needs to be true
       }).count();
        System.out.println(d);
        }

    }
}