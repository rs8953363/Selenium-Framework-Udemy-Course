package Sec14StreamsAutoSortPeginationFilteringTables;

import org.testng.*;
import org.testng.annotations.*;

import java.util.*;
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
        Long c =names.stream().filter(s ->s.startsWith("A")).count();//stream is collection of Strings. Filter is a
        // terminal operation
        System.out.println(c);

       long d= Stream.of("Abigail","Don","Alexis","Adam","Robert").filter(s-> {
        s.startsWith("A");
        return true;  //return false; This does not work. It needs to be true If filter fails, ocunt operation will not work.
       }).count();
        System.out.println(d);
        //print all the names of ArrayList whose length is>4
       // names.stream().filter(s->s.length()>4).forEach(s-> System.out.println(s));
        names.stream().filter(s->s.length()>4).limit(1).forEach(s-> System.out.println(s));
        }

        @Test
    public void streamMap(){
        //print names  which have last letter as "t" with Uppercase
            Stream.of("Abigail","Don","Alexis","Adam","Robert").filter(s->s.endsWith("t")).map(s->s.toUpperCase())
                    .forEach(s-> System.out.println(s));
            //print names which have first letter as "a" "with uppercase and sorted
            List<String> names = Arrays.asList("Abigail","Don","Alexis","Adam","Robert");
            names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase())
                    .forEach(s-> System.out.println(s));
        }

        @Test
    public void streamMap2(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("man");
        names.add("Don");
        names.add("women");

            //print names of length>4 with Uppercase
            Stream.of("Abigail","Don","Alexis","Adam","Robert").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
                    .forEach(s-> System.out.println(s));
            //print names which have first letter as a with uppercase and sorted
            List<String> names1 = Arrays.asList("Abigail","Don","Alexis","Adam","Robert");
            names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase())
                    .forEach(s-> System.out.println(s));
        //Merging two different lists
            Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
            //newStream.sorted().forEach(s-> System.out.println(s));

            boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
            System.out.println(flag);
            Assert.assertTrue(flag);

        }
        @Test
    public void streamCollect(){
           List<String> ls = Stream.of("Abigail","Don","Alexis","Adam","Robert").filter(s->s.endsWith("n")).map(s->s.toUpperCase())
                    .collect(Collectors.toList());
            System.out.println(ls.get(0));//Prints the first result. Instead of clollections, you can use the limit
            // method that's above.

            //print unique number from this array   //sort the array  print the 3rd index
            List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
            //values.stream().distinct().forEach(s-> System.out.println(s));
            List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
            System.out.println(li.get(2));//This line prints the third result
        }

        }
