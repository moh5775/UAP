#include<stdio.h>
#include<stdlib.h>
struct node
{
    int data;
    struct node *next;
};

struct node *head=NULL;

int main()
{
    while(1)
    {
        printf("\n1: Insert\n2: Display\n");
        int option;
        printf("Enter option: ");
        scanf("%d",&option);

        switch(option)
        {
        case 1:
            insert();
            break;
        case 2:
            display();
            break;
        }
    }
}

void insert()
{
    struct node *new;
    int item;
    new = malloc(sizeof(struct node *));
    printf("\nEnter value\n");
    scanf("%d",&item);
    new->data = item;
    new->next = head;
    head = new;
    printf("\nNode inserted");

}

void display()
{
    struct node *ptr;
    ptr = head;


    printf("\nprinting values . . . . .\n");
    while (ptr!=NULL)
    {
        printf("%d ",ptr->data);
        ptr = ptr -> next;
    }

}
