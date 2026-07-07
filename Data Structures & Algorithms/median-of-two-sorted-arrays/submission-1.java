class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a = nums1;
        int[] b = nums2;

        if (b.length < a.length) {
            int[] temp = b;
            b = a;
            a = temp;
        }

        int total = a.length + b.length;
        int half = (total + 1) / 2;

        int l = 0;
        int r = a.length;
        while (l <= r) {
            int i = l + (r - l) / 2;
            int j = half - i;

            int aLeft = i == 0 ? Integer.MIN_VALUE : a[i - 1];
            int aRight = i == a.length ? Integer.MAX_VALUE : a[i];
            int bLeft = j == 0 ? Integer.MIN_VALUE : b[j - 1];
            int bRight = j == b.length ? Integer.MAX_VALUE : b[j];

            if (aLeft <= bRight && bLeft <= aRight) {
                if (total % 2 != 0) {
                    return Math.max(aLeft, bLeft);
                } else {
                    return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2.0;
                }
            } else if (aLeft > bRight) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }

        return -1;
    }
}
