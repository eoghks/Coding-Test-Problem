class Solution {
    List<String> res = new ArrayList<>();
    Map<String, List<String>> ingredientsMap = new HashMap<>();
    Set<String> availableSupplies;
    Map<String, Integer> visited = new HashMap<>();
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        availableSupplies = new HashSet<>(Arrays.asList(supplies));

        for(int i=0; i<recipes.length; i++) {
            ingredientsMap.put(recipes[i], ingredients.get(i));
        }

        for(String recipe: recipes) {
            canMake(recipe);
        }
        return res;
    }

    private boolean canMake(String recipe) {
        //recpie가 서로 원하는 경우를 방지하기 위해
        //만들수 있는 경우 => 1, 만드는 도중 => 0, 못만드는 경우 => -1
         if (visited.containsKey(recipe)) {
            return visited.get(recipe) == 1;
        }

        //기본으로주는 재료에 포함되는지
        if (availableSupplies.contains(recipe)) {
            return true;
        }

        //recpies에 포함되는지
        if (ingredientsMap.containsKey(recipe) == false) {
            return false;
        }

        visited.put(recipe, 0);

         for (String ingredient : ingredientsMap.get(recipe)) {
            if (canMake(ingredient) == false) {
                visited.put(recipe, -1);
                return false;
            }
        }

        visited.put(recipe, 1);
        res.add(recipe);
        return true;
    }
}