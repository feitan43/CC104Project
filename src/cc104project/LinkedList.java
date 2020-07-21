package cc104project;

import java.util.NoSuchElementException;


public class LinkedList {

    private Node head;
    private int listCount;

  
    public LinkedList() {
        head = new Node(null);
        listCount = 0;
    }


    public void append(Reservation reservation) {
        Node listTemp = new Node(reservation);
        Node listCurrent = head;

        while (listCurrent.getNextNode() != null) {
            listCurrent = listCurrent.getNextNode();
        }

        listCurrent.setNextNode(listTemp);
        listCount++;
    }


    public boolean isEmpty() {
        return listCount == 0;
    }

 
    public boolean removeIndex(int index) {

        Node listCurrent = head;
        for (int i = 1; i < index; i++) {
            if (listCurrent.getNextNode() == null) {
                return false;
            }

            listCurrent = listCurrent.getNextNode();
        }
        listCurrent.setNextNode(listCurrent.getNextNode().getNextNode());
        listCount--; 
        return true;
    }

    public int size() {
        return listCount;
    }

    public Reservation get(int index) {
        if (index < 0) {
            return null;
        }

        Node current = head.getNextNode();
        for (int i = 0; i < index; i++) {
            if (current.getNextNode() == null) {
                return null;
            }

            current = current.getNextNode();
        }
        return current.getrObject();
    }

    public ListIterator listIterator() {
        return new LinkedListIterator();
    }

    @Override
    public String toString() {
        Node listCurrent = head.getNextNode();
        String output = "";
        while (listCurrent != null) {
            output += "[" + listCurrent.getrObject().toString() + "]";
            listCurrent = listCurrent.getNextNode();
        }
        return output;
    }

    class LinkedListIterator implements ListIterator {
 
        private Node position;
        private Node previous;
        private boolean isAfterNext;

        public LinkedListIterator() {
            position = null;
            previous = null;
            isAfterNext = false;
        }

        @Override
        public Reservation next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            isAfterNext = true;

            if (position == null) {
                position = head;
            } else {
                position = position.nextNode;
            }

            return position.rObject;
        }

        @Override
        public boolean hasNext() {
            if (position == null) {
                return head != null;
            } else {
                return position.nextNode != null;
            }
        }

        @Override
        public void makeNewReservation(Reservation element) {
            if (isEmpty() == true) 
            {
              
                add(element); 
            } else {
                position = head;
                for (int i = 0; i < size(); i++) {
                    String eTime = element.rtime.replaceAll(":", "");
                    String pTime = position.nextNode.rObject.rtime.replaceAll(":", "");

                    int eTimeInt = Integer.parseInt(eTime);
                    int pTimeInt = Integer.parseInt(pTime);

                    if (i == (size() - 1) && pTimeInt < eTimeInt) {
                        append(element);
                        break;
                    }

                    if (pTimeInt >= eTimeInt) {
                        add(element);
                        break;
                    } else {
                        next();
                    }
                }
            }
        }

        @Override
        public void add(Reservation element) {
            if (position == null)
            {
                append(element);
                position = head;
            } else
            {
                Node newNode = new Node(null);  
                newNode.rObject = element;      
                newNode.nextNode = position.nextNode; 
                position.nextNode = newNode;         
                position = newNode;                  
                listCount++;
               
            }

            isAfterNext = false;
        }

        @Override
        public void remove() {
            if (!isAfterNext) {
                throw new IllegalStateException();
            }
            if (position == head) {
                removeIndex(0);
            } else {
                previous.nextNode = position.nextNode;
            }
            position = previous;
            isAfterNext = false;
            listCount--;
        }

        @Override
        public void set(Reservation element) {
            if (!isAfterNext) {
                throw new IllegalStateException();
            }
            position.rObject = element;
        }
    }

    class Node {

        Node nextNode;           
        Reservation rObject; 

   
        public Node(Reservation reservation) {
            nextNode = null;
            rObject = reservation;
        }

        public Node(Reservation reservation, Node next) {
            nextNode = next;
            rObject = reservation;
        }

     
        public Reservation getrObject() {
            return rObject;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setrObject(Reservation rObject) {
            this.rObject = rObject;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

    }
}
