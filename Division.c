#include <stdio.h>

int main() {
    int a, b, Division;

    printf("Enter two numbers: ");
    scanf("%d %d", &a, &b);
    Division = a /b;

    printf("Division = %d", Division);

    return 0;
}