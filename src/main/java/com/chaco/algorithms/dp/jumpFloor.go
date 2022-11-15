package dp

func jumpFloor(number int) int {
	var (
		p = 0
		q = 0
		r = 1
	)
	for i := 1; i <= number; i++ {
		p = q
		q = r
		r = p + q
	}
	return r
}
