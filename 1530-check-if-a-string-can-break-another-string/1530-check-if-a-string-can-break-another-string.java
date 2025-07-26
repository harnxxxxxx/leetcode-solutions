import java.util.Arrays;
class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] arr1=s1.toCharArray();
        char[] arr2=s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        boolean s1Breakss2=true;
        boolean s2Breakss1=true;

    for(int i=0;i<arr1.length;i++){
        if(arr1[i]<arr2[i]){
            s1Breakss2=false;
        }
        if(arr2[i]<arr1[i]){
            s2Breakss1=false;
        }
    }
        return s1Breakss2 || s2Breakss1;
        
    }
}