#include<stdio.h>
int main()
{
    int n,i;
    printf("Array size: ");
    scanf("%d",&n);
    int a[n];
    printf("Array elements: ");
    for(i=0; i<n; i++)
    {
        scanf("%d",&a[i]);
    }
    int pos,value;
    printf("Enter index : ");
    scanf("%d",&pos);
    printf("Enter new value: ");
    scanf("%d",&value);
    for(i=0; i<n; i++)
    {
        if(i==pos)
        {
            a[i]=value;
            break;
        }
    }

    printf("After updating: ");
    for(i=0; i<n; i++)
    {
        printf("%d ",a[i]);
    }
}
