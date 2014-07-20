#include <iostream>
#include <memory>

using namespace std;

class Node {
public:
    int data;
    Node* next;
    Node(int value) {
        data = value;
        next = nullptr;
    }
};

class LinkedList {
public:
    Node* head = nullptr;

    void addFront(int value) {
        if (head == nullptr) {
            head = new Node(value);
        } else {
            Node* temp = new Node(value);
            temp->next = head;
            head = temp;
        }
    }

    void print() {
        Node* temp= head;
        while (temp != nullptr) {
            cout << temp->data << "\t";
            temp = temp->next;
        }
        cout << endl;
    }
};

void merge(Node* l1, Node* l2) {
    Node* ptr1 = l1; 
    Node* ptr2 = l2; 
    
    Node* head = ptr1;
    Node* prev = head;
    
    while (ptr1 != nullptr && ptr2 != nullptr) {
        if (ptr1->data > ptr2->data) {
            Node* temp = ptr2;
            ptr2 = ptr2->next;
            if (head == ptr1) {
                head = temp;
            } else {
                prev->next = temp;
            }
            temp->next = ptr1;
            prev = temp;
        } else {
            prev = ptr1;
            ptr1 = ptr1->next;
        }
    }
    if (ptr2 != nullptr) {
        prev->next = ptr2;
    }
    
    while(head) { cout << head->data << "\t"; head = head->next;}
}

int main() {
    LinkedList l1;
    l1.addFront(30);
    l1.addFront(20);
    l1.addFront(10);
    l1.print();
    
    LinkedList l2;
    l2.addFront(35);
    l2.addFront(25);
    l2.addFront(15);
    l2.print();

    merge(l1.head, l2.head);
}

