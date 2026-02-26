package karn.interviews.guidewire.round3;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public String[] solution(String[] intervals) {
        // implement your solution here
        // sweep line algo
        // [0,+1,0,0,0....-1                    max(intervals)+1]

        // Approach 2
        // sorting nlog(n)
        // put first element in result
        // "1-2", "3-5", "4-6"
        Queue<Interval> heap = new PriorityQueue<>((a, b)->{
            if(a.start==b.start){
                return a.end - b.end;
            }
            return a.start-b.start;
        });
        for(String inter:intervals){
            String[] arr = inter.split("-");
            if(arr.length!=2){
                continue;
            }
            int start = Integer.parseInt(arr[0].trim());
            int end = Integer.parseInt(arr[1].trim());
            heap.add(new Interval(start, end));
        }
        List<Interval> res = new ArrayList<>();
        if(heap.isEmpty()){
            return null;
        }
        Interval last = heap.poll();
        res.add(last);

        while(!heap.isEmpty()){
            Interval next = heap.poll();
            if(next.start<=(last.end+1)){
                last.end = Math.max(last.end, next.end);
            }else{
                res.add(next);
                last = next;
            }

        }
        String[] result = new String[res.size()];
        int idx = 0;
        for(Interval intr:res){
            result[idx++] = intr.start+"-"+intr.end;
        }

        return result;
    }
    class Interval{
        int start;
        int end;
        Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}