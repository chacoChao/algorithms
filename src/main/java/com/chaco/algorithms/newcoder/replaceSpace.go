package nowcoder

import "strings"

func replaceSpace(s string) string {
	replaceStr := "%20"
	sb := strings.Builder{}
	for i := 0; i < len(s); i++ {
		if ' ' == s[i] {
			sb.WriteString(replaceStr)
		} else {
			sb.WriteString(s[i : i+1])
		}
	}
	return sb.String()
}
