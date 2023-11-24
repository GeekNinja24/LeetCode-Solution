class Solution {
public int maxCoins(int[] piles) {
Arrays.sort(piles);
int n = piles.length/3;
int sum = 0; int i = piles.length-2;
while(n-->0){
sum += piles[i];
i -=2;
}
return sum;
}
}