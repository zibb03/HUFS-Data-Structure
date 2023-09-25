// 여기에 binsearch 메소드를 작성하시오.
public static int binsearch(int[] a, int key, int left, int right) {
    int mid;
    
    while (left <= right) {
        mid = (left + right) / 2;
        
        if (key == a[mid]) {
            return mid;
        }
        else if (key < mid) {
            right = mid - 1;
        }
        else {
            left = mid + 1;
        }
    }

    return -1;
}