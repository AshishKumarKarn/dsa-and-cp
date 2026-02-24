package karn.interviews.jpmc;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.List;

public class Round1 {
}

//        Optional<Integer> reduce = integerStream
//                .filter(a -> a % 2 == 0)
//                .map(a -> a * a)
//                .reduce((a, b) -> a + b);
//        System.out.println(reduce.get());
//List of stocks
class Solution {
    //Stream of integers , find even -> sqr -> sum
    static void main() {
        //
        List<Integer> stocks = List.of(1, 2, 32, 24, 521, 16, 27, 58);
        //                             521    58    58    58     0      0   0  0
        int result = 0;
        for (int i = 0; i < stocks.size(); i++) {
            int purchased = stocks.get(i);
            for (int j = i + 4; j < stocks.size(); j++) {
                int currentProfit = stocks.get(j) - purchased;
                result = Math.max(result, currentProfit);
            }
        }
        System.out.println(result);

        //deadlock
        // A -> a lock
        // B -> b lock


    }

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    private void method() {
        //
        synchronized (lock1) {
            //long running IO operation userId -> getbalance -> amount
        }
    }
//    private static int maximumProfit(List<Integer> stocks, int c, boolean holding){
//        if(c>=stocks.size()){
//            return 0;
//        }
//        if(!)
//        int take =
//    }
}
