package array

func replaceElements(arr []int) []int {
	if nil == arr || len(arr) == 0 {
		return []int{-1}
	}
	for i := 0; i < len(arr); i++ {
		if i == len(arr) {
			arr[i] = -1
			break
		}
		arr[i] = getMax(arr[i+1 : len(arr)])
	}
	return arr
}

func getMax(arr []int) int {
	tmp := -1
	for _, i := range arr {
		if tmp < i {
			tmp = i
		}
	}
	return tmp
}
