package array

func subSort(array []int) []int {
	low := 9999
	high := -1
	lowPos := -1
	highPos := -1
	length := len(array)
	if nil != array || len(array) != 0 {
		for i, _ := range array {
			if low >= array[length-i-1] {
				low = array[length-i-1]
			} else {
				lowPos = length - i - 1
			}
			if high <= array[i] {
				high = array[i]
			} else {
				highPos = i
			}
		}
	}
	return []int{lowPos, highPos}
}
