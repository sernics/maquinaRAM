// 1 for j = 2 to n do
// 2    key = A[j]
// 3    i = j - 1
// 4    while i > 0 and A[i] > key
// 5       A[i + 1] = A[i]
// 6       i = i - 1
// 7    end
// 8    A[i + 1] = key
// 9 end

#include <stdio.h>
#include <iostream>

void insertion_sort(int A[], int n) {
  for (int j = 1; j < n; j++) {
    // std::cout << "j: " << j << std::endl;
    int key = A[j];
    int i = j - 1;
    while (i >= 0 && A[i] > key) {
      std::cout << "i: " << i << " A[i]: " << A[i] << " key: " << key << std::endl;
      A[i + 1] = A[i];
      i--;
    }
    A[i + 1] = key;
  }
}

int main() {
  int A[] = {87, 12, 45, 67, 23, 98, 34, 56, 78, 10};
  
  insertion_sort(A, 10);
  for (int i = 0; i < 10; i++) {
    printf("%d ", A[i]);
  }
  printf("\n");
  return 0;
}