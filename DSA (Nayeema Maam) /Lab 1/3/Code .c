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
    int pos;
    printf("Enter index from where you want to delete: ");
    scanf("%d",&pos);
    for(i=pos;i<=n-1;i++)
    {
        a[i]=a[i+1];
    }

    printf("After deletion: ");
    for(i=0;i<n-1;i++)
    {
        printf("%d ",a[i]);
    }
}
