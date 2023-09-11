class Solution {
    public List<List<Integer>> groupThePeople(int[] gz) {
      List<List<Integer>> res = new ArrayList();
      Map<Integer, List<Integer>> groups = new HashMap<>();
      for (int i = 0; i < gz.length; ++i) {
        List<Integer> list = groups.computeIfAbsent(gz[i], k -> new ArrayList());
        list.add(i);
        if (list.size() == gz[i]) {
          res.add(list);
          groups.put(gz[i], new ArrayList());
        }
      }
      return res;
    }
}