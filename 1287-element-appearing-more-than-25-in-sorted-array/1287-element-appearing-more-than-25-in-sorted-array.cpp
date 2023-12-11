class Solution {
public:
	int findSpecialInteger(vector<int>& arr) {
		for(int i = 0; i <= (arr.size() * 3) / 4; i++){
			if(arr[i] == arr[i + arr.size() / 4]){
				return arr[i];
			}
		}
		return arr[0];
	}
};