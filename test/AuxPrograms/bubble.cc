// 1  for i = 1 to n-1 do
// 2     for j = n downto i + 1 do
// 3        if A[j-1] > A[j] then begin
// 4           temp = A[j-1]
// 5           A[j-1] = A[j]
// 6           A[j] = temp
// 7        end
// 8     end
// 9  end
#include <stdio.h>
#include <iostream>

void bubble_sort(int A[], int n) {
  for (int i = 0; i < n - 1; i++) {
    for (int j = n - 1; j > i; j--) {
      std::cout << " j: " << j << std::endl;
      if (A[j - 1] > A[j]) {
        int temp = A[j - 1];
        A[j - 1] = A[j];
        A[j] = temp;
      }
    }
  }
}

int main() {
  int A[] = {87, 12, 45, 67, 23, 98, 34, 56, 78, 10};
  bubble_sort(A, 10);
  for (int i = 0; i < 10; i++) {
    printf("%d ", A[i]);
  }
  printf("\n");
  return 0;
}