package dp

import "math"

func maxValue(grid [][]int) int {
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {
			if 0 == i && 0 == j {
				continue
			} else if 0 == i {
				grid[i][j] += grid[i][j-1]
			} else if 0 == j {
				grid[i][j] += grid[i-1][j]
			} else {
				grid[i][j] += int(math.Max(float64(grid[i-1][j]), float64(grid[i][j-1])))
			}
		}
	}
	return grid[len(grid)-1][len(grid[0])-1]
}
