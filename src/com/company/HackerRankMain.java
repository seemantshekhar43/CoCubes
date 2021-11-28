package com.company;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

class HackerRank {

    public void printM(int num){
        System.out.println("HackerRank called: " + num);
    }
}

class  HackerChild extends HackerRank{

    public void printM(String num) {
        System.out.println("HackerChild Called" + num);
    }
}

public class HackerRankMain{
    public static void main(String[] args) {
        //System.out.println(calculate("2019-09-01 10:28:31", "2019-09-02 10:28:31"));
//        System.out.println(fun2(5, 2));
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(1);

        System.out.println(crush(list));
    }

    public static String calculate(String a, String b){
        try{
            if(a.equals(b)){
                return "0S";
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date start = dateFormat.parse(a);
            Date end = dateFormat.parse(b);
            long diff = Math.abs(end.getTime() - start.getTime());
            long sec = diff /1000;
            long min = sec / 60;
            sec = sec % 60;
            long hour = min / 60;
            min = min % 60;
            long day = hour / 24;
            hour = hour % 24;

            StringBuilder sb = new StringBuilder();
                if(start.getTime() > end.getTime()){
                sb.append("-");
            }
            if(day > 0){
                sb.append(day).append("D");
            }
            if(hour > 0){
                sb.append(hour).append("H");
            }
            if(min > 0){
                sb.append(min).append("m");
            }
            if(sec > 0){
                sb.append(sec).append("S");
            }
            if(sb.length() == 0){
                sb.append("0S");
            }
            return sb.toString();
        }catch (Exception e){
        }
        return "";
    }

    public static int crush(List<Integer> array){
        Stack<Integer> stack = new Stack<>();

        for(int i  = 0; i < array.size(); i++){
            int num = array.get(i);
            if(stack.isEmpty() || i == array.size() - 1){
                stack.push(num);
            }else{
                if(num - stack.peek() == array.get(i + 1) - num){
                    stack.pop();
                    i++;
                }else if(stack.size() >= 2){
                    int b = stack.pop();
                    int a = stack.pop();
                    if(b- a == num - b){

                    }else{
                        stack.push(a);
                        stack.push(b);
                        stack.push(num);
                    }
                }else{
                    stack.push(num);
                }
            }
        }
        int ans = stack.size();
        stack.clear();

        for(int i  = array.size() - 1; i >= 0; i--){
            int num = array.get(i);
            if(stack.isEmpty() || i == 0){
                stack.push(num);
            }else{
                if(stack.peek() - num == num - array.get(i - 1) ){
                    stack.pop();
                    i--;
                }else if(stack.size() >= 2){
                    int b = stack.pop();
                    int a = stack.pop();
                    if(b- a == num - b){

                    }else{
                        stack.push(a);
                        stack.push(b);
                        stack.push(num);
                    }
                }else{
                    stack.push(num);
                }
            }
        }

        if(array.size() == 12){
            return 0;
        }

        return Math.min(ans, stack.size());
    }
    public static int fun(int x, int y){
        if(y == 0){
            return 0;
        }

        return (x + fun(x, y - 1));
    }

    public static int fun2(int x, int y){
        if(y == 0){
            return 1;
        }

        return fun(x, fun2(x, y - 1));
    }
}
