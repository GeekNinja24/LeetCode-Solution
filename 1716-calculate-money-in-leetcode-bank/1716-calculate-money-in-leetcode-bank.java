class Solution {
    public int totalMoney(int n) {
        int totalMoney = 0;
        int monday = 0;
        int today = 0;
        for(int i = 0; i < n; i++){
            if(i % 7 == 0){
                monday++;
                today = monday;
            }
            totalMoney += today;
            today++;
        } 
        return totalMoney;
    }
}