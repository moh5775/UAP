#include<stdio.h>
int main()
{
    int n,i;
    printf("Array size: ");
    scanf("%d",&n);
    int a[n];
    printf("Array elements: ");
    for(i=0;i<n;i++)
    {
        scanf("%d",&a[i]);
    }
    int pos,value;
    printf("Enter value you want to insert: ");
    scanf("%d",&value);
    printf("Enter index where you want to insert: ");
    scanf("%d",&pos);
    for(i=n-1;i>=pos;i--)
    {
        a[i+1]=a[i];
    }
    a[pos]=value;
    printf("After insertion: ");
    for(i=0;i<=n;i++)
    {
        printf("%d ",a[i]);
    }
}
