# 1. Set Matrix Zero

**Problem Statement**
***
Given a matrix if an element in the matrix is 0 then you will have to set its entire column and row to 0 and then return the matrix.
```sh
Examples 1:

Input: matrix=[[1,1,1],[1,0,1],[1,1,1]]

Output: [[1,0,1],[0,0,0],[1,0,1]]

Explanation: Since matrix[2][2]=0.
Therfore the 2nd column and 2nd row wil be set to 0.
 
Input: matrix=[[0,1,2,0],[3,4,5,2],[1,3,1,5]]

Output:[[0,0,0,0],[0,4,5,0],[0,3,1,0]]

Explanation:Since matrix[0][0]=0 and matrix[0][3]=0. 
Therefore 1st row, 1st column and 4th column will be set to 0
```

**Solution:**
###Naive Approach (Brute-force approach) 
1. First, we will use two loops(nested loops) to traverse all the cells of the matrix.
2. If any cell (i,j) contains the value 0, we will mark all cells in row i and column j with -1 except those which contain 0.
3. We will perform step 2 for every cell containing 0.
4. Finally, we will mark all the cells containing -1 with 0.
5. Thus the given matrix will be modified according to the question.

**Note:** Here, we are assuming that the matrix does not contain any negative numbers. 
But if it contains negatives, we need to find some other ways to mark the cells instead of marking them with -1.

###Better Approach (Using two extra arrays)
1. First, we will declare two arrays: a row array of size N and a col array of size M and both are initialized with 0.
2. Then, we will use two loops(nested loops) to traverse all the cells of the matrix.
3. If any cell (i,j) contains the value 0, we will mark ith index of row array i.e. row[i] and jth index of col array col[j] as 1. 
It signifies that all the elements in the ith row and jth column will be 0 in the final matrix.
4. We will perform step 3 for every cell containing 0.
5. Finally, we will again traverse the entire matrix and we will put 0 into all the cells (i, j) for which either row[i] 
or col[j] is marked as 1.
6. Thus, we will get our final matrix.

###Optimal Approach (without using any extra space): 
![](../../images/Screenshot-2023-04-04-001419.webp)
1. First, we will traverse the matrix and mark the proper cells of 1st row and 1st column with 0 accordingly. The marking will be like this: if cell(i, j) contains 0, we will mark the i-th row i.e. matrix[i][0] with 0 and we will mark j-th column i.e. matrix[0][j] with 0.
If i is 0, we will mark matrix[0][0] with 0 but if j is 0, we will mark the col0 variable with 0 instead of marking matrix[0][0] again.
2. After step 1 is completed, we will modify the cells from (1,1) to (n-1, m-1) using the values from the 1st row, 1st column, and col0 variable.
We will not modify the 1st row and 1st column of the matrix here as the modification of the rest of the matrix(i.e. From (1,1) to (n-1, m-1)) is dependent on that row and column.
3. Finally, we will change the 1st row and column using the values from matrix[0][0] and col0 variable. Here also we will change the row first and then the column.
If matrix[0][0] = 0, we will change all the elements from the cell (0,1) to (0, m-1), to 0.
If col0 = 0, we will change all the elements from the cell (0,0) to (n-1, 0), to 0.

**Observations:** Why in the second step, we are first marking the matrix from the cell (1,1) to (n-1, m-1) and not from (0,0):
Let’s understand this using the following example:
Given matrix:


Now, we will try to apply step 1 in the above matrix, col0 will be 0 as (3,0) contains 0 and it will look like the following:


Now, in the second step we will try to start modifying the cells with value 0 from (0,0). First, we will change the value of (0,0) to 0 as col0 is marked with 0. After that, while checking for cell (0, 3) we will find that the value of (0,0) is 0. And we will again modify the cell (0,3) with 0. But this should not happen as (0,0) was initially 1 and that is why (0,3) should remain with the value 1.
This is why we cannot change the 1st row and 1st column on the first go as the rest of the matrix is dependent on them. If we do it, the modification of the matrix will be incorrect.

In the 3rd step, why we are marking the 1st row first and then the 1st column:
We can notice that the modification of the 1st row is dependent on matrix[0][0] and the modification of the 1st column is dependent on col0 which is an independent variable. Now, if we modify the 1st column first, matrix[0][0] might be changed and this will hinder the modification of the 1st row as well. But if we simply do the opposite, the 1st row will be changed first, based on the value matrix[0][0] and then the 1st column will be changed based on the variable col0. This is why the order of change matters.
