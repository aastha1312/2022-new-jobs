import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}

class LinkedList {
    static Node head;
    static Node lastNode;

    public static void addToTheLast(Node node) {

        if (head == null) {
            head = node;
            lastNode = node;
        } else {
            Node temp = head;
            lastNode.next = node;
            lastNode = node;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n, K;
            n = sc.nextInt();
            K = sc.nextInt();

            Node head = null;
            int val = sc.nextInt();
            head = new Node(val);
            addToTheLast(head);

            for (int i = 1; i < n; i++) {
                val = sc.nextInt();
                addToTheLast(new Node(val));
            }

            Node before[] = new Node[n];
            addressstore(before, head);
            GFG obj = new GFG();

            head = obj.swapkthnode(head, n, K);

            Node after[] = new Node[n];
            addressstore(after, head);

            if (check(before, after, n, K) == true)
                System.out.println("1");
            else
                System.out.println("0");

        }
    }

    static boolean check(Node before[], Node after[], int num, int K) {
        if (K > num)
            return true;

        return (before[K - 1] == after[num - K]) && (before[num - K] == after[K - 1]);


    }

    static void addressstore(Node arr[], Node head) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            arr[i] = temp;
            i++;
            temp = temp.next;
        }
    }

}

class GFG {
    //Function to swap Kth node from beginning and end in a linked list.
    Node swapkthnode(Node headOriginal, int num, int k) {
        int nodeOnePosition = k;
        int nodeTwoPosition = num - k + 1;

        Node head = headOriginal;
        System.out.println(headOriginal);

        Node one = null;
        Node two = null;

        int onNode = 0;
        if (num >= k && (num != (2 * k) - 1)) {
            while (head != null) {
                onNode = onNode + 1;
                if (onNode == nodeOnePosition) {
                    one = head;
                } else {
                    if (onNode == nodeTwoPosition) {
                        two = head;
                    }
                }
                head = head.next;
            }
            int temp = one.data;
            one.data = two.data;
            two.data = temp;


        }
        System.out.println(headOriginal);

        return headOriginal;

    }

    int countNodes(Node head) {
        int count = 0;
        Node s = head;
        while (s != null) {
            count++;
            s = s.next;
        }
        return count;
    }
}
