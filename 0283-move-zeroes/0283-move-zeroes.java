class Solution {
    public void moveZeroes(int[] nums) {
        int insertPo=0;

        for(int num:nums){
            if(num!=0){
                nums[insertPo++]=num;
            }
        }
        while(insertPo<nums.length){
            nums[insertPo++]=0;
        }
        
    }
}