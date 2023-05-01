#Next Permutation : Find next lexicographically greater permutation

**Problem Statement**
***
Given an array Arr[] of integers, rearrange the numbers of the given array into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange to the lowest possible order (i.e., sorted in ascending order).

**Example 1:**
```aidl
Input format: Arr[] = {1,3,2}

Output: Arr[] = {2,1,3}

Explanation: All permutations of {1,2,3} are {{1,2,3} , {1,3,2}, {2,13} , {2,3,1} , {3,1,2} , 
{3,2,1}}. So, the next permutation just after {1,3,2} is {2,1,3}.
```

**Example 2:**
```aidl
Input format: Arr[] = {3,2,1}

Output: Arr[] = {1,2,3}

Explanation: As we see all permutations of {1,2,3}, we find {3,2,1} at the last position. 
So, we have to return the topmost permutation.
```

###Solution

**Brute Force**

1. Find all possible permutations of elements present and store them.
2. Search input from all possible permutations.
3. Print the next permutation present right after it.

_Time Complexity_ :

For finding, all possible permutations, it is taking *N!xN*. 
N represents the number of elements present in the input array. Also for searching input arrays from all possible permutations will take N!. Therefore, it has a Time complexity of O(N!xN).

_Space Complexity_ :

Since we are not using any extra spaces except stack spaces for recursion calls. 
So, it has a space complexity of **O(1)**.

**Solution 2**

**Find the break-point, i:** Break-point means the first index i from the back of the given array where arr[i] becomes smaller than arr[i+1].
For example, if the given array is {2,1,5,4,3,0,0}, the break-point will be index 1(0-based indexing). Here from the back of the array, index 1 is the first index where arr[1] i.e. 1 is smaller than arr[i+1] i.e. 5.
To find the break-point, using a loop we will traverse the array backward and store the index i where arr[i] is less than the value at index (i+1) i.e. arr[i+1].
If such a break-point does not exist i.e. if the array is sorted in decreasing order, the given permutation is the last one in the sorted order of all possible permutations. So, the next permutation must be the first i.e. the permutation in increasing order.
So, in this case, we will reverse the whole array and will return it as our answer.
If a break-point exists:
**Find the smallest number** i.e. > arr[i] and in the right half of index i(i.e. from index i+1 to n-1) and swap it with arr[i].
Reverse the entire right half(i.e. from index i+1 to n-1) of index i. And finally, return the array.
**Note:** For a better understanding of intuition, please watch the video at the bottom of the page.

Intuition:

We build up the intuition of the algorithm through the following observations.

**Observation 1:**
Let’s try to observe some dictionary-ordered strings like “raj”, “rax”, and “rbx”. If we carefully observe, we can notice that these strings contain a common prefix, and the rankings are done based on the differentiating characters.

For example, “raj” and “rax” has a common prefix i.e. “ra” and the differentiating characters are ‘j’ and ‘x’. Now, as ‘j’ appears before ‘x’ in the alphabet, “raj” appears before “rax” in the given order. The same logic is applicable for “rax” and “rbx”(Common prefix: “r”, differentiating characters: ‘a’ and ‘b’).

The same observation can be done on the permutations of numbers. For example, if the array is [1, 2, 3], all possible permutations in sorted order will look like the following:
```aidl
[1, 2, 3]
[1, 3, 2]
[2, 1, 3]
[2, 3, 1]
[3, 1, 2]
[3, 2, 1]
```
In the above cases, we can also notice that all the permutations contain an index i(between the first and second last index) such that its right part is sorted in decreasing order. Now, if we look at the array in the backward direction, it is sorted in increasing order up to index i (from n-1 to index i+1).

We can call this index i as the break-point of the array. The left half of index i (the length of the left half might be 0) in the current permutation is the same as in the previous permutation. And the right half of the break-point is always in decreasing order.

The structure of every possible permutation is the following:



