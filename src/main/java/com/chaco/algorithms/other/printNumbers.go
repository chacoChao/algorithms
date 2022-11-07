package other

func printNumbers(n int) []int {
	if 0 >= n || n > 5 {
		return nil
	}
	top := 0
	for c := 1; n > 0; n-- {
		top = (9 * c) + top
		c *= 10
	}
	res := make([]int, top)
	for i := 1; i <= top; i++ {
		res[i-1] = i
	}
	return res
}
