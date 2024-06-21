package DSA.other;

//https://leetcode.com/problems/product-of-array-except-self
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];

        ans[0] = 1; //this ideally should have been zero as there is no element in the LHS of the first element
        // but it is kept as 1 else if it is zero then all further values in answerArr will become zero as (anyNum*0 = 0)
        //it will anyway be updated with the proper value before returning ans[] as the final answer
        //it will anyway be updated with the proper value before returning ans[] as the final answer
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1]; //ans[i] contains product of all the elements to the LHS of nums[i];
        }

        int rightProduct = 1; //as there is nothing on the RHS of nums[nums.length - 1]
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = ans[i] * rightProduct; //here ans[i] contains (leftProduct * rightProduct) excluding num[i]
            rightProduct *= nums[i]; //this is because we have to include num[i] which was excluded in above step for rightProduct of lefter element
        }

        return ans;
    }

    //TC: O(N)
    //SC: O(1) [excluding answer array]
}
