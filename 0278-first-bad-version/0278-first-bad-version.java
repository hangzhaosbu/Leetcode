/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int R = n;
        int L = 1;
        while(L < R) {
            // (R + L) / 2 -> (R - L) / 2 + L;
            int mid = (R - L) / 2 + L;
            if(isBadVersion(mid)) R = mid;
            else L = mid + 1;
        }
        
        return L;
    }
}