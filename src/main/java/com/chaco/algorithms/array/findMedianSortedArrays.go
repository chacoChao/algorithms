package array

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	var (
		l1            = len(nums1)
		l2            = len(nums2)
		isTwo         = (l1+l2)%2 == 0
		lMid          = (l1 + l2) / 2
		i             = 0
		j             = 0
		positionCusor = 0
		arr           = make([]int, l1+l2)
	)
	//数组为空处理
	if 0 == l1 {
		if isTwo {
			return float64((nums2[lMid] + nums2[lMid-1])) / 2
		} else {
			return float64(nums2[lMid])
		}
	}
	if 0 == l2 {
		if isTwo {
			return float64((nums1[lMid] + nums1[lMid-1])) / 2
		} else {
			return float64(nums1[lMid])
		}
	}

	for true {
		if lMid < positionCusor-1 || (j >= l2 && i >= l1) {
			break
		}
		if j >= l2 {
			arr[positionCusor] = nums1[i]
			positionCusor++
			i++
			continue
		}
		if i >= l1 {
			arr[positionCusor] = nums2[j]
			positionCusor++
			j++
			continue
		}
		if nums1[i] >= nums2[j] {
			arr[positionCusor] = nums2[j]
			j++
		} else if nums1[i] < nums2[j] {
			arr[positionCusor] = nums1[i]
			i++
		}
		positionCusor++
	}
	if isTwo {
		return float64(arr[lMid]+arr[lMid-1]) / 2
	} else {
		return float64(arr[lMid])
	}
}
