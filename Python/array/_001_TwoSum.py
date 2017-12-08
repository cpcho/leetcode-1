class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        k = 0
        for i in nums:
            j = target - i
            k += 1
            tmpNums = nums[k:]
            if j in tmpNums:
                return [k - 1, tmpNums.index(j) + k]