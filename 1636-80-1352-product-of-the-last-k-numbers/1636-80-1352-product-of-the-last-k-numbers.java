class ProductOfNumbers {
    List<Integer> product = new ArrayList<>();
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