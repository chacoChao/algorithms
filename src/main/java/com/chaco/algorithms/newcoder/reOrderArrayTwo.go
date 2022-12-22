package newcoder

func reOrderArrayTwo(array []int) []int {
	i := 0
	j := len(array) - 1
	for i < j {
		if array[i]%2 == 1 {
			i++
			continue
		}
		if array[j]%2 == 0 {
			j--
			continue
		}
		tmp := array[i]
		array[i] = array[j]
		array[j] = tmp
	}
	return array
}
