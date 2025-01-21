#include <stdio.h>

void main() {
    // 1.
    printf("Hi Mom!");
    // 2.
    int num = 7;
    float num1 = 3.7;
    double num2 = 0.373737;
    char num3 = "3.7";
    // 3.
    int nums[] = {1, 2 , 3, 4, 5};
    float nums1[] = {1.1, 2.2, 3.3, 4.4, 5.5};
    double nums2[] = {1.11, 2.22, 3.33, 4.44, 5.55};
    char nums3[] = {'1', '2', '3', '4', '5'};
    // 4.
    int* ptr = &num;
    float* ptr1 = &num1;
    double* ptr2 = &num2;
    char* ptr3 = &num3;
    // 5.
    char phrase[] = {"Hello this is programming in C"};
    char* ptr4 = &phrase[0];
    for (int i = 0; i < sizeof(phrase); i++) {
        printf("%p\n", ptr4);
        ptr4++;
    }
    // 6.

}