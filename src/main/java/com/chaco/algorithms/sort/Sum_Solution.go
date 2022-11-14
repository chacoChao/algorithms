package sort

func Sum_Solution(n int) int {
	if 0 == n {
		return 0
	}
	c := 0
	c += n
	return c + Sum_Solution(n-1)
}
