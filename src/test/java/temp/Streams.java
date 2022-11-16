package temp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Streams {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>(){
            {
                for (int i = 0; i <20; i++) {
                    add(new Random().nextInt(20));
                }
            }
        };
        System.out.println(list);
        List<Integer> list1 = list.stream().filter(n -> n % 3 == 0).toList();
        System.out.println(list1);
    }
}
