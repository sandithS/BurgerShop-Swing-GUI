package BurgerShop;

public class List {

    private Node first;

    public void addFirst(Burger customer) {
        Node n1 = new Node(customer);
        n1.next = first;
        first = n1;
    }

    public void addLast(Burger customer) {
        if (first == null) {
            addFirst(customer);
        } else {
            Node n1 = new Node(customer);
            Node temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n1;
        }
    }

    public void add(Burger customer) {
        addLast(customer);
    }

    public boolean add(int index, Burger customer) {
        if (index >= 0 && index <= size()) {
            if (index == 0) {
                addFirst(customer);
            } else {
                Node n1 = new Node(customer);
                int i = 0;
                Node temp = first;
                while (i < index - 1) {
                    i++;
                    temp = temp.next;
                }
                n1.next = temp.next;
                temp.next = n1;
            }
            return true;
        }
        return false;
    }

    public Burger remove(int index) {
        if (index >= 0 && index < size()) {
            if (index == 0) {
                return removeFirst();
            } else {
                int i = 0;
                Node temp = first;
                while (i < index - 1) {
                    i++;
                    temp = temp.next;
                }
                Burger customer = temp.next.customer;
                temp.next = temp.next.next;
                return customer;
            }
        }
        return null;
    }

    public Burger get(int index) {
        if (index >= 0 && index < size()) {
            if (index == 0) {
                return first.customer;
            } else {
                int i = 0;
                Node temp = first;
                while (i < index) {
                    i++;
                    temp = temp.next;
                }
                return temp.customer;
            }
        }
        return null;
    }

    public boolean remove(Burger customer) {
        return remove(indexOf(customer)) != null;
    }

    public int indexOf(Burger customer) {
        Node temp = first;
        int index = 0;
        while (temp != null) {
            if (customer.equals(temp.customer)) {
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }

    public boolean contains(Burger customer) {
        return indexOf(customer) != -1;
    }

    public Burger removeFirst() {
        if (!isEmpty()) {
            Burger customer = first.customer;
            first = first.next;
            return customer;
        }
        return null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public Burger[] toArray() {
        Burger[] customerArray = new Burger[size()];
        Node temp = first;
        for (int i = 0; i < customerArray.length; i++) {
            customerArray[i] = temp.customer;
            temp = temp.next;
        }
        return customerArray;
    }

    public int size() {
        int count = 0;
        Node temp = first;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void printCustomerList() {
        System.out.print("{");
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.customer + "  -  ");
            temp = temp.next;
        }
        System.out.println("\b\b}");
    }

    public boolean set(Burger customer) { //replace
        int index = indexOf(customer);
        if (index == -1) {
            return false;
        }
        if (index == 0) {
            first.customer = customer;
            return true;
        }
        int i = 0;
        Node temp = first;
        while (i < index) {
            i++;
            temp = temp.next;
        }
        temp.customer = customer;
        return true;
    }

    class Node {

        private Burger customer;
        private Node next;

        private Node(Burger customer) {
            this.customer = customer;
        }
    }
}
