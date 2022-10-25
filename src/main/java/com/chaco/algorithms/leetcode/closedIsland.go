package leetcode

func closedIsland(grid [][]int) int {
	res := 0
	m := len(grid)
	n := len(grid[0])
	for i := 0; i < m; i++ {
		dfs1(grid, i, 0)
		dfs1(grid, i, n-1)
	}
	for j := 0; j < n; j++ {
		dfs1(grid, 0, j)
		dfs1(grid, m-1, j)
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if 0 == grid[i][j] {
				res++
				dfs1(grid, i, j)
			}
		}
	}
	return res
}

func dfs1(grid [][]int, i int, j int) {
	m := len(grid)
	n := len(grid[0])
	if i < 0 || j < 0 || i >= m || j >= n {
		return
	}
	if 1 == grid[i][j] {
		return
	}
	grid[i][j] = 1
	dfs1(grid, i+1, j)
	dfs1(grid, i, j+1)
	dfs1(grid, i-1, j)
	dfs1(grid, i, j-1)
}
