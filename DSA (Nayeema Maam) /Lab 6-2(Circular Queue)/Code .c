

#include <stdio.h>

int main()
{
    int n;
    printf("n: ");
    scanf("%d", &n);
    int queue[n];
    int rear = -1, front = -1;

    while(1)
    {
        printf("\n\nType..\n1 to enqueue\n2 to dequeue\n3 to check if the queue is empty\n4 to check if the queue is full\n0 to exit\n");
        int option;
        scanf("%d", &option);

        if(option == 1)
        {
            if((rear == n - 1 && front == 0) || (front == rear + 1))
            {
                printf("Queue Overflow\n");
            }
            else if(rear == n - 1 && front != 0)
            {
                rear = 0;
                int enq;
                printf("Value you want to enqueue: ");
                scanf("%d", &enq);
                queue[rear] = enq; 
                if(front == -1)
                {
                    front = 0;
                }
            }
            else
            {
                int enq;
                printf("Value you want to enqueue: ");
                scanf("%d", &enq);
                if(rear == -1)
                {
                    rear = 0;
                    front = 0;
                }
                else
                {
                    rear++;
                }
                queue[rear] = enq;
            }


            if(rear >= front)
            {
                for(int i = front; i <= rear; i++)
                {
                    printf("%d ", queue[i]);
                }
            }
            else if(front>rear)
            {
                for(int i = front; i <=n-1; i++)
                {
                    printf("%d ", queue[i]);
                }
                for(int i = 0; i <= rear; i++)
                {
                    printf("%d ", queue[i]);
                }
            }


        }
        else if(option == 2)
        {
            if(front == -1)
            {
                printf("Queue Underflow\n");
            }
            else
            {
                if(front == rear)
                {
                    front = -1;
                    rear = -1;
                }
                else if(front == n - 1)
                {
                    front = 0;
                }
                else
                {
                    front++;
                }
            }

            if(rear >= front)
            {
                for(int i = front; i <= rear; i++)
                {
                    printf("%d ", queue[i]);
                }
            }
            else if(front>rear)
            {
                for(int i = front; i <=n-1; i++)
                {
                    printf("%d ", queue[i]);
                }
                for(int i = 0; i <= rear; i++)
                {
                    printf("%d ", queue[i]);
                }
            }


        }
        else if(option == 3)
        {
            if(front == -1)
            {
                printf("Queue is empty\n");
            }
            else
            {
                printf("Not empty\n");
            }

        }
        else if(option == 4)
        {
            if((rear == n - 1 && front == 0) || (front == rear + 1))
            {
                printf("Queue is full\n");
            }
            else
            {
                printf("Not full\n");
            }

        }
        else if(option == 0)
        {
            break;
        }
    }

    return 0;
}
