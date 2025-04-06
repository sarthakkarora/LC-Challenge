#include <vector>
#include <climits>

using namespace std;

class Solution {
public:
    int minimumPairRemoval(vector<int>& nums) {
        int operations = 0;
        int n = nums.size();
        
        while (true) {
            if (isNonDecreasing(nums)) {
                break;
            }
            
            int minSum = INT_MAX;
            int minIndex = -1;
            
            for (int i = 0; i < n - 1; ++i) {
                int currentSum = nums[i] + nums[i + 1];
                if (currentSum < minSum) {
                    minSum = currentSum;
                    minIndex = i;
                }
            }
            
            nums[minIndex] = minSum;
            nums.erase(nums.begin() + minIndex + 1);
            n--;
            operations++;
        }
        
        return operations;
    }
    
private:
    bool isNonDecreasing(const vector<int>& arr) {
        for (int i = 0; i < arr.size() - 1; ++i) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
};