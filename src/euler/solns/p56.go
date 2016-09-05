package euler

import (
	"fmt"
	"math/big"
)

func P56() {
	const abLimit = 100
	maxDigitSum := 0
	for a := 2; a < abLimit; a++ {
		for b := 1; b < abLimit; b++ {
			x := big.NewInt(int64(a))
			product := big.NewInt(int64(a))
			for i := 1; i < b; i++ {
				product.Mul(product, x)
			}
			digitSum := 0
			for _, char := range product.String() {
				digitSum += int(char - '0')
			}
			if digitSum > maxDigitSum {
				maxDigitSum = digitSum
			}
		}
	}
	fmt.Println("p56:", maxDigitSum)
}
