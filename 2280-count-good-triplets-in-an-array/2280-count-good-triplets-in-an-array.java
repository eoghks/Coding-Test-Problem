class Solution {
    //nums2에서 나온 원소가 num1에 위치한 idx를 정렬해서 저장
    ArrayList<Integer> sortedList = new ArrayList<>();
    public long goodTriplets(int[] nums1, int[] nums2) {
        //nums1의 value와 index를 저장
        int n = nums1.length;
        long cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(nums1[i], i);
        }
        
        for(int x: nums2) {
            int idx = map.get(x);
            //idx 보다 더 작은 num1의 원소 수를 구함 단, nusm2에서 이미 나왓어야 하므로 sortedList에서 구한다.
            int left = orderOfKey(idx);
            //idx 보다 더 큰 idx를 구함
            //전체 원소 중 idx를 빼는 이유는 nums1에서 나오지 않은 원소의 수를 구하는 것이다.
            //sortedList에서 left를 빼는 이유는 nums2에서 이미 나온 수 중 nums1에서 idx보다 더 큰 idx를 가진 수를 찾는다.
            //따라서 nums1에서 아직 나오지 않은 원소의 갯수에서 nums2에서 이미 나온 원소의 수를 뺀 수가 된다.
            int right = (n-1-idx) -(sortedList.size()-left);
            cnt +=(long) left*right;
            sortedList.add(left, idx);
        }
        return cnt;
    }

    //binarySearch는 해당 원소가 없는 경우
    //음수값을 반환 이는 (-반환값-1)를 하면 해당 데이터를 삽입할 수 있는 위치가 나온다. 
    private int orderOfKey(int key) {
        int pos = Collections.binarySearch(sortedList, key);
        return pos<0? -pos-1: pos;
    }
}