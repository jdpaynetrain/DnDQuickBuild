package QuickBuild;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class StatRoller {

    private int random_number(){
        return ThreadLocalRandom.current().nextInt(1, 7);
    }

    private  int sumList(List<Integer> stat){
        int sum = 0;
        for(int i = 0; i < stat.size(); i++)
            sum += stat.get(i);
        return sum;
    }

    private int findMax(int num1, int num2, int num3, int num4, int num5, int num6){
        int maxStat = Math.max(num1, num2);
        maxStat = Math.max(maxStat, num3);
        maxStat = Math.max(maxStat, num4);
        maxStat = Math.max(maxStat, num5);
        maxStat = Math.max(maxStat, num6);
        return maxStat;
    }

    public List<Integer> rollStats(){
        int totalSum = 0, sum1 = 0, sum2 = 0, sum3 = 0,
                sum4 = 0, sum5 = 0, sum6 = 0, maxStat = 0;
        List<Integer> stat1, stat2, stat3, stat4, stat5, stat6;
        while(totalSum < 70 || maxStat < 15){
            stat1 = new ArrayList<>(4);
            stat2 = new ArrayList<>(4);
            stat3 = new ArrayList<>(4);
            stat4 = new ArrayList<>(4);
            stat5 = new ArrayList<>(4);
            stat6 = new ArrayList<>(4);

            for(int i = 0; i < 4; i++){
                stat1.add(i, random_number());
                stat2.add(i, random_number());
                stat3.add(i, random_number());
                stat4.add(i, random_number());
                stat5.add(i, random_number());
                stat6.add(i, random_number());
            }

            Collections.sort(stat1);
            Collections.sort(stat2);
            Collections.sort(stat3);
            Collections.sort(stat4);
            Collections.sort(stat5);
            Collections.sort(stat6);

            Collections.reverse(stat1);
            Collections.reverse(stat2);
            Collections.reverse(stat3);
            Collections.reverse(stat4);
            Collections.reverse(stat5);
            Collections.reverse(stat6);

            stat1.remove(3);
            stat2.remove(3);
            stat3.remove(3);
            stat4.remove(3);
            stat5.remove(3);
            stat6.remove(3);


            sum1 = sumList(stat1);
            sum2 = sumList(stat2);
            sum3 = sumList(stat3);
            sum4 = sumList(stat4);
            sum5 = sumList(stat5);
            sum6 = sumList(stat6);

            totalSum = sum1 + sum2 + sum3 + sum4 + sum5 + sum6;
            maxStat = findMax(sum1, sum2, sum3, sum4, sum5, sum6);
        }
        List<Integer> rolledStats = new ArrayList<>();
        rolledStats.add(sum1);
        rolledStats.add(sum2);
        rolledStats.add(sum3);
        rolledStats.add(sum4);
        rolledStats.add(sum5);
        rolledStats.add(sum6);

        return rolledStats;
    }
}
