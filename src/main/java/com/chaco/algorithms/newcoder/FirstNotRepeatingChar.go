package newcoder

func FirstNotRepeatingChar(str string) int {
	m := make(map[byte]int)
	for i := 0; i < len(str); i++ {
		m[str[i]] += 1
	}
	for i := 0; i < len(str); i++ {
		if 1 == m[str[i]] {
			return i
		}
	}
	return -1
}
