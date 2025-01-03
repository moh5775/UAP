#include<stdio.h>
#include<stdlib.h>
struct node
{
    int data;
    struct node *next;
};
struct node *head=NULL;
void beginsert()
{
    struct node *ptr;
    int item;
    ptr = malloc(sizeof(struct node *));
    printf("\nEnter value\n");
    scanf("%d",&item);
    ptr->data = item;
    ptr->next = head;
    head = ptr;
    printf("\nNode inserted");


}
void end_insert()
{
    struct node *new=malloc(sizeof(struct node));
    int item;
    printf("Enter data: ");
    scanf("%d",&item);
    new->data=item;
    new->next=NULL;
    if(head==NULL)
    {
        head=new;
    }
    else
    {
        struct node *ptr=malloc(sizeof(struct node));
        ptr=head;
        while(ptr->next!=NULL)
        {
            ptr=ptr->next;
        }
        ptr->next=new;
    }
}

void mid_insert()
{
    int pos;
    printf("Position: ");
    scanf("%d",&pos);
    struct node *new=malloc(sizeof(struct node));
    int item;
    printf("Enter data: ");
    scanf("%d",&item);
    new->data=item;
    new->next=NULL;
    if(head==NULL)
    {
        head=new;
    }

    struct node *ptr=malloc(sizeof(struct node));
    ptr=head;
    for(int i=1; i<=pos-1; i++)
    {
        ptr=ptr->next;
    }
    new->next=ptr->next;
    ptr->next=new;

}


void beg_del()
{
    struct node *new;
    new=head;
    head=head->next;
    free(new);
}
void end_del()
{
    struct node *ptr=head;
    struct node *temp;

    while(ptr->next!=NULL)
    {
        temp=ptr;
        ptr=ptr->next;
    }
    temp->next=NULL;
    free(ptr);

}

void mid_del()
{
    struct node *ptr;
    struct node *temp;
    ptr = head;
    int pos;
    printf("Position: ");
    scanf("%d",&pos);
    for(int i=1; i<=pos-1; i++)
    {
        temp=ptr;
        ptr=ptr->next;
    }
    temp->next=ptr->next;
    free(ptr);

}

void count_node()
{
    struct node *ptr;
    ptr = head;
    int count=0;
    while (ptr!=NULL)
    {
        count++;
        ptr = ptr -> next;
    }
    printf("%d",count);
}

void search_by_value()
{
    int value;
    printf("Value: ");
    scanf("%d",&value);
    struct node *ptr;
    ptr = head;
    for(int i=1;ptr->next!=NULL;i++)
    {

        if(ptr->data==value)
        {
            printf("Found at position : %d",i);
            break;
        }
         ptr=ptr->next;
    }
}
void display()
{
    struct node *ptr;
    ptr = head;


    printf("\nprinting values . . . . .\n");
    while (ptr!=NULL)
    {
        printf("%d-> ",ptr->data);
        ptr = ptr -> next;
    }


}


void main ()
{
    int choice =0;
    while(1)
    {
        printf("\n\n*********Main Menu*********\n");
        printf("\nChoose one option from the following list ...\n");
        printf("\n===============================================\n");
        printf("\n1.Insert in beginning\n2: Insert at end\n3: Insert at middle\n");
        printf("4.Delete from beginning\n5: Delete from end\n6: Delete from middle\n7: count node\n8: Search a node by value\n9.Show\n0.Exit\n");
        printf("\nEnter your choice?\n");
        scanf("\n%d",&choice);
        switch(choice)
        {
        case 1:
            beginsert();
            break;
        case 2:
            end_insert();
            break;
        case 3:
            mid_insert();
            break;



        case 4:
            beg_del();
            break;
        case 5:
            end_del();
            break;
        case 6:
            mid_del();
            break;
        case 7:
            count_node();
            break;
        case 8:
            search_by_value();
            break;
        case 9:
            display();
            break;
        case 0:
            exit(0);
            break;
        default:
            printf("Please enter valid choice..");
        }
    }
}

