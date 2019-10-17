import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int [] testArray = {0,8,7,7,5};
        int sizeArray = removeDuplicates(testArray);
        System.out.println(sizeArray);

    }


    static int removeDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(nums[0]);
        for (int i =1; i<nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                continue;
            }
            else {
                list.add(nums[i]);
            }
        }
        System.out.println(list);
        return list.size();
    }

}
