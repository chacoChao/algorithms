package array
/**
 * @link https://leetcode.cn/problems/pascals-triangle/
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * example:
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * <p>
 * example:
 * 输入: numRows = 1x
 * 输出: [[1]]
 */

func genrator(numRows int) [][]int {
res := make([][]int, numRows)
for i := 0; i < numRows; i++ {
	res[i] = make([]int, i+1)
	for j := 0; j <= i; j++ {
		if j ==0 || j==i {
			res[i][j] = 1
		} else {
			res[i][j] = res[i-1][j-1]+res[i-1][j]
		}
	}
}
return res
}