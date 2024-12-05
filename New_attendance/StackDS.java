public class StackDS {
     public static class Node{
         int data;
         Node next;
         Node( int data){
             this.data= this.data;
             next=null;
         }
        static  class  stack{
             public  static Node head=null;
             public  static Node current=null;
             public static void push(int data){
                 Node newnode=new Node(data);

                 if(isEmpty()){
                    head=newnode;
                    current =head;
                    return;
                 }
                 current.next=newnode;
                 current=newnode;
             }
             public static boolean isEmpty(){
                 return head==null;
             }
             public static int pop(){
                 if(isEmpty()){
                     return -1;
                 }
                 Node top=head;
                 head=head.next;
                 top.next=null;
                 return top.data;
             }
        }

         public static void main(String[] args) {
             stack.push(10);
             stack.push(20);
             stack.push(30);
             while(stack.isEmpty()){
                 System.out.println(stack.pop());
             }
         }
     }

}
