package leetcode

func evaluate(s string, knowledge [][]string) string {
	dict := map[string]string{}
	for _, kv := range knowledge {
		dict[kv[0]] = kv[1]
	}
	res := []byte{}
	key := []byte{}
	keyCount := 0
	for i := 0; i < len(s); i++ {
		switch s[i] {
		case '(':
			keyCount++
		case ')':
			keyCount--
			if word, ok := dict[string(key)]; ok {
				res = append(res, []byte(word)...)
				key = []byte{}
			} else {
				res = append(res, byte('?'))
				key = []byte{}
			}
		default:
			if keyCount > 0 {
				key = append(key, s[i])
			} else {
				res = append(res, s[i])
			}
		}
	}
	return string(res)
}
