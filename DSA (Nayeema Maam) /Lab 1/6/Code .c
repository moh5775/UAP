#include<stdio.h>
int main()
{
    int n,i,m;
    printf("Array size: ");
    scanf("%d",&n);
    int c[n],a[n/2],b[n-n/2];

    printf("size of array 1: %d \nSize of array 2: %d\n",n/2,n-n/2);


    printf("Enter Array elements: ");
    for(i=0; i<n; i++)
    {
        scanf("%d",&c[i]);
    }

    for(i=0; i<(n/2); i++)
    {
        a[i]=c[i];
    }
    printf("Splitted Array 1: ");
    for(i=0; i<(n/2); i++)
    {
        printf("%d ",a[i]);
    }

    for(i=0; i<(n-(n/2)); i++)
    {
        b[i]=c[i+(n/2)];
    }
    printf("\nSplitted Array 2: ");
    for(i=0; i<(n-(n/2)); i++)
    {
        printf("%d ",b[i]);
    }


}
