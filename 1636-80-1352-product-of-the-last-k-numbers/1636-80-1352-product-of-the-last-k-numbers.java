class ProductOfNumbers {
    List<Integer> product = new ArrayList<>();
    //product기 때문에 기본 값을 1로 설정
    //prdouct(i) = product(i-1) * nums[i];
    public ProductOfNumbers() {
        product.add(1);
    }
    
    public void add(int num) {
        //0이 등장하면 현재 크기까지는 모두 0이되기 때문에 의미가 없다.
        if(num == 0) {
            product = new ArrayList<>();
            product.add(1);
        } else {
            product.add(product.get(product.size()-1) * num);
        }
    }
    
    public int getProduct(int k) {
        //size()-1인 이유는 기본값 1이 존재하기 때문
        //그 이하의 값은 0이 포함되기 때문에 항상 0
        if(k>product.size()-1) {
            return 0;
        }
        return product.get(product.size()-1)/product.get(product.size()-1-k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */