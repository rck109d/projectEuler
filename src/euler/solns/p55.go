package euler

import (
	"fmt"
	"math/big"
	"strings"
)

type lychrel struct {
	bigInt    *big.Int
	iterCount int
}

func makeLychrel(n int64) *lychrel {
	return &lychrel{
		bigInt: big.NewInt(n),
	}
}

func (n lychrel) String() string {
	return n.bigInt.String()
}

func (n*lychrel) foldAndAdd() {
	var rev big.Int
	rev.SetString(reverse(n.bigInt.String()), 10)
	n.bigInt.Add(n.bigInt, &rev)
}

func (n*lychrel) test(maxIter int) (bool, int) {
	iter := 0
	foundPalindrome := false
	for iter < maxIter {
		iter++
		n.foldAndAdd()
		foundPalindrome = isPalindrome(n.bigInt.String())
		if foundPalindrome {
			return false, iter
		}
	}
	return true, iter
}

func reverse(s string) string {
	r := []rune(s)
	for i, j := 0, len(r) - 1; i < len(r) / 2; i, j = i + 1, j - 1 {
		r[i], r[j] = r[j], r[i]
	}
	return string(r)
}

func isPalindrome(s string) bool {
	return strings.Compare(s, reverse(s)) == 0
}

func P55() {
	hits := 0
	for i := 0; i < 10000; i++ {
		pass, numIter := makeLychrel(int64(i)).test(50)
		if pass {
			hits++
			fmt.Println(i, numIter)
		}
	}
	fmt.Println("num hits:", hits)
}
