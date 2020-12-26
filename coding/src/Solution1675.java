import java.util.TreeSet;

public class Solution1675 {
    public static void main(String[] args){
        int[] nums = {4,1,5,20,3};
        System.out.println(minimumDeviation(nums));
    }


    private static int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        //通过将奇数乘以2，将整个数组装换为纯偶数
        for(int num : nums){
            set.add(num % 2 == 0 ? num : num * 2);
        }

        int res = set.last() - set.first();
        //注意边界条件
        while(res > 0 && set.last() % 2 == 0){
            //更新最大值
            int max = set.last();
            set.remove(max);
            set.add(max/2);
            //将更新后的最大值和最小值，进行比较
            res = Math.min(res, set.last() - set.first());
        }
        return res;
    }
}
